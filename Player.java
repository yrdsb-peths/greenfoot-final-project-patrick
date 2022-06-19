import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main player. On the first level player only has a spear. 
 * After passing level 1 they obtain a bow.
 * After passing level 3 they gain the ability to dash.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class Player extends SmoothMover
{
    public static int health = 3; // variable is static because player's health to carry on across each level
    private double speed = 2.6, scale = 2.5;
    private int healthBar_dy = -45, id = -1;
    private int idle_size = 4, idle_index = 0;
    private int run_size = 4, run_index = 0;
    private int actCount = 0;
    private int level; // current level player is in
    private int spear_dx = 13, spear_dy = 0; // offsets for the spear positioning
    private int bow_dx = 12, bow_dy = 17;
    private boolean facingRight = false;
    private boolean isDashing = false;
    private int dashLength = 0; // counter to keep track of how a dash has lasted
    private String curWeapon = "spear"; // player always starts a level with the spear
    GreenfootImage[] idleFacingRight = new GreenfootImage[idle_size];
    GreenfootImage[] idleFacingLeft = new GreenfootImage[idle_size];
    GreenfootImage[] runFacingRight = new GreenfootImage[run_size];
    GreenfootImage[] runFacingLeft = new GreenfootImage[run_size];
    SimpleTimer dashTimer = new SimpleTimer();
    SimpleTimer hitByEnemyTimer = new SimpleTimer(); // provides invicibility frames for player once hit
    GreenfootSound dashSound = new GreenfootSound("./sounds/dash1.mp3");
    GreenfootSound hitSound = new GreenfootSound("./sounds/player-hit.mp3");
    
    public Player() {        
        // initialize sprites
        for (int i = 0; i < idle_size; i++) {
            idleFacingRight[i] = new GreenfootImage("./sprites/player/lizard_m_idle_anim_f" + i + ".png");
            idleFacingRight[i].scale((int)(idleFacingRight[i].getWidth() * scale), (int)(idleFacingRight[i].getHeight() * scale));
            idleFacingLeft[i] = new GreenfootImage("./sprites/player/lizard_m_idle_anim_f" + i + ".png");
            idleFacingLeft[i].scale((int)(idleFacingLeft[i].getWidth() * scale), (int)(idleFacingLeft[i].getHeight() * scale));
            idleFacingLeft[i].mirrorHorizontally();
        }
        for (int i = 0; i < run_size; i++) {
            runFacingRight[i] = new GreenfootImage("./sprites/player/lizard_m_run_anim_f" + i + ".png");
            runFacingRight[i].scale((int)(runFacingRight[i].getWidth() * scale), (int)(runFacingRight[i].getHeight() * scale));
            runFacingLeft[i] = new GreenfootImage("./sprites/player/lizard_m_run_anim_f" + i + ".png");
            runFacingLeft[i].scale((int)(runFacingLeft[i].getWidth() * scale), (int)(runFacingLeft[i].getHeight() * scale));
            runFacingLeft[i].mirrorHorizontally();
        }
        setImage(idleFacingRight[0]);
        
        // adjust sound volumes
        dashSound.setVolume(40);
        hitSound.setVolume(80);
    }
    
    public void act() {
        actCount++;
        if (actCount == 1) {
            initHealthBar();
        }
        updateHealthBar();
        moveHealthBar();
        move();
        selectWeapon();
        moveWeapon();
        if (((GameWorld) getWorld()).level >= 4) {
            checkDashing();
            if (isDashing) {
                dash();
            }    
        }
        checkHitByEnemy();
    }
    
    /**
     * Checks for movement input - WASD.
     */
    public void move() {
        int dx = 0, dy = 0;
        if (Greenfoot.isKeyDown("w")) {
            dy -= speed;
            runAnimate();
        }
        if (Greenfoot.isKeyDown("a")) {
            facingRight = false;
            dx -= speed;
            runAnimate();
        }
        if (Greenfoot.isKeyDown("s")) {
            dy += speed;
            runAnimate();
        }
        if (Greenfoot.isKeyDown("d")) {
            facingRight = true;
            dx += speed;
            runAnimate();
        }if (!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("d") && !Greenfoot.isKeyDown("space")) {
            idleAnimate();
        }
        setLocation(getX() + dx, getY());

        // check wall collision
        if (getOneIntersectingObject(Wall.class) != null)
            setLocation(getX() - dx, getY());
        setLocation(getX(), getY() + dy);
        if (getOneIntersectingObject(Wall.class) != null)
            setLocation(getX(), getY() - dy);
    }
    
    /**
     * Checks for weapon select input - 1 or 2.
     * When a new weapon is selected, the previous weapon is removed from the world and
     * the new one is added in its place.
     */
    public void selectWeapon() {
        if (Greenfoot.isKeyDown("1") && curWeapon == "bow") {
            // switch to spear
            Bow b = getWorld().getObjects(Bow.class).get(0);
            getWorld().removeObject(b);
            Spear s = new Spear();
            getWorld().addObject(s, getX() + spear_dx, getY() + spear_dy);
            curWeapon = "spear";
        }
        else if (Greenfoot.isKeyDown("2") && curWeapon == "spear" && ((GameWorld) getWorld()).level > 1) {
            // switch to bow
            Spear s = getWorld().getObjects(Spear.class).get(0);
            getWorld().removeObject(s);
            Bow b = new Bow();
            getWorld().addObject(b, getX() + bow_dx, getY() + bow_dy);
            curWeapon = "bow";
        }
    }
    
    /**
     * Moves the player's current weapon along with them.
     */
    public void moveWeapon() {
        var spearArr = getWorld().getObjects(Spear.class);
        var bowArr = getWorld().getObjects(Bow.class);
        if (spearArr.size() == 1) {
            Actor spear = spearArr.get(0);    
            spear.setLocation(getX() + spear_dx, getY() + spear_dy);
        }
        else if (bowArr.size() == 1) {
            Actor bow = bowArr.get(0);    
            bow.setLocation(getX() + bow_dx, getY() + bow_dy);
        }        
    }
    
    /**
     * Checks the current dashing state.
     */
    public void checkDashing() {
        if (Greenfoot.isKeyDown("alt")) {
            dashSound.stop(); dashSound.play();
            isDashing = true;
        }
        else if (dashLength > 25) {
            isDashing = false;
            dashLength = 0;
        }
    }
    
    /**
     * Dashes the player by quickly moving them in the direction of the mouse.
     * Stops dashing once dashLength exceeds a certain amount.
     */
    public void dash() {
        if (dashLength > 25) return;
        
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null)
            turnTowards(mi.getX(), mi.getY());
        for (int i = 0; i < 4; i++) {
            move(speed + 2);
            dashLength++;
        }
        // turn back
        setRotation(0); 
    }      
    
    /**
     * Initializes a health bar.
     */
    public void initHealthBar() {
        HealthBar bar = new HealthBar(health, id);
        getWorld().addObject(bar, getX(), getY() + healthBar_dy);
    }
    
    /**
     * Grabs the health bar using getObjectsAtOffset().
     * A corner case occurs when the character is at the far top edge of the map, causing the health bar to 
     * compress downwards and getObjectsAtOffset() to fail. In this case, use getObjectsInRange() to grab
     * the health bar.
     */
    public HealthBar getHealthBar() {
        // sometimes enemies are stacked on top of each other and multiple health bars are retrieved
        // and getObjectsAtOffset().get(0) gets the wrong health bar if they are too close
        // in these cases, ids are necessary for grabbing the correct health bar
        var arr = getObjectsAtOffset(0, healthBar_dy, HealthBar.class);
        var arr2 = getObjectsInRange(20, HealthBar.class);
        HealthBar res = null;
        if (arr.size() >= 1) {
            // loop through the multiple health bars and determine the right one
            for (HealthBar bar : arr) {
                if (bar.id == id) res = bar;
            }
        }
        else if (arr2.size() >= 1) {
            for (HealthBar bar : arr2) {
                if (bar.id == id) res = bar;
            }
        }
        
        return res;
    }
    
    /**
     * Updates the amount of health in the health bar.
     */
    public void updateHealthBar() {
        HealthBar bar = getHealthBar();
        if (bar != null) bar.update(health);
    }
    
    /**
     * Moves the health bar along with the enemy.
     * 
     */
    public void moveHealthBar() {
        HealthBar bar = getHealthBar();
        if (bar != null) bar.setLocation(getX(), getY() + healthBar_dy);
    }
    
    /**
     * Removes the health bar.
     */
    public void removeHealthBar() {
        HealthBar bar = getHealthBar();
        if (bar != null) getWorld().removeObject(bar);
    }
    
    /**
     * Checks if player has been hit bit by an enemy projectile or if player
     * has touched an enemy.
     * Loses 1 life if so.
     */
    public void checkHitByEnemy() {
        if (getWorld() == null) return;
        
        if (isTouching(EnemyProjectile.class) && hitByEnemyTimer.millisElapsed() > 2500) {
            hitSound.stop(); hitSound.play();
            GameWorld world = (GameWorld) getWorld();
            if (health - 1 <= 0) {
                world.gameOver();
            }
            else health--; // don't always decrement health unlike the enemies. If player dies and hits "Reset" they can start with 1 hp.
            // remove enemy projectile
            EnemyProjectile e = (EnemyProjectile) getOneIntersectingObject(EnemyProjectile.class);
            world.removeObject(e);
            
            hitByEnemyTimer.mark();
        }
        
        if (isTouching(Enemy.class) && hitByEnemyTimer.millisElapsed() > 2500) {
            hitSound.stop(); hitSound.play();
            GameWorld world = (GameWorld) getWorld();
            if (health - 1 <= 0) {
                world.gameOver();
            }
            else health--;
            
            hitByEnemyTimer.mark();
        }
    }
    
    public void idleAnimate() {
        if (actCount % 9 == 0) {
            if (facingRight) setImage(idleFacingRight[idle_index]);
            else setImage(idleFacingLeft[idle_index]);
            idle_index++;
            idle_index %= idle_size;
        }
    }
    
    public void runAnimate() {
        if (actCount % 7 == 0) {
            if (facingRight) setImage(runFacingRight[run_index]);
            else setImage(runFacingLeft[run_index]);
            run_index++;
            run_index %= run_size;
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int speed = 2;
    private boolean facingRight = false;
    private int idle_size = 4, idle_index = 0;
    private int run_size = 4, run_index = 0;
    private int actCount = 0;
    private int level;
    private int spear_dx = 13, spear_dy = 0;
    private int bow_dx = 12, bow_dy = 17;
    private double scale = 2.5;
    private String curWeapon = "spear"; // player always starts a level with the spear
    GreenfootImage[] idleFacingRight = new GreenfootImage[idle_size];
    GreenfootImage[] idleFacingLeft = new GreenfootImage[idle_size];
    GreenfootImage[] runFacingRight = new GreenfootImage[run_size];
    GreenfootImage[] runFacingLeft = new GreenfootImage[run_size];
    
    public Player(int level) {
        this.level = level;
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
    }
    
    public void act()
    {
        actCount++;
        move();
        selectWeapon();
        moveWeapon();
        checkTouchingEnemy();
    }
    
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
        }
        if (!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("d") && !Greenfoot.isKeyDown("space")) {
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
    
    public void selectWeapon() {
        if (Greenfoot.isKeyDown("1") && curWeapon == "bow") {
            // switch to spear
            Bow b = getWorld().getObjects(Bow.class).get(0);
            getWorld().removeObject(b);
            Spear s = new Spear();
            getWorld().addObject(s, getX() + spear_dx, getY() + spear_dy);
            curWeapon = "spear";
        }
        else if (Greenfoot.isKeyDown("2") && curWeapon == "spear" && level > 1) {
            // switch to bow
            Spear s = getWorld().getObjects(Spear.class).get(0);
            getWorld().removeObject(s);
            Bow b = new Bow();
            getWorld().addObject(b, getX() + bow_dx, getY() + bow_dy);
            curWeapon = "bow";
        }
    }
    
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
    
    public void checkTouchingEnemy() {
        if (getWorld() == null) return;
        if (isTouching(Enemy.class)) {
            GameWorld world = (GameWorld) getWorld();
            world.gameOver();
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
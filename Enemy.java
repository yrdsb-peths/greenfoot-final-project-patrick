import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Super class of all types of enemies. Contains all necessary info such as their id, an actCount, 
 * speed, scale, and health. Since all enemy sprites came from the same package, they all share
 * same animation sizes of 4 images for idle and run. 
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Enemy extends SmoothMover {
    public String type;
    public int id;
    public int actCount = 0;
    public double speed, scale;
    public int health, healthBar_dy = -45;
    public int idle_size = 4, idle_index = 0;
    public int run_size = 4, run_index = 0;
    public boolean facingRight;
    GreenfootImage[] idleFacingRight = new GreenfootImage[idle_size];
    GreenfootImage[] idleFacingLeft = new GreenfootImage[idle_size];
    GreenfootImage[] runFacingRight = new GreenfootImage[run_size];
    GreenfootImage[] runFacingLeft = new GreenfootImage[run_size];
    
    /**
     * Sets the type of enemy, its id, health, speed, and scale.
     * Uses the type of enemy to get the sprite path.
     * 
     * @param type      the type of enemy
     * @param id        enemy's id
     * @param health    enemy's health
     * @param speed     enemy's move speed
     * @param scale     amoun to scale enemy's size by
     */
    public Enemy(String type, int id, int health, double speed, double scale) {
        this.type = type;
        this.id = id;
        this.health = health;
        this.speed = speed;
        this.scale = scale;
        String idlePath = "./sprites/" + type + "/" + type + "_idle_anim_f";
        String runPath = "./sprites/" + type + "/" + type + "_run_anim_f";
        // initialize sprites
        for (int i = 0; i < idle_size; i++) {
            idleFacingRight[i] = new GreenfootImage(idlePath + i + ".png");
            idleFacingRight[i].scale((int)(idleFacingRight[i].getWidth() * scale), (int)(idleFacingRight[i].getHeight() * scale));
            idleFacingLeft[i] = new GreenfootImage(idlePath + i + ".png");
            idleFacingLeft[i].scale((int)(idleFacingLeft[i].getWidth() * scale), (int)(idleFacingLeft[i].getHeight() * scale));
            idleFacingLeft[i].mirrorHorizontally();
        }
        for (int i = 0; i < run_size; i++) {
            runFacingRight[i] = new GreenfootImage(runPath + i + ".png");
            runFacingRight[i].scale((int)(runFacingRight[i].getWidth() * scale), (int)(runFacingRight[i].getHeight() * scale));
            runFacingLeft[i] = new GreenfootImage(runPath + i + ".png");
            runFacingLeft[i].scale((int)(runFacingLeft[i].getWidth() * scale), (int)(runFacingLeft[i].getHeight() * scale));
            runFacingLeft[i].mirrorHorizontally();
        }

        setImage(idleFacingRight[0]);
    }
    
    /**
     * Always updates enemy's health bar.
     */
    public void act() {
        actCount++;
        if (actCount == 1) {
            initHealthBar();
        }
        updateHealthBar();
        moveHealthBar();
        checkFacingDirection();
    }
    
    /**
     * Initializes a health bar for the enemy.
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
     * Checks whether the enemy should face left or right depending on where it is relative to the player.
     */
    public void checkFacingDirection() {
        Player player = getWorld().getObjects(Player.class).get(0);
        if (this.getX() < player.getX())
            facingRight = true;
        else facingRight = false;
    }
    
    public void idleAnimate() {
        if (this.actCount % 8 == 0) {
            if (facingRight) setImage(idleFacingRight[idle_index]);
            else setImage(idleFacingLeft[idle_index]);
            idle_index++;
            idle_index %= idle_size;
        }
    }
    
    public void runAnimate() {
        if (actCount % 8 == 0) {
            if (facingRight) setImage(runFacingRight[run_index]);
            else setImage(runFacingLeft[run_index]);
            run_index++;
            run_index %= run_size;
        }
    }
}

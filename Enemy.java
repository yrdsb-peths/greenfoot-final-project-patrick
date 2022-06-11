import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Enemy extends SmoothMover {
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
    
    public Enemy(int health, String type, double speed, double scale) {
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
    }
    
    public void act() {
        actCount++;
        if (actCount == 1) {
            initHealthBar();
        }
        updateHealthBar();
        moveHealthBar();
        checkFacingDirection();
    }
    
    public void initHealthBar() {
        HealthBar bar = new HealthBar(health);
        getWorld().addObject(bar, getX(), getY() + healthBar_dy);
    }
    
    public void updateHealthBar() {
        // get the health bar
        var arr = getObjectsAtOffset(0, healthBar_dy, HealthBar.class);
        if (arr.size() == 1) {
            HealthBar bar = arr.get(0);
            bar.update(health);    
        }
    }
    
    public void moveHealthBar() {
        // get the health bar
        var arr = getObjectsAtOffset(0, healthBar_dy, HealthBar.class);
        if (arr.size() == 1) {
            HealthBar bar = arr.get(0);
            bar.setLocation(getX(), getY() + healthBar_dy);
        }
    }
    
    public void removeHealthBar() {
        var arr = getObjectsAtOffset(0, healthBar_dy, HealthBar.class);
        if (arr.size() >= 1) {
            // sometimes getObjectsAtOffset may grab the wrong enemy's health bar if they are stacked on top of each other
            // since this case only occurs with multiple imps in the stage, just remove all health bars grabbed because they imps will likely all die
            for (HealthBar bar : arr) {
                getWorld().removeObject(bar);
            }
        }
    }
    
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

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shaman here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Shaman extends Enemy
{
    private int speed = 3;
    private int stepsTaken = 0;
    private int idle_size = 4, idle_index = 0;
    private int run_size = 4, run_index = 0;
    private int actCount = 0;
    private double scale = 3.5;
    private boolean facingRight;
    String pattern, curDirection;
    GreenfootImage[] idleFacingRight = new GreenfootImage[idle_size];
    GreenfootImage[] idleFacingLeft = new GreenfootImage[idle_size];
    GreenfootImage[] runFacingRight = new GreenfootImage[run_size];
    GreenfootImage[] runFacingLeft = new GreenfootImage[run_size];
    SimpleTimer moveTimer = new SimpleTimer();
    
    public Shaman(int health, String pattern, boolean facingRight) {
        super(health);
        this.pattern = pattern;
        this.facingRight = facingRight;
        if (pattern == "vertical") {
            curDirection = "up";
        }
        else if (pattern == "horizontal") {
            curDirection = "left";   
        }
        // init sprites
        for (int i = 0; i < idle_size; i++) {
            idleFacingRight[i] = new GreenfootImage("./sprites/orc-shaman/orc_shaman_idle_anim_f" + i + ".png");
            idleFacingRight[i].scale((int)(idleFacingRight[i].getWidth() * scale), (int)(idleFacingRight[i].getHeight() * scale));
            idleFacingLeft[i] = new GreenfootImage("./sprites/orc-shaman/orc_shaman_idle_anim_f" + i + ".png");
            idleFacingLeft[i].scale((int)(idleFacingLeft[i].getWidth() * scale), (int)(idleFacingLeft[i].getHeight() * scale));
            idleFacingLeft[i].mirrorHorizontally();
        }
        for (int i = 0; i < run_size; i++) {
            runFacingRight[i] = new GreenfootImage("./sprites/orc-shaman/orc_shaman_run_anim_f" + i + ".png");
            runFacingRight[i].scale((int)(runFacingRight[i].getWidth() * scale), (int)(runFacingRight[i].getHeight() * scale));
            runFacingLeft[i] = new GreenfootImage("./sprites/orc-shaman/orc_shaman_run_anim_f" + i + ".png");
            runFacingLeft[i].scale((int)(runFacingLeft[i].getWidth() * scale), (int)(runFacingLeft[i].getHeight() * scale));
            runFacingLeft[i].mirrorHorizontally();
        }
        if (facingRight) setImage(idleFacingRight[0]);
        else setImage(idleFacingLeft[0]);
    }
    
    public void act()
    {
        actCount++;
        if (actCount == 1) {
            initHealthBar(); // cannot do this in constructor since initHealthBar() requires the enemy to already be constructed in the world
        }
        move();
        if (pattern == "none" || pattern == "vertical")
            idleAnimate();
        else if (pattern == "horizontal")
            runAnimate();
        if (actCount % 220 == 0) {
            fire();
        }
        moveHealthBar();
        updateHealthBar();
    }
    
    public void move() {
        if (moveTimer.millisElapsed() > 10) {
            int dx = 0, dy = 0;
            switch (curDirection) {
                case "up": {
                    dy -= speed;
                    break;
                }
                case "down":
                    dy += speed;
                    break;
                case "left":
                    dx -= speed;
                    break;
                case "right":
                    dx += speed;
                    break;
            }
            setLocation(getX() + dx, getY() + dy);
            stepsTaken++;
            if (stepsTaken == 60) {
                // switch direction
                switch (curDirection) {
                    case "up":
                        curDirection = "down";
                        break;
                    case "down":
                        curDirection = "up";
                        break;
                    case "left":
                        curDirection = "right";
                        break;
                    case "right":
                        curDirection = "left";
                        break;
                }
                stepsTaken = 0;
            }
            moveTimer.mark();
        }
    }
    
    public void fire() {
        GameWorld world = (GameWorld) getWorld();
        ShamanBall b = new ShamanBall();
        world.addObject(b, getX(), getY());
    }
    
    public void idleAnimate() {
        if (actCount % 7 == 0) {
            if (curDirection == "right") setImage(idleFacingRight[idle_index]);
            else setImage(idleFacingLeft[idle_index]);
            idle_index++;
            idle_index %= idle_size;
        }
    }
    
    public void runAnimate() {
        if (actCount % 7 == 0) {
            if (curDirection == "right") setImage(runFacingRight[run_index]);
            else setImage(runFacingLeft[run_index]);
            run_index++;
            run_index %= run_size;
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shaman here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Shaman extends Enemy
{
    private int stepsTaken = 0;
    String pattern, curDirection;
    SimpleTimer moveTimer = new SimpleTimer();
    
    public Shaman(int health, double speed, double scale, String pattern, String curDirection) {
        super(health, "shaman", speed, scale);
        this.pattern = pattern;
        this.curDirection = curDirection;
        speed = 3;
        scale = 3;
    }
    
    public void act() {
        super.act();
        move();
        if (pattern == "none" || pattern == "vertical")
            idleAnimate();
        else if (pattern == "horizontal")
            runAnimate();
        if (actCount % 220 == 0) {
            fire();
        }
    }
    
    public void move() {
        if (moveTimer.millisElapsed() > 10) {
            int dx = 0, dy = 0;
            switch (curDirection) {
                case "up":
                    dy -= speed;
                    break;
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
    
    public void runAnimate() {
        if (actCount % 8 == 0) {
            if (curDirection == "right") setImage(runFacingRight[run_index]);
            else setImage(runFacingLeft[run_index]);
            run_index++;
            run_index %= run_size;
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shaman enemy. Moves back and forth at a set interval and shoots a fireball.
 * The fireball initially tracks the player for a few seconds, then travels in a straight line. 
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class Shaman extends Enemy
{
    private int stepsTaken = 0;
    String pattern, curDirection;
    SimpleTimer moveTimer = new SimpleTimer();
    
    /**
     * Sets the id, health, speed, scale, movement patter, and current direction for the shaman.
     * 
     * @param id                the shaman's id
     * @param health            the shaman's health
     * @param speed             the shaman's speed
     * @param scale             amount to scale the shaman's size by
     * @param pattern           the movement pattern of the shaman. Could be "vertical", "horizontal", or "none"
     * @param curDirection      the current direction that the shaman is facing. Could be "up", "right", "down", or "left"
     */
    public Shaman(int id, int health, double speed, double scale, String pattern, String curDirection) {
        super("shaman", id, health, speed, scale);
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
    
    /**
     * Movement for the shaman. Moves according to its current direction.
     * If the number of steps taken in a direction reaches a certain point, the 
     * current direction switches, causing the shaman to move back and forth.
     */
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
    
    /**
     * Fires a fireball.
     */
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

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BallDispenser here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class BallDispenser extends Enemy
{
    String shotDirection;
    private int idle_size = 4, idle_index = 0;
    private int actCount = 0;
    GreenfootImage[] idle = new GreenfootImage[idle_size];
    
    public BallDispenser(boolean killable, String shotDirection) {
        super(killable);
        this.shotDirection = shotDirection;
        // initialize idle sprites
        for (int i = 0; i < idle_size; i++) {
            idle[i] = new GreenfootImage("./sprites/orc-shaman/orc_shaman_idle_anim_f" + i + ".png");
            idle[i].scale((int)(getImage().getWidth() * 3.3), (int)(getImage().getHeight() * 3.3));
        }
    }
    
    public void act() {
        actCount++;
        idleAnimate();
        checkDeath();
    }
    
    public void fireBall() {
        GameWorld world = (GameWorld) getWorld();
        Ball ball = new Ball(shotDirection);
        world.addObject(ball, getX(), getY());
    }
    
    public void idleAnimate() {
        if (actCount % 10 == 0) {
            setImage(idle[idle_index]);
            idle_index++;
            idle_index %= idle_size;
        }
    }
    
    public void checkDeath() {
        if (isTouching(Player.class)) {
            GameWorld world = (GameWorld) getWorld();
            world.removeObject(this);
        }
    }
}

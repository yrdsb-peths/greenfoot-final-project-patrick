import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skeleton here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Skeleton extends Enemy
{
    String shotDirection;
    private int fireRate;
    private boolean autoFire;
    private int idle_size = 4, idle_index = 0;
    private int actCount = 0;
    private double scale = 2.5;
    GreenfootImage[] idle = new GreenfootImage[idle_size];
    
    public Skeleton(String shotDirection, int fireRate, boolean autoFire) {
        this.shotDirection = shotDirection;
        this.fireRate = fireRate;
        this.autoFire = autoFire;
        // initialize idle sprites
        for (int i = 0; i < idle_size; i++) {
            idle[i] = new GreenfootImage("./sprites/skeleton/skelet_idle_anim_f" + i + ".png");
            idle[i].scale((int)(idle[i].getWidth() * scale), (int)(idle[i].getHeight() * scale));
        }
        setImage(idle[0]);
    }
    
    public void act() {
        actCount++;
        idleAnimate();
        if (autoFire) {
            if (actCount % fireRate == 0)
                fire();
        }
    }
    
    public void fire() {
        GameWorld world = (GameWorld) getWorld();
        SkeletonBall b = new SkeletonBall(shotDirection);
        world.addObject(b, getX(), getY());
    }
    
    public void idleAnimate() {
        if (actCount % 10 == 0) {
            setImage(idle[idle_index]);
            idle_index++;
            idle_index %= idle_size;
        }
    }
}

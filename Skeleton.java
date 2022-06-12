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
    
    public Skeleton(int id, int health, double speed, double scale, String shotDirection, int fireRate, boolean autoFire) {
        super("skeleton", id, health, speed, scale);
        this.shotDirection = shotDirection;
        this.fireRate = fireRate;
        this.autoFire = autoFire;
    }
    
    public void act() {
        super.act();
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
}

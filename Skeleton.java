import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Skeletons are immobile enemies that only shoot balls in a single direction.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class Skeleton extends Enemy
{
    String shotDirection;
    private int fireRate;
    private boolean autoFire;
    
    /**
     * Constrcuts a skeleton with its id, health, speed, scale, shotDirection, fireRate, and whether
     * or not it should automatically fire.
     * 
     * @param id                the skeleton's id
     * @param health            the skeleton's health
     * @param speed             the skeleton's speed. Always 0.
     * @param scale             amount to scale the skeleton by
     * @param shotDirection     the direction that the skeleton should be firing in
     * @param fireRate          the skeleton's rate of fire
     * @param autoFire          whether or not the the skeleton should automatically fire
     */
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

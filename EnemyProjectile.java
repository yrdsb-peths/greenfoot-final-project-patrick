import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Subclass of Projectile that only deals with enemies' projectiles.
 * 
 * @ Patrick Hu
 * @version June 2022
 */
public class EnemyProjectile extends Projectile
{
    public double speed;
    public double scale;
    public int actCount = 0;
    
    /**
     * Sets the speed and scale of the projectile
     * 
     * @param speed     speed of projectile
     * @param scale     amount to scale the projectile by
     */
    public EnemyProjectile(double speed, double scale) {
        this.speed = speed;
        this.scale = scale;
    }
    
    public void act() {
        actCount++;
    }
}

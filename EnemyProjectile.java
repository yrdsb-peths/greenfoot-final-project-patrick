import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyProjectile here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class EnemyProjectile extends Projectile
{
    public double speed;
    public double scale;
    public int actCount;
    
    public EnemyProjectile(double speed, double scale) {
        this.speed = speed;
        this.scale = scale;
    }
    
    public void act() {
        actCount++;
    }
}

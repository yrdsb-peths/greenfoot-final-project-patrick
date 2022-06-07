import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyProjectile here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class EnemyProjectile extends Projectile
{
    public void checkPlayerHit()
    {
        if (isTouching(Player.class)) {
            GameWorld world = (GameWorld) getWorld();
            world.gameOver();
        }
    }
}

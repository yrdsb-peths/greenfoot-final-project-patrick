import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBullet extends Bullet
{
    public EnemyBullet() {
        setImage("sprites/bullets/enemyBullet2.png");
        getImage().scale((int)(getImage().getWidth() * scaleLarge), (int)(getImage().getHeight() * scaleLarge));    
    }
    
    public void act()
    {
        checkPlayerHit();    
    }
    
    public void checkPlayerHit() {
        if (isTouching(Player.class)) {
            GameWorld world = (GameWorld)getWorld();
            world.gameOver();
        }
    }
}

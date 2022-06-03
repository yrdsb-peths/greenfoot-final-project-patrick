import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PistolBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PistolBullet extends Bullet
{
    private int speed = 4;
    
    public PistolBullet() {
        setImage("sprites/guns/PNG/small_bullet.png");    
        getImage().scale((int)(getImage().getWidth() * scaleSmall), (int)(getImage().getHeight() * scaleSmall));
    }
    
    public void act()
    {
        checkEnemyHit();
    }
    
    public void checkEnemyHit() {
        if (isTouching(Enemy.class)) {
            removeTouching(Enemy.class);
        }
    }
}

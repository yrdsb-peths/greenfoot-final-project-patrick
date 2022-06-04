import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBullet here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class EnemyBullet extends Bullet
{
    private int speed = 3; // speed needs to be higher than 1 or else loss in accuracy of bullet
    
    public EnemyBullet() {
        setImage("sprites/bullets/enemyBullet2.png");
        getImage().scale((int)(getImage().getWidth() * 2), (int)(getImage().getHeight() * 2));    
    }
    
    public void act()
    {
        move(speed);
        checkPlayerHit();
        checkAtWall();
    }
    
    public void checkPlayerHit() {
        if (isTouching(Player.class)) {
            GameWorld world = (GameWorld)getWorld();
            world.gameOver();
        }
    }
}

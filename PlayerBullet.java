import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerBullet here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class PlayerBullet extends Bullet
{
    private int speed = 6;
    
    public PlayerBullet() {
        setImage("sprites/guns/PNG/small_bullet.png");    
        getImage().scale((int)(getImage().getWidth() * 0.7), (int)(getImage().getHeight() * 0.7));
    }
    
    public void act()
    {
        move(speed);
        checkEnemyHit();
        checkAtWall();
    }
    
    public void checkEnemyHit() {
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if (enemy != null && enemy.killable) {
            removeTouching(Enemy.class);
            GameWorld world = (GameWorld) getWorld();
            world.removeObject(this);
        }
    }
}

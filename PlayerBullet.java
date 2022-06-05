import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerBullet here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class PlayerBullet extends Projectile
{
    private int speed = 6;
    private double scale = 1.2;
    
    public PlayerBullet() {
        setImage("sprites/bow/weapon_arrow.png");    
        getImage().scale((int)(getImage().getWidth() * scale), (int)(getImage().getHeight() * scale));
    }
    
    public void act()
    {
        move(speed);
        checkEnemyHit();
        checkAtWall();
    }
    
    public void checkEnemyHit() {
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if (enemy != null) {
            removeTouching(Enemy.class);
            if (getWorld() == null) return;
            else getWorld().removeObject(this);
        }
    }
}

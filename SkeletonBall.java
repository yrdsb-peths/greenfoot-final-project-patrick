import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The skeleton's projectile.
 * 
 * @author Patrick Hu 
 * @version June 2022
 */
public class SkeletonBall extends EnemyProjectile
{
    String direction;
    
    /**
     * Constructs a skeleton projectile with its travel direction.
     * 
     * @param direction     the direction that the projectile should travel in
     */
    public SkeletonBall(String direction) {
        super(3, 3.2);
        this.direction = direction;
        setImage("./sprites/bullets/skeleton-bullet.png");
        getImage().scale((int)(getImage().getWidth() * scale), (int)(getImage().getHeight() * scale));
    }
    
    public void act() {
        super.act();
        move();
        checkAtWall();
    }
    
    public void move() {
        int dx = 0, dy = 0; 
        switch (direction) {
            case "up":
                dy -= speed;
                break;
            case "down":
                dy += speed;
                break;
            case "left":
                dx -= speed;
                break;
            case "right": 
                dx += speed;
                break;
        }
        setLocation(getX() + dx, getY() + dy);
    }
}

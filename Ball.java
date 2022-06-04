import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Ball extends Projectile
{
    private int speed = 3;
    String direction;
    
    public Ball(String direction) {
        this.direction = direction;
    }
    
    public void act()
    {
        int dx = 0, dy = 0;
        switch (direction) {
            case "up":
                dy -= speed;
            case "down":
                dy += speed;
            case "left":
                dx -= speed;
            case "right": 
                dx += speed;
        }
        setLocation(getX() + dx, getY() + dy);
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * Patrick Hu
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{   
    public void checkAtWall() {
        if (getWorld() == null) return;
        // check if bullet at wall       
        if (isTouching(Wall.class)) {
            getWorld().removeObject(this);
        }
        // check if bullet at edge of world
        // note: short circuit evaluation with getWorld() != null in the condition sometimes fails
        else if (getX() == getWorld().getWidth() - 1 || getX() == 0 || getY() == getWorld().getHeight() - 1 || getY() == 0) {
            getWorld().removeObject(this);    
        }
    }
}

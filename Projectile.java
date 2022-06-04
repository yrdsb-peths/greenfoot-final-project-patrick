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
        GameWorld world = (GameWorld) getWorld();
         // check if bullet at wall
        if (isTouching(WallTile.class)) {
            world.removeObject(this);
        }
        // check if bullet at edge of world
        else if (getX() == world.getWidth() - 1 || getX() == 0 || getY() == world.getHeight() - 1 || getY() == 0) {
            world.removeObject(this);    
        }
    }
}

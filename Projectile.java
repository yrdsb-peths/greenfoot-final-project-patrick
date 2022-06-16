import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class for all projectiles such as arrows and the enemies' attacks. 
 * All projectiles that end up at the edges of the world or hit a wall are removed.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class Projectile extends SmoothMover
{
    public void checkAtWall() {
        if (getWorld() == null) return;
        // check if bullet at wall       
        if (isTouching(Wall.class)) {
            getWorld().removeObject(this);
        }
        // check if bullet at edge of world
        else if (getX() == getWorld().getWidth() - 1 || getX() == 0 || getY() == getWorld().getHeight() - 1 || getY() == 0) {
            getWorld().removeObject(this);    
        }
    }
}

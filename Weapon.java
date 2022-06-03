import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Weapon extends Actor
{   
    public Weapon() {
        
    }
    
    public void act() {
        
    }
    
    public void faceCursor() {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null) {
            turnTowards(mi.getX(), mi.getY());
        }
    }
    
    public void checkFire() {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null && mi.getButton() == 1) {
            Bullet bullet = new Bullet(false);
            GameWorld world = (GameWorld)getWorld();
            world.addObject(bullet, getX() + 10, getY() - 10);     
            bullet.turnTowards(mi.getX(), mi.getY());    
        }
       
    }
}

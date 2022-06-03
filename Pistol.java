import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pistol here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Pistol extends Actor
{    
    public Pistol() {
        setImage("sprites/guns/PNG/pistol.png");
        getImage().scale(30, 30);
    }
    
    public void act()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        
        // turn towards cursor
        if (mi != null) {
            turnTowards(mi.getX(), mi.getY());
        }
        GameInfo.weaponRotation = getRotation();
        
        // check fire
        if (mi != null && mi.getButton() == 1) {
            fire();
        }
    }
    
    public void fire() {
        GameInfo.weaponIsFiring = true;
        MouseInfo mi = Greenfoot.getMouseInfo();
        Bullet bullet = new Bullet(false);
        bullet.setRotation(GameInfo.weaponRotation);
        World world = getWorld();
        // level1 methods not available
        world.addObject(bullet, getX() + 10, getY() - 10);
    }
}

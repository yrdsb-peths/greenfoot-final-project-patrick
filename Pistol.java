import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pistol here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Pistol extends Weapon
{
    
    
    public Pistol(int bulletSpeed, int bulletDmg) {
        super(bulletSpeed, bulletDmg);
        setImage("sprites/guns/PNG/pistol.png");
    }
    
    public void act()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        
        
        checkMovement();
        if (mi != null) {
            turnTowards(mi.getX(), mi.getY());
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pistol here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Pistol extends Actor
{
    private double gunScale = 0.3;
    SimpleTimer fireTimer = new SimpleTimer();
    
    public Pistol() {
        setImage("sprites/guns/PNG/pistol.png");
        getImage().scale((int)(getImage().getWidth() * gunScale), (int)(getImage().getHeight() * gunScale));
    }
    
    public void act()
    {        
        faceCursor();
        fire();
    }
    
    public void fire() {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (Greenfoot.isKeyDown("space") && fireTimer.millisElapsed() > 300) {
            PlayerBullet bullet = new PlayerBullet();
            World world = getWorld();
            world.addObject(bullet, getX() + 10, getY() - 10);     
            bullet.turnTowards(mi.getX(), mi.getY());    
            fireTimer.mark();
        }
       
    }
    
    public void faceCursor() {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null) {
            turnTowards(mi.getX(), mi.getY());
        }
    }
}

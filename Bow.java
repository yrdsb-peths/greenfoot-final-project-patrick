import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pistol here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Bow extends Actor
{
    public static final int STARTING_NUM_ARROWS = 20;
    public static int numArrows = STARTING_NUM_ARROWS;
    private double scale = 2;
    SimpleTimer fireTimer = new SimpleTimer();
    
    public Bow() {
        setImage("sprites/bow/weapon_bow.png");
        getImage().scale((int)(getImage().getWidth() * scale), (int)(getImage().getHeight() * scale));
    }
    
    public void act()
    {        
        faceCursor();
        fire();
    }
    
    public void fire() {
        if (numArrows == 0)
            return;
            
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null && Greenfoot.isKeyDown("space") && fireTimer.millisElapsed() > 300) {
            numArrows--;
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

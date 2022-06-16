import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The bow that the player wields.
 * 
 * @ Patrick Hu
 * @version June 2022
 */
public class Bow extends Actor
{
    public static int numArrows;
    private double scale = 2;
    SimpleTimer fireTimer = new SimpleTimer();
    GreenfootSound fireSound = new GreenfootSound("./sounds/bow-fire.mp3");
    
    public Bow() {
        setImage("sprites/bow/weapon_bow.png");
        getImage().scale((int)(getImage().getWidth() * scale), (int)(getImage().getHeight() * scale));
    }
    
    public void act() {        
        faceCursor();
        fire();
    }
    
    /**
     * Fires an arrow in the direction of the cursor.
     */
    public void fire() {
        if (numArrows == 0)
            return;
                        
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null && Greenfoot.isKeyDown("space") && fireTimer.millisElapsed() > 300) {
            fireSound.stop(); fireSound.play();
            numArrows--;
            Arrow arrow = new Arrow();
            getWorld().addObject(arrow, getX() + 10, getY() - 10);     
            arrow.turnTowards(mi.getX(), mi.getY()); 
            fireTimer.mark();
        }
    }
    
    /**
     * Makes the bow face the cursor.
     */
    public void faceCursor() {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null) {
            turnTowards(mi.getX(), mi.getY());
        }
    }
}

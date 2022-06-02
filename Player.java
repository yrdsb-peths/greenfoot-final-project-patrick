import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public static int speed = 3;
    private boolean facingRight = false;
    private String curWeapon = "";
    
    public Player(String curWeapon) {
        // attach gun to player
        
    }
    
    public void act()
    {
        checkMovement();
    }
    
    public void checkMovement() {        
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - speed);
        }
        if (Greenfoot.isKeyDown("a")) {
            facingRight = false;
            move(speed * -1);
            //runAnimate();
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + speed);
        }
        if (Greenfoot.isKeyDown("d")) {
            facingRight = true;
            move(speed);
            //runAnimate();
        }
        if (!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("d") && !Greenfoot.isKeyDown("space")) {
            //idleAnimate();
        }
    }
}

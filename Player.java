import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * Patrick and Anna 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public int speed = 2;
    public int verticalSpeed = 0;
    public int acceleration = 1;
    public int jumpHeight = -12;
    
    
    public void act() {
        checkMovement();
        checkFalling();
    }
    
    public void checkMovement() {
        if (Greenfoot.isKeyDown("d")) {
            move(speed);
        }
        if (Greenfoot.isKeyDown("a")) {
            move(speed * -1);
        }
        if (Greenfoot.isKeyDown("space") && onGround()) {
            verticalSpeed = jumpHeight;
            fall();
        }
    }
    
    public void fall() {
        setLocation(getX(), getY() + verticalSpeed);
        verticalSpeed += acceleration;
    }
    
    public boolean onGround() {
        Actor below = getOneObjectAtOffset(0, getImage().getHeight() / 2, Platform.class);
        //System.out.println(getY());
        //System.out.println(Level1.HEIGHT);
        //System.out.println();
        return below != null || getY() == Level1.HEIGHT - 1;
    }
    
    public void checkFalling() {
        if (!onGround()) {
            fall();
        }
    }
}

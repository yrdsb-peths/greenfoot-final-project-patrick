import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainObjects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainObjects extends Actor
{
    public int speed = 2;
    public int verticalSpeed = 0;
    public int acceleration = 1;
    
    public void fall() {
        setLocation(getX(), getY() + verticalSpeed);
        verticalSpeed += acceleration;
    }
    
    public boolean isOnGround() {
        Actor below = getOneObjectAtOffset(0, getImage().getHeight() / 2, Platform.class);
        //System.out.println(getY());
        //System.out.println(Level1.HEIGHT);
        //System.out.println();
        return below != null || getY() == Level1.HEIGHT - 1;
    }
    
    public void checkFalling() {
        if (!isOnGround() && !isTouching(Ladder.class)) {
            fall();
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BallDispenser here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class BallDispenser extends Enemy
{
    String shotDirection;
    
    public BallDispenser(boolean killable, String shotDirection) {
        super(killable);
        this.shotDirection = shotDirection;
    }
    
    public void act()
    {
        
    }
}

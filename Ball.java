import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends MainObjects
{
    public int speed = 2;
    public int ladderCount = 0;
    public String prevState = "not on ladder";
    public String curState = "not on ladder";
    
    public void act()
    {        
        Actor ladderBelow = getOneObjectAtOffset(0, 50, Ladder.class);
        if ((isTouching(Ladder.class) && !isOnGround()) || ladderBelow != null) {
            curState = "on ladder";
            setLocation(getX(), getY() + speed);
        }
        else {
            curState = "not on ladder";
            if (curState != prevState) { // ladder was taken
                ladderCount++;
            }
            if (ladderCount % 2 == 0) {
                move(speed * -1);    
            }
            else move(speed);        
        }
        
        prevState = curState;
    }
}

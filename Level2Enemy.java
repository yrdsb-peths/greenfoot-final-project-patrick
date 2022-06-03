import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2Enemy here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Level2Enemy extends Enemy
{
    SimpleTimer moveTimer = new SimpleTimer();

    public void act()
    {
         move();
    }
    
    public void move() {
        if (moveTimer.millisElapsed() > 0) {
            //int dx = getRandomNumber(-10, 10);
            //int dy = getRandomNumber(-10, 10);
            //setLocation(getX() + dx, getY() + dy);
            move(2);
            if (Greenfoot.getRandomNumber(100) < 10) {
                turn(Greenfoot.getRandomNumber(90) - 45);
            }
            if (getX() <= 5 || getX() >= getWorld().getWidth() - 5) {
                turn(180);
            }
            if (getY() <= 5 || getY() >= getWorld().getHeight() - 5) {
                turn(180);
            }
            
            moveTimer.mark();
        }
    }
}

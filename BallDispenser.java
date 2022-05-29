import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BallDispenser here.
 * 
 * Patrick and Anna
 * @version (a version number or a date)
 */
public class BallDispenser extends Actor
{   
    
    SimpleTimer timer = new SimpleTimer();
    
    public void act()
    {
        spawnBall();
        checkWin();
    }
    
    public void spawnBall() {
        Level1 world = (Level1) getWorld();
        if (timer.millisElapsed() > 3000) {
            Ball b = new Ball();
            world.addObject(b, 620, 110);
            timer.mark();
        }
    }
    
    public void checkWin() {
        if (isTouching(Player.class)) {
            Level1 world = (Level1) getWorld();
            world.levelWin();
        }
    }
}

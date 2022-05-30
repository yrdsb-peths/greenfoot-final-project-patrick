import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BallDispenser here.
 * 
 * Patrick and Anna
 * @version (a version number or a date)
 */
public class BallDispenser extends Actor
{   
    public int idle_index = 0;
    public int idle_size = 4;
    SimpleTimer ballTimer = new SimpleTimer();
    SimpleTimer animTimer = new SimpleTimer();
    GreenfootImage[] idleFacingLeft = new GreenfootImage[4];
    
    public BallDispenser() {
        for (int i = 0; i < idle_size; i++) {
            idleFacingLeft[i] = new GreenfootImage("./sprites/city-enemies/turret-idle/tile00" + i + ".png");
            idleFacingLeft[i].mirrorHorizontally();
            idleFacingLeft[i].scale(50, 55);
        }
        setImage(idleFacingLeft[0]);
    }
    
    public void act()
    {
        spawnBall();
        checkWin();
        idleAnimate();
    }
    
    public void spawnBall() {
        Level1 world = (Level1) getWorld();
        if (ballTimer.millisElapsed() > 3000) {
            Ball b = new Ball();
            world.addObject(b, 620, 110);
            ballTimer.mark();
        }
    }
    
    public void checkWin() {
        if (isTouching(Player.class)) {
            Level1 world = (Level1) getWorld();
            world.levelWin();
        }
    }
    
    public void idleAnimate() {
        if (animTimer.millisElapsed() > 80) {
            setImage(idleFacingLeft[idle_index]);
            idle_index++;
            idle_index %= idle_size;
            animTimer.mark();
        }
    }
}

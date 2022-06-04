import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Watermelon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Watermelon extends Actor
{
    private int idle_size = 8, idle_index = 0;
    GreenfootImage[] idle = new GreenfootImage[8];
    SimpleTimer idleTimer = new SimpleTimer();
    
    public Watermelon() {
        for (int i = 0; i < idle_size; i++) {
            idle[i] = new GreenfootImage("./sprites/watermelon/idle" + i + ".png");
            idle[i].scale((int)(getImage().getWidth() * 0.7), (int)(getImage().getHeight() * 0.7));
        }
    }
    
    public void act()
    {
        idleAnimate();
    }
    
    public void idleAnimate() {
        if (idleTimer.millisElapsed() > 150) {
            setImage(idle[idle_index]);
            idle_index++;
            idle_index %= idle_size;
            idleTimer.mark();
        }
    }
}

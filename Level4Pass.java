import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4Pass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4Pass extends LevelPassWorld
{
    private int volume = Soundtrack.castle.getVolume();
    SimpleTimer timer = new SimpleTimer();
    
    public Level4Pass() {
        super(800, 600, 1);
        setBackground("./images/vecna/level4pass.png");
    }
    
    public void act() {
        super.act();
        fadeCastle();
        if (Soundtrack.castle.getVolume() <= 0) {
            Soundtrack.castle.stop();
        }
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Level5());
        }
    }
    
    public void fadeCastle() {
        if (timer.millisElapsed() > 800) {
            Soundtrack.castle.setVolume(volume);
            volume -= 10;
            timer.mark();
        }
    }
}

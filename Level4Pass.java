import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4Pass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4Pass extends LevelPassWorld
{
    private int volume = Soundtrack.mainSoundtrack.getVolume();
    SimpleTimer timer = new SimpleTimer();
    
    public Level4Pass() {
        super(800, 600, 1, 4);
        setBackground("./images/vecna/level4pass.png");
        Soundtrack.mainSoundtrack.play();
    }
    
    public void act() {
        super.act();
        fadeVolume();
        if (volume <= 0) {
            Soundtrack.mainSoundtrack.stop();
        }
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new BigDemonIntroCard());
        }
    }
    
    public void fadeVolume() {
        if (volume < 0) return;
        Soundtrack.mainSoundtrack.setVolume(volume);
        if (timer.millisElapsed() > 500) {
            volume -= 10;
            timer.mark();
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelPassWorld here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class LevelPassWorld extends World
{
    public int actCount = 0;
    private int levelPassed;
    
    public LevelPassWorld(int width, int height, int pixelSize, int levelPassed) {
        super(width, height, pixelSize);
        this.levelPassed = levelPassed;
    }
    
    public void act() {
        actCount++;
        Soundtrack.setVolumes();
        Soundtrack.stopAllExceptMain();
        if (levelPassed >= 1 && levelPassed <= 3) {
            Soundtrack.mainSoundtrack.playLoop();
            // Level4Pass fades the main soundtrack
        }
    }
    
    public void stopped() {
        Soundtrack.mainSoundtrack.pause();    
    }
}

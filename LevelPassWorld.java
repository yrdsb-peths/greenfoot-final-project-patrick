import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass of all level complete worlds.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class LevelPassWorld extends World
{
    public int actCount = 0;
    private int levelPassed;
    
    /**
     * Constructs a level pass world.
     * 
     * @param width         the width of the world
     * @param height        the height of the world
     * @param pixelSize     the pixel size of the world
     * @param levelPassed   the level that has been passed
     */
    public LevelPassWorld(int width, int height, int pixelSize, int levelPassed) {
        super(width, height, pixelSize);
        this.levelPassed = levelPassed;
        
        Soundtrack.setVolumes();
    }
    
    public void act() {
        actCount++;
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

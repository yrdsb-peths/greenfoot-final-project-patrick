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
    
    public LevelPassWorld(int width, int height, int pixelSize) {
        super(width, height, pixelSize);
        Soundtrack.reset();
        Soundtrack.merchant.play();
    }
    
    public void act() {
        actCount++;
        // check that soundtracks are playing properly for levels 1-4
        Soundtrack.setVolumes();
        if (!Soundtrack.castle.isPlaying()) {
            Soundtrack.castle.play();
        }
        if (Soundtrack.nightmareKing.isPlaying()) {
            Soundtrack.nightmareKing.stop();
        }
    }
    
    public void started() {
        Soundtrack.castle.pause();
        Soundtrack.merchant.play();
    }
    
    public void stopped() {
        Soundtrack.merchant.pause();    
    }
}

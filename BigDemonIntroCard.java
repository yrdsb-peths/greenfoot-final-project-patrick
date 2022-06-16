import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Big Demon's intro card before the actual fight.
 * 
 * @author Patrick Hu 
 * @version June 2022
 */
public class BigDemonIntroCard extends World
{
    Image bigDemonText = new Image("./images/vecna/big-demon.png", 1);
    SimpleTimer timer = new SimpleTimer();
    
    public BigDemonIntroCard() {    
        super(800, 600, 1);
        Soundtrack.stopAll();
        // set background colour to black
        GreenfootImage black = new GreenfootImage(800, 600);
        black.setColor(Color.BLACK);
        black.fillRect(0, 0, 800, 600);
        setBackground(black);
        // display "Big Demon" text
        addObject(bigDemonText, getWidth() / 2, getHeight() / 2);
    }
    
    public void act() {
        // play nightmare king soundtrack
        Soundtrack.setVolumes();
        Soundtrack.stopAllExceptNightmareKing();
        Soundtrack.nightmareKing.playLoop();
        if (timer.millisElapsed() > 4000) {
            Greenfoot.setWorld(new Level5());
        }
    }
    
    public void stopped() {
        Soundtrack.nightmareKing.pause();
    }
}

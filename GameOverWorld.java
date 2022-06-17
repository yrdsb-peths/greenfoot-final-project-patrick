import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The game over world where the player is taken once they die.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class GameOverWorld extends World
{    
    private int actCount = 0;
    private int transparency = 255;
    private double scale = 1;
    Image rescueFailedText;
    SimpleTimer timer = new SimpleTimer();
    
    public GameOverWorld() {
        super(800, 600, 1);
        // end castle soundtrack
        Soundtrack.stopAll();
        
        // set background colour to black
        GreenfootImage black = new GreenfootImage(800, 600);
        black.setColor(Color.BLACK);
        black.fillRect(0, 0, 800, 600);
        setBackground(black);
        // display rescue failed text
        rescueFailedText = new Image("./images/vecna/rescue-failed.png", 1);
        addObject(rescueFailedText, getWidth() / 2, getHeight() / 2);
    }
    
    public void act() {
        actCount++;
        // after 3 seconds start fading the text
        if (timer.millisElapsed() > 4000) {
            fadeText();
        }
        if (transparency <= 0) {
            // go back to game start
            Greenfoot.setWorld(new GameStartWorld());
        }
    }
    
    /**
     * Lowers the transparency of the "Rescue Failed" text
     */
    private void fadeText() {
        if (actCount % 6 == 0) {
            transparency -= 15;
        }
        rescueFailedText.getImage().setTransparency(transparency);
    }
}
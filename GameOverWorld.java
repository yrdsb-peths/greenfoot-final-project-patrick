import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The game over world where the player is taken once they die.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
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
        Soundtrack.castle.stop();
        
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
        if (timer.millisElapsed() > 3000) {
            fadeText();
        }
        if (transparency <= 0) {
            Greenfoot.setWorld(new GameStartWorld());
        }
    }
    
    public void fadeText() {
        if (actCount % 6 == 0) {
            transparency -= 15;
        }
        rescueFailedText.getImage().setTransparency(transparency);
    }
}
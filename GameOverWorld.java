import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The game over world where the player is taken once they die.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class GameOverWorld extends World
{    
    private int lastLevel;
    private int actCount = 0;
    private int transparency = 255;
    private double scale = 1;
    // decided not to use lastLevelButton and startOverButton in final product
    // their functionality remains in this class
    // player automatically returns to GameStartWorld upon death
    Image lastLevelButton; 
    Image startOverButton;
    Image rescueFailedText;
    SimpleTimer timer = new SimpleTimer();
    
    public GameOverWorld(int lastLevel) {
        super(800, 600, 1);
        this.lastLevel = lastLevel;
        
        // set background colour to black
        GreenfootImage black = new GreenfootImage(800, 600);
        black.setColor(Color.BLACK);
        black.fillRect(0, 0, 800, 600);
        setBackground(black);
        // display rescue failed text
        rescueFailedText = new Image("./images/vecna/rescue-failed.png", 1);
        addObject(rescueFailedText, getWidth() / 2, getHeight() / 2);
        
        //lastLevelButton = new Image("./images/restart.png", scale);
        //(lastLevelButton, 395, 320);
        //startOverButton = new Image("./images/start-over.png", scale);
        //addObject(startOverButton, 395, 340);
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
    
    /**
     * Checks for the hovering and clicking of a) Button to restart from last level and 
     * b) Button to start over from the level 1. Since these buttons have been decided
     * to be left out of the final product, this method will not be called in act().
     */
    public void checkButtonPress() {
        // restart from last level button hovering
        if (Greenfoot.mouseMoved(lastLevelButton)) {
            lastLevelButton.setImage("./images/restart-green.png");
            lastLevelButton.scale(scale);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(lastLevelButton)) {
            lastLevelButton.setImage("./images/restart.png");
            lastLevelButton.scale(scale);
        }
        
        // start over button hovering
        if (Greenfoot.mouseMoved(startOverButton)) {
            startOverButton.setImage("./images/start-over-orange.png");
            startOverButton.scale(scale);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(startOverButton)) {
            startOverButton.setImage("./images/start-over.png");
            startOverButton.scale(scale);
        }
        
        if (Greenfoot.mouseClicked(lastLevelButton)) {
            switch (lastLevel) {
                case 1:
                    Greenfoot.setWorld(new Level1());
                    break;
                case 2:
                    Greenfoot.setWorld(new Level2());
                    break;
                case 3:
                    Greenfoot.setWorld(new Level3());
                    break;
                case 4:
                    Greenfoot.setWorld(new Level4());
                    break;
                case 5:
                    Greenfoot.setWorld(new Level5());
                    break;
            }
        }
        if (Greenfoot.mouseClicked(startOverButton)) {
            Greenfoot.setWorld(new Level1());
        }
    }
}
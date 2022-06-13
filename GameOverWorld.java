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
    private double scale = 1;
    Image lastLevelButton;
    Image startOverButton;
    
    public GameOverWorld(int lastLevel) {
        super(800, 600, 1);
        this.lastLevel = lastLevel;
        setBackground("./images/game-over.png");
        
        lastLevelButton = new Image("./images/restart.png", scale);
        addObject(lastLevelButton, 395, 320);
        startOverButton = new Image("./images/start-over.png", scale);
        addObject(startOverButton, 395, 380);
    }
    
    public void act() {
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
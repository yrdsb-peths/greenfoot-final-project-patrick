import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The starting screen for the game.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class GameStartWorld extends World
{
    private double scale = 0.7;
    Image title;
    Image startButton;
    
    public GameStartWorld() {
        super(800, 600, 1);
        setBackground("./images/castle2.jpg");
        
        // place the title text and "start game" text
        title = new Image("./images/future-time-splitters/title.png", 1);
        addObject(title, 220, 115);
        startButton = new Image("./images/vecna/start-game.png", scale);
        addObject(startButton, 151, 260);
    }
    
    public void act() {
        if (Greenfoot.mouseMoved(startButton)) {
            startButton.setImage("./images/vecna/start-game-yellow.png");
            startButton.scale(scale);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(startButton)) {
            startButton.setImage("./images/vecna/start-game.png");
            startButton.scale(scale);
        }
        if (Greenfoot.mouseClicked(startButton)) {
            Greenfoot.setWorld(new Instructions());
        }
    }
    
    public void started() {
        Soundtrack.setVolumes();
        Soundtrack.castle.play();
    }
    
    public void stopped() {
        Soundtrack.castle.pause();
    }
}

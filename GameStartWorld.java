import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class startButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameStartWorld extends World
{
    private double scale = 0.7;
    Image title;
    Image startButton;
    
    public GameStartWorld() {
        super(800, 600, 1);
        setBackground("./images/castle2.jpg");
        
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
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class startButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameStartWorld extends World
{
    Image title;
    Image startButton;
    
    public GameStartWorld() {
        super(800, 600, 1);
        setBackground("./images/castle2.jpg");
        
        title = new Image("./images/title.png", 1);
        addObject(title, 220, 115);
        startButton = new Image("./images/start-game.png", 0.6);
        addObject(startButton, 146, 279);
    }
    
    public void act() {
        if (Greenfoot.mouseMoved(startButton)) {
            startButton.setImage("./images/start-game-green.png");
            startButton.scale(0.6);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(startButton)) {
            startButton.setImage("./images/start-game.png");
            startButton.scale(0.6);
        }
        if (Greenfoot.mouseClicked(startButton)) {
            Greenfoot.setWorld(new Level1());
        }
    }
}

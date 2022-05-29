import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWorld extends World
{
    public GameOverWorld()
    {    
        super(Level1.WIDTH, Level1.HEIGHT, 1);
        Label gameOverLabel = new Label("Game Over!", 100);
        addObject(gameOverLabel, Level1.WIDTH / 2, Level1.HEIGHT / 2);
    }
}

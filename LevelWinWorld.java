import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelWinWorld here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class LevelWinWorld extends World
{
    public LevelWinWorld()
    {    
        super(Level1.WIDTH, Level1.HEIGHT, 1);
        Label gameOverLabel = new Label("Level Passed!", 100);
        addObject(gameOverLabel, Level1.WIDTH / 2, Level1.HEIGHT / 2);
    }
}

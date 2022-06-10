import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The game over world where the player is taken once they die.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class GameOverWorld extends World
{    
    public GameOverWorld()
    {    
        super(800, 600, 1);
        Label l = new Label("Game Over!", 40);
        addObject(l, getWidth() / 2, getHeight() / 2); 
    }
}
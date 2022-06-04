import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @ Patrick Hu 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{    
    public GameWorld(int width, int height)
    {    
        super(width, height, 1); 
    }
    
    public void gameOver() {
        Greenfoot.setWorld(new GameOverWorld());
    }
}

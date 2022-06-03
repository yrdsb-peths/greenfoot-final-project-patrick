import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1); 
    }
    
    public void gameOver() {
        Greenfoot.setWorld(new GameOverWorld());
    }
}

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
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(GameWorld.WIDTH, GameWorld.HEIGHT, 1);
        Label l = new Label("game over", 40);
        addObject(l, GameWorld.WIDTH / 2, GameWorld.HEIGHT / 2); 
    }
}
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverWorld here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class GameOverWorld extends World
{    
    public GameOverWorld()
    {    
        super(600, 600, 1);
        Label l = new Label("Game Over!", 40);
        addObject(l, getWidth() / 2, getHeight() / 2); 
    }
}
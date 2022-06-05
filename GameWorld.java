import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @ Patrick Hu 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{    
    public GameWorld(int width, int height, int pixelSize)
    {    
        super(width, height, pixelSize);
        GreenfootImage floor = new GreenfootImage("./sprites/floor/floor_1.png");
        floor.scale((int)(floor.getWidth() * 2), (int)(floor.getHeight() * 2));
        setBackground(floor);
    }
    
    public void gameOver() {
        Greenfoot.setWorld(new GameOverWorld());
    }
}

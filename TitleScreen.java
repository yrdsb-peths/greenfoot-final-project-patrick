import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    public TitleScreen()
    {    
        super(GameWorld.WIDTH, GameWorld.HEIGHT, 1);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            GameWorld GameWorld = new GameWorld();
            Greenfoot.setWorld(GameWorld);
        }
    }
}

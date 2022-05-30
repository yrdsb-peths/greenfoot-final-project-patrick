import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    public TitleScreen()
    {    
        super(Level1.WIDTH, Level1.HEIGHT, 1);
        Label title = new Label("Welcome to our game!", 50);
        Label pressStart = new Label("Press [space] to start!", 40);
        addObject(title, Level1.WIDTH / 2, Level1.HEIGHT / 2);
        addObject(pressStart, Level1.WIDTH / 2, Level1.HEIGHT / 2 + 100);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            Introduction introWorld = new Introduction();
            Greenfoot.setWorld(introWorld);
        }
    }
}

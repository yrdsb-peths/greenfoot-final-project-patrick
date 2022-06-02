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
        super(Level1.WIDTH, Level1.HEIGHT, 1);
        Label title = new Label("placeholder", 50);
        Label pressStart = new Label("Press [space] to start!", 40);
        addObject(title, Level1.WIDTH / 2, Level1.HEIGHT / 2);
        addObject(pressStart, Level1.WIDTH / 2, Level1.HEIGHT / 2 + 100);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            Level1 level1 = new Level1();
            Greenfoot.setWorld(level1);
        }
    }
}

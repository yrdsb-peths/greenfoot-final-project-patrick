import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2Pass here.
 * 
 * @ Patrick Hu 
 * @version (a version number or a date)
 */
public class Level2Pass extends LevelPassWorld
{
    public Level2Pass()
    {
        super(800, 600, 1);
        Label l = new Label("You Passed Level 2!", 40);
        addObject(l, getWidth() / 2, getHeight() / 2);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Level3());
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1Pass here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Level1Pass extends LevelPassWorld
{
    public Level1Pass()
    {
        super(600, 600, 1);
        Label l = new Label("You Passed Level 1!", 40);
        addObject(l, getWidth() / 2, getHeight() / 2);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Level2());
        }
    }
}

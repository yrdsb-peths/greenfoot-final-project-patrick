import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1Pass here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Level1Pass extends LevelPassWorld
{
    public Level1Pass() {
        super(800, 600, 1);
        
        Label l1 = new Label("You Passed Level 1!", 40);
        addObject(l1, getWidth() / 2, 50);
        Label l2 = new Label("You found a bow lying around! Press 1 and 2 to switch between the spear and bow.", 40);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Level2());
        }
    }
}

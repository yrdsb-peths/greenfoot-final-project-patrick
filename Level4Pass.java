import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4Pass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4Pass extends LevelPassWorld
{
    public Level4Pass() {
        super(800, 600, 1);
        Label l = new Label("You Passed Level 4!", 40);
        addObject(l, getWidth() / 2, getHeight() / 2);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Level5());
        }
    }
}

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
        setBackground("./images/level4pass.png");
    }
    
    public void act() {
        super.act();
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Level5());
        }
    }
}

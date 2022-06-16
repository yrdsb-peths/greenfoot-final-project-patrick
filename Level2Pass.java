import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2Pass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2Pass extends LevelPassWorld
{
    public Level2Pass() {
        super(800, 600, 1, 2);
        setBackground("./images/vecna/level2pass.png");
    }
    
    public void act() {
        super.act();
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Level3());
        }
    }
}

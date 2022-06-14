import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends World
{    
    public Instructions() {    
        super(800, 600, 1);
        setBackground("./images/vecna/instructions.png");
    }
    
    public void act() {        
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Level1());
        }
    }
}

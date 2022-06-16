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
        super(800, 600, 1, 1);
        setBackground("./images/vecna/level1pass.png");
    }
    
    public void act() {
        super.act();
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Level2());
        }
    }
}

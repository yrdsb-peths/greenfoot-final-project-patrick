import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 1 complete screen.
 * 
 * @author Patrick Hu
 * @version June 2022
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

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 3 complete screen.
 * 
 * @author Patrick Hu 
 * @version June 2022
 */
public class Level3Pass extends LevelPassWorld
{
    public Level3Pass() {
        super(800, 600, 1, 3);
        setBackground("./images/vecna/level3pass.png");
    }
    
    public void act() {
        super.act();
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Level4());
        }
    }
}

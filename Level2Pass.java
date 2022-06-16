import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 2 complete screen.
 * 
 * @author Patrick Hu 
 * @version June 2022
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

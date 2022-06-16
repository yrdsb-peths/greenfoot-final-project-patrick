import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instructions page. The next world after GameStartWorld.
 * 
 * @author Patrick Hu
 * @version June 2022
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
    
    public void stopped() {
        Soundtrack.mainSoundtrack.pause();
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Introduction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Introduction extends World
{
    public Introduction()
    {   
        super(Level1.WIDTH, Level1.HEIGHT, 1);
        Label story = new Label("You are a cat who needs to prove himself!\nPass the trials to become a cat master!", 100);
        addObject(story, Level1.WIDTH / 2, Level1.HEIGHT / 2);
        Label pressStart = new Label("Press [space] to start!", 40);
        addObject(pressStart, Level1.WIDTH / 2, Level1.HEIGHT / 2 + 100);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            Level1 level1 = new Level1();
            Greenfoot.setWorld(level1);
        }
    }
}

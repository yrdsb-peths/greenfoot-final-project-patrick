import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    public int idle_size = 4;
    public int run_size = 6;
    GreenfootImage[] runFacingRight = new GreenfootImage[run_size];
    GreenfootImage[] runFacingLeft = new GreenfootImage[run_size];
    GreenfootImage[] idleFacingRight = new GreenfootImage[idle_size];
    GreenfootImage[] idleFacingLeft = new GreenfootImage[idle_size];    
    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        Platform a = new Platform(700, 30);
        Platform b = new Platform(60, 30);
        Platform c = new Platform(80, 30);
        Platform d = new Platform(1100, 50);
        Platform e = new Platform(700, 30);

        Player cat = new Player();
                
        addObject(a, 26, 99);
        addObject(b, 723, 245);
        addObject(c, 517, 295);
        addObject(d, 550,688);
        addObject(e,472,404);

        addObject(cat,26, 66);  
        
    }
    public void chop()
    {
        if(Greenfoot.isKeyDown("x"))
        {
            //add animate images
        }
    }
}

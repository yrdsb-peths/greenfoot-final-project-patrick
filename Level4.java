import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4 extends GameWorld
{
    public Level4()
    {
        super(900, 700, 1);
        // spawn player
        Player p = new Player(4);
        addObject(p, getWidth() / 2, getHeight()  - 50);
        // spawn spear
        Spear s = new Spear();
        addObject(s, getWidth() / 2, getHeight()  - 50);
        // create num arrow label
        initNumArrowLabel(20);
        // spawn wizard
        Wizard w = new Wizard(6);
        addObject(w, 50, getHeight() / 2);
    }
    
    public void act() {
        updateNumArrowLabel();
    }
}

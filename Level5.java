import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level5 extends GameWorld
{
    public Level5() {
        super(800, 600, 1);
        // spawn player
        Player player = new Player(5);
        addObject(player, getWidth() / 2, getHeight()  - 50);
        // spawn big demon
        BigDemon demon = new BigDemon(25, 2.6, 2.5);
        addObject(demon, getWidth() / 2, getHeight() / 2);
    }
}

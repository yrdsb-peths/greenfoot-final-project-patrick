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
        Player player = new Player(5);
        addObject(player, getWidth() / 2, getHeight() / 2);
        //player.getImage().scale((int)(player.getImage().getWidth() * 4.5), (int)(player.getImage().getHeight() * 4.5));
    }
}

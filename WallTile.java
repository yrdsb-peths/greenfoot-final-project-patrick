import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WallTile here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class WallTile extends Actor
{
    public WallTile() {
        setImage("./sprites/wall-tile.png");
        getImage().scale((int)(getImage().getWidth() * 1.6), (int)(getImage().getHeight() * 1.6));
    }
    
    public void act()
    {
        // Add your action code here.
    }
}

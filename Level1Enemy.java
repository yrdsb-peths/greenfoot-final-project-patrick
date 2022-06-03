import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level1Enemy does not move and only shoots at the player.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Level1Enemy extends Enemy
{
    public void act()
    {
        shoot();
    }    
}

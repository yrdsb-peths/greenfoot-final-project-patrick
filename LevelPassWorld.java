import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelPassWorld here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class LevelPassWorld extends World
{
    public LevelPassWorld(int width, int height, int pixelSize)
    {    
        super(width, height, pixelSize); 
        Image player = new Image("./sprites/player/lizard_m_idle_anim_f0.png", 7);
        //player.turn(-45);
        addObject(player, 130, getHeight() - 35);
        Image melon = new Image("./sprites/watermelon/watermelon.png", 0.3);
        melon.turn(45);
        addObject(melon, 170, getHeight() - 16);
    }
}

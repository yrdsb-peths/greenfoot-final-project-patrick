import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * Patrick and Anna
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
    public final int WIDTH = 700;
    public final int HEIGHT = 30;
    
    public Platform(int width, int height) {
        getImage().scale(WIDTH, HEIGHT);
    }
}

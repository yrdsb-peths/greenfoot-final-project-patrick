import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @ Patrick and Anna
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    public static final int HEIGHT = 400;
    public static final int WIDTH = 600;

    public Level1() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1);
        Platform platform = new Platform();
        Player player = new Player();
        addObject(platform, WIDTH / 2, HEIGHT / 2);
        addObject(player, WIDTH / 2, HEIGHT / 2 - 200);
    }
}

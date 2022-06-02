import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;
    Pistol pistol = new Pistol(0, 0);
    
    public Level1() {
        super(WIDTH, HEIGHT, 1, false);
        // spawn player and pistol
        Player player = new Player("pistol");
        addObject(player, WIDTH / 2, HEIGHT / 2);
        addObject(pistol, WIDTH / 2 + 30, HEIGHT / 2 + 30);
    }
    
    public void gameOver() {
        GameOverWorld gameOverWorld = new GameOverWorld();
        Greenfoot.setWorld(gameOverWorld);
    }
    
    public void levelWin() {
        LevelWinWorld levelWinWorld = new LevelWinWorld();
        Greenfoot.setWorld(levelWinWorld);
    }
}

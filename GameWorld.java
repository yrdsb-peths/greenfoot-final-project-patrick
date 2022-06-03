import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
       
    
    public GameWorld() {
        super(WIDTH, HEIGHT, 1, false);
        GameInfo.currentWeapon = "pistol";
        // spawn player
        Player player = new Player();
        addObject(player, WIDTH / 2, HEIGHT / 2);
        // spawn pistol
        Pistol pistol  = new Pistol();
        addObject(pistol, WIDTH / 2 + 30, HEIGHT / 2 + 30);
        // spawn enemies
        Enemy enemy = new Enemy();
        addObject(enemy, 500, 500);
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

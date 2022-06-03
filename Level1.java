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
    Pistol pistol;    
    
    public Level1() {
        super(WIDTH, HEIGHT, 1, false);
        GameInfo.levelNumber = 1;
        GameInfo.currentWeapon = "pistol";
        // spawn player and pistol
        Player player = new Player();
        addObject(player, WIDTH / 2, HEIGHT / 2);
        pistol = new Pistol();
        addObject(pistol, WIDTH / 2 + 30, HEIGHT / 2 + 30);
        // spawn enemies
        Enemy enemy = new Enemy();
        addObject(enemy, 100, 100);
    }
    
    public Pistol getPistol() {
        return pistol;
    }
    
    public void gameOver() {
        GameOverWorld gameOverWorld = new GameOverWorld();
        Greenfoot.setWorld(gameOverWorld);
    }
    
    public void levelWin() {
        LevelWinWorld levelWinWorld = new LevelWinWorld();
        Greenfoot.setWorld(levelWinWorld);
    }
    
    /*
     * should there only be one GameWorld?
     * if only one game world,
     * in order to access an object from another class,
     * need to grab level1, then call a getter function
     * 
     * if multiple game worlds,
     * need to switch (GameInfo.levelNumber) if we want to access the current world 
     */
}

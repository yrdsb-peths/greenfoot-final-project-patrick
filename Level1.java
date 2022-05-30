import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @ Patrick and Anna
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 850;
    SimpleTimer timer = new SimpleTimer();
    
    public Level1() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1);
        // generate platforms
        for (int i = 0, x = 340, y = 790; i < 6; i++, y -= 130) {
            Platform p = new Platform();
            if (i % 2 == 0) x += 110;            
            else x -= 110;
            addObject(p, x, y);
        }
        // generate ladders
        for (int i = 0, x = 640, y = 712; i < 5; i++, y -= 130) {
            Ladder l = new Ladder();
            if (i % 2 == 0) x -= 500;
            else x += 500;
            addObject(l, x, y);
        }
        
        // spawn player
        Player player = new Player();
        addObject(player, WIDTH / 2, HEIGHT - 100);
        // spawn ball dispenser
        BallDispenser ballDispenser = new BallDispenser();
        addObject(ballDispenser, 640, 100);
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

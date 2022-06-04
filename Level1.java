import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @ Patrick Hu 
 * @version (a version number or a date)
 */
public class Level1 extends GameWorld
{   
    SimpleTimer enemySpawnTimer = new SimpleTimer();
    
    public Level1() {
        super(800, 600);
        // spawn player
        Player player = new Player();
        addObject(player, getWidth() / 2, getHeight() / 2);
        // spawn pistol
        Pistol pistol = new Pistol();
        addObject(pistol, getWidth() / 2, getHeight() / 2);
        // generate walls
        for (int x = 170, y = getHeight(); y >= 0;) {
            WallTile wall = new WallTile();
            addObject(wall, x, y);
            y -= wall.getImage().getHeight();
        }
        for (int x = getWidth() - 170, y = getHeight(); y >= 0;) {
            WallTile wall = new WallTile();
            addObject(wall, x, y);
            y -= wall.getImage().getHeight();
        }
        // spawn ball dispensers
        
        // spawn watermelon
        Watermelon melon = new Watermelon();
        addObject(melon, getWidth() / 2, 45);
    }
    
    public void act() {
       
    }
}

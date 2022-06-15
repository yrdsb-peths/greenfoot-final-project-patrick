import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @ Patrick Hu 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{   
    public int actCount = 0;
    public int level;
    Player player;
    Spear spear;
    
    public GameWorld(int width, int height, int pixelSize, int level) {    
        super(width, height, pixelSize);
        this.level = level;
        // create player and spear
        player = new Player();
        spear = new Spear();
        // set background as dungeon floor
        GreenfootImage floor = new GreenfootImage("./sprites/floor/floor_1.png");
        floor.scale((int)(floor.getWidth() * 2), (int)(floor.getHeight() * 2));
        setBackground(floor);
    }
    
    public void act() {
        actCount++;
        // check that soundtracks are playing properly for levels 1-4
        Soundtrack.setVolumes();
        if (!Soundtrack.castle.isPlaying()) {
            Soundtrack.castle.play();
        }
        if (Soundtrack.nightmareKing.isPlaying()) {
            Soundtrack.nightmareKing.stop();
        }
    }
    
    public void gameOver() {
        Greenfoot.setWorld(new GameOverWorld());
        Player.health = 3;
    }
}

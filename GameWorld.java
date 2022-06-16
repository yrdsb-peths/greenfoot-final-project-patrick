import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Super class of all level worlds.
 * 
 * @author Patrick Hu 
 * @version June 2022
 */
public class GameWorld extends World
{   
    public int actCount = 0;
    public int level;
    Player player;
    Spear spear;

    /**
     * Sets the width, height, pixel size, and level of the game world.
     * 
     * @param width         width of world
     * @param height        hegiht of world
     * @param pixelSize     size of each pixel
     * @param level         current level of the game world
     */
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
        Soundtrack.setVolumes();
        if (level >= 1 && level <= 4) {
            Soundtrack.stopAllExceptMain();
            Soundtrack.mainSoundtrack.playLoop();
        }
        else if (level == 5) {
            Soundtrack.stopAllExceptNightmareKing();
        }
    }

    /**
     * Ends the game and displays game over screen.
     * Sets player health back to full.
     */
    public void gameOver() {
        Greenfoot.setWorld(new GameOverWorld());
        Player.health = 3;
    }
    
    public void stopped() {
        Soundtrack.mainSoundtrack.pause();
        Soundtrack.nightmareKing.pause();
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The watermelon that the player needs to collect in order to advance
 * to the next level.
 * 
 * @author Patrick Hu 
 * @version June 2022
 */
public class Watermelon extends Actor
{
    private int idle_size = 10, idle_index = 0;
    private int actCount = 0;
    private double scale = 0.75;
    private int level;
    GreenfootImage[] idle = new GreenfootImage[idle_size];
    GreenfootSound melonSound = new GreenfootSound("./sounds/watermelon-sound.mp3");
    
    /**
     * Constructs a watermelon.
     * 
     * @param level     the current level that the watermlon is in
     */
    public Watermelon(int level) {
        this.level = level;
        for (int i = 0; i < idle_size; i++) {
            idle[i] = new GreenfootImage("./sprites/watermelon/idle" + i + ".png");
            idle[i].scale((int)(idle[i].getWidth() * scale), (int)(idle[i].getHeight() * scale));
        }
        setImage(idle[0]);
        melonSound.setVolume(90);
    }
    
    public void act() {
        actCount++;
        idleAnimate();
        checkTouching();
    }
    
    /**
     * Animates the watermlon bobbing up and down.
     */
    public void idleAnimate() {
        if (actCount % 8 == 0) {
            setImage(idle[idle_index]);
            idle_index++;
            idle_index %= idle_size;
        }
    }
    
    /**
     * Checks if the watermlon is touching the player.
     */
    public void checkTouching() {
        if (isTouching(Player.class)) {
            melonSound.play();
            switch (level) {
                case 1: {
                    Level1 world = (Level1) getWorld();
                    world.levelPass();
                    break;
                }
                case 2: {
                    Level2 world = (Level2) getWorld();
                    world.levelPass();
                    break;
                }
                case 3: {
                    Level3 world = (Level3) getWorld();
                    world.levelPass();
                    break;
                }
                case 4: {
                    Level4 world = (Level4) getWorld();
                    world.levelPass();
                    break;
                }
            }
        }
    }
}

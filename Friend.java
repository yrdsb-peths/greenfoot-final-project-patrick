import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Friend here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Friend extends SmoothMover
{
    private int idle_size = 4, idle_index = 0;
    private int actCount = 0;
    private double scale = 2.5;
    GreenfootImage[] idleFacingRight = new GreenfootImage[idle_size];
    GreenfootSound melonSound = new GreenfootSound("./sounds/watermelon-sound.mp3");
    
    public Friend() {
        for (int i = 0; i < idle_size; i++) {
            idleFacingRight[i] = new GreenfootImage("./sprites/friend/lizard_f_idle_anim_f" + i + ".png");
            idleFacingRight[i].scale((int)(idleFacingRight[i].getWidth() * scale), (int)(idleFacingRight[i].getHeight() * scale));
        }
        setImage(idleFacingRight[0]);
        melonSound.setVolume(90);
    }
    
    public void act() {
        actCount++;
        idleAnimate();
        checkTouching();
    }
    
    public void idleAnimate() {
        if (actCount % 8 == 0) {
            setImage(idleFacingRight[idle_index]);
            idle_index++;
            idle_index %= idle_size;
        }
    }

    public void checkTouching() {
        if (isTouching(Player.class)) {
            melonSound.play();
            Level5 world = (Level5) getWorld();
            // add heart png above friend
            Image heart1 = new Image("./sprites/ui_heart_full.png", 1.5);
            world.addObject(heart1, getX(), getY() - 27);
            // add heart png above player
            Player player = getWorld().getObjects(Player.class).get(0);
            Image heart2 = new Image("./sprites/ui_heart_full.png", 1.5);
            world.addObject(heart2, player.getX(), player.getY() - 27);
            // remove player health bar
            player.removeHealthBar();
            // delay
            Greenfoot.delay(250);
            
            world.levelPass();
        }
    }
}

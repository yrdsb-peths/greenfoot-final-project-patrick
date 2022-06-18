import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The explosion animation that plays after big demon has been killed.
 * 
 * @author Patrick Hu
 * @version June 2022
*/
public class Explosion extends Actor
{
    private int actCount = 0;
    private int explosion_size = 71, explosion_index = 0;
    GreenfootImage[] explosion = new GreenfootImage[explosion_size];
    
    public Explosion() {
        // initialize explosion sprites 
        for (int i = 0; i < explosion_size; i++) {
            // get the frame index 
            // while loop needed because in the sprites, 0009 turns into 0010, therefore 000 + i will not work
            String x =  Integer.toString(i);
            while (x.length() < 4) {
                x = "0" + x;
            }
            explosion[i] = new GreenfootImage("./sprites/explosion/frame" + x + ".png");
            explosion[i].scale(explosion[i].getWidth() * 4, explosion[i].getHeight() * 4);
        }
    }
    
    public void act() {
        actCount++;
        explosionAnimate();
    }
    
    /**
     * Animates an explosion after the demon's been killed.
     * Only animates 1 cycle, once animation is over remove the explosion object.
     */
    public void explosionAnimate() {
        if (explosion_index >= explosion_size) {
            getWorld().removeObject(this);
        }
        if (actCount % 5 == 0) {
            setImage(explosion[explosion_index]);
            explosion_index++;
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The health bar used for enemies and the player.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class HealthBar extends Actor
{
    public int id;
    private int fontSize = 25;
    private double scale = 1.3;
    private int width = 50, height = 60;
    public int value_x = 5, value_y = height / 2;
    public int heart_x = 19, heart_y = height / 2 + 3;
    private Color lineColor = Color.BLACK;
    private Color fillColor = Color.WHITE;
    private Color transparent = new Color(0,0,0,0);
    
    /**
     * Calls update() to construct a health bar.
     * 
     * @param hp        the amount of hp in the health bar
     * @param id        the id of the character
     */
    public HealthBar(int hp, int id) {
        this.id = id;
        // the constructor would do the same thing as update() so just call it here
        update(hp);
    }
    
    /**
     * Creates a health bar by drawing on a blank GreenfootImage canvas.
     * The amount of hp is a number displayed on the left while a heart png is displayed on the right.
     * 
     * @param hp        the amount of hp
     */
    public void update(int hp) {
        // draw canvas with current number of hearts
        GreenfootImage canvas = new GreenfootImage(width, height);
        // add image of amount of hp on left
        String s = Integer.toString(hp);
        if (s.length() == 2) { // hp is in double digits
            heart_x = 28; // place heart png more to the right
        }
        GreenfootImage value = new GreenfootImage(s, fontSize, fillColor, transparent, lineColor);
        canvas.drawImage(value, value_x, value_y);
        // add image of heart on right
        GreenfootImage heart = new GreenfootImage("./sprites/ui_heart_full.png");
        heart.scale((int)(heart.getWidth() * scale), (int)(heart.getHeight() * scale));
        canvas.drawImage(heart, heart_x, heart_y);
        
        setImage(canvas);
    }
}

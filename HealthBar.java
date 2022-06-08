import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    private Color lineColor = Color.BLACK;
    private Color fillColor = Color.WHITE;
    private Color transparent = new Color(0,0,0,0);
    private int fontSize = 25;
    private double scale = 1.3;
    private int width = 40, height = 60;
    private int value_x = 0, value_y = height / 2;
    private int heart_x = 15, heart_y = height / 2 + 5;
    
    public HealthBar(int hp) {
        // constructor would do the same thing as update() so just call it here
        update(hp);
    }
    
    public void update(int hp) {
        // re-draw canvas with current number of hearts
        GreenfootImage canvas = new GreenfootImage(width, height);
        // add image of amount of hp on left
        String s = Integer.toString(hp);
        GreenfootImage value = new GreenfootImage(s, fontSize, fillColor, transparent, lineColor);
        canvas.drawImage(value, value_x, value_y);
        // add image of heart on right
        GreenfootImage heart = new GreenfootImage("./sprites/ui_heart_full.png");
        heart.scale((int)(heart.getWidth() * scale), (int)(heart.getHeight() * scale));
        canvas.drawImage(heart, heart_x, heart_y);
        
        setImage(canvas);
    }
}

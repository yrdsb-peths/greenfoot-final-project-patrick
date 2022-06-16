import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A label showing how many arrows are left in a level.
 * 
 * @author Patrick Hu 
 * @version June 2022
 */
public class NumArrowLabel extends Actor
{
    private Color lineColor = Color.BLACK;
    private Color fillColor = Color.WHITE;
    private Color transparent = new Color(0,0,0,0);
    private int fontSize = 30;
    private int width = 50, height = 50;
    private int value_x = 0, value_y = height / 2;
    private int arrow_x = 35, arrow_y = height / 2 + 3;
    
    /**
     * Constructs the label. Essentially a blank GreenfootImage canvas that contains
     * the number of arrows on the left and an arrow png on the right.
     * 
     * @param numArrows     the initial number of arrows to display
     */
    public NumArrowLabel(int numArrows) {
        Bow.numArrows = numArrows;
        // create empty image
        GreenfootImage canvas = new GreenfootImage(width, height);
        // add image of # of arrows on left
        String s = Integer.toString(numArrows);
        GreenfootImage value = new GreenfootImage(s, fontSize, fillColor, transparent, lineColor);
        canvas.drawImage(value, value_x, value_y);
        // add image of arrow on right
        GreenfootImage arrow = new GreenfootImage("./sprites/bow/weapon_arrow_facing_down.png");
        canvas.drawImage(arrow, arrow_x, arrow_y);
        
        setImage(canvas);
    }
    
    public void act() {
        update();
    }
    
    /**
     * Re-draws the canvas with the current number of arrows.
     */
    public void update() {
        // re-draw canvas with current number of arrows
        GreenfootImage canvas = new GreenfootImage(width, height);
        // add image of # of arrows on left
        String s = Integer.toString(Bow.numArrows);
        GreenfootImage value = new GreenfootImage(s, fontSize, fillColor, transparent, lineColor);
        canvas.drawImage(value, value_x, value_y);
        // add image of arrow on right
        GreenfootImage arrow = new GreenfootImage("./sprites/bow/weapon_arrow_facing_down.png");
        canvas.drawImage(arrow, arrow_x, arrow_y);
        
        setImage(canvas);
    }
}

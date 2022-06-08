import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExNumArrowLabel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public NumArrowLabel(int numArrows) {
        Bow.numArrows = numArrows;
        
        // create empty image
        GreenfootImage canvas = new GreenfootImage(width, height);
        // add image of # of arrows on left
        String s = Integer.toString(numArrows);
        GreenfootImage value = new GreenfootImage(s, fontSize, fillColor, transparent, lineColor);
        canvas.drawImage(value, value_x, value_y);
        // add image of arrow on right
        GreenfootImage arrow = new GreenfootImage("./sprites/bow/weapon_arrow_facing_up.png");
        canvas.drawImage(arrow, arrow_x, arrow_y);
        
        setImage(canvas);
    }
    
    public void act() {
        update();
    }
    
    public void update() {
        // re-draw canvas with current number of arrows
        GreenfootImage canvas = new GreenfootImage(width, height);
        // add image of # of arrows on left
        String s = Integer.toString(Bow.numArrows);
        GreenfootImage value = new GreenfootImage(s, fontSize, fillColor, transparent, lineColor);
        canvas.drawImage(value, value_x, value_y);
        // add image of arrow on right
        GreenfootImage arrow = new GreenfootImage("./sprites/bow/weapon_arrow_facing_up.png");
        canvas.drawImage(arrow, arrow_x, arrow_y);
        
        setImage(canvas);
    }
}

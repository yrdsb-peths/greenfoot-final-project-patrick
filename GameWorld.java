import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @ Patrick Hu 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{   
    public GameWorld(int width, int height, int pixelSize)
    {    
        super(width, height, pixelSize);
        GreenfootImage floor = new GreenfootImage("./sprites/floor/floor_1.png");
        floor.scale((int)(floor.getWidth() * 2), (int)(floor.getHeight() * 2));
        setBackground(floor);
    }
    
    public void initNumArrowLabel() {
        NumArrowLabel l = new NumArrowLabel(Bow.numArrows, 35);
        GreenfootImage arrow = new GreenfootImage("./sprites/bow/weapon_arrow_facing_up.png   ");
        arrow.scale((int)(arrow.getWidth() * 1.2), (int)(arrow.getHeight() * 1.2));
        Image arrowActor = new Image(arrow);
        
        addObject(l, getWidth() - 50, getHeight() - 30);
        addObject(arrowActor, getWidth() - 20, getHeight() - 30);
    }
    
    public void updateNumArrowLabel() {
        NumArrowLabel l = getObjects(NumArrowLabel.class).get(0);
        l.setValue(Bow.numArrows);
    }
    
    public void gameOver() {
        Greenfoot.setWorld(new GameOverWorld());
    }
}

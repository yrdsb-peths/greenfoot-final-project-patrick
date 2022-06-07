import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Enemy extends SmoothMover
{
    public int health;
    
    public Enemy(int health) {
        this.health = health;
    }
    
    public void initHealthLabel() {
        HealthLabel l = new HealthLabel(health, 20);
        
    }
    
    public void updateHealthLabel() {
        
    }
    
    public void moveHealthLabel() {
        
    }
}

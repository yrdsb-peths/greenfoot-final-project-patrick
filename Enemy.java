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
    private int healthBar_dy = -50;
    
    public Enemy(int health) {
        this.health = health;
    }
    
    public void initHealthBar() {
        HealthBar bar = new HealthBar(health);
        getWorld().addObject(bar, getX(), getY() + healthBar_dy);
    }
    
    public void updateHealthBar() {
        // get the health bar
        var arr = getObjectsAtOffset(0, healthBar_dy, HealthBar.class);
        if (arr.size() == 1) {
            HealthBar bar = arr.get(0);
            bar.update(health);    
        }
    }
    
    public void moveHealthBar() {
        // get the health bar
        var arr = getObjectsAtOffset(0, healthBar_dy, HealthBar.class);
        if (arr.size() == 1) {
            HealthBar bar = arr.get(0);
            bar.setLocation(getX(), getY() + healthBar_dy);
        }
    }
    
    public void removeHealthBar() {
        var arr = getObjectsAtOffset(0, healthBar_dy, HealthBar.class);
        if (arr.size() == 1) {
            HealthBar bar = arr.get(0);
            getWorld().removeObject(bar);
        }
    }
}

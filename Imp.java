import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Imp here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Imp extends Enemy {
    String pattern, curDirection;
    
    public Imp(int id, int health, double speed, double scale) {
        super("imp", id, health, speed, scale);
    }
    
    public void act() {
        super.act();
        move();
        runAnimate();
    }
    
    public void move() {
        Player player = (Player) getWorld().getObjects(Player.class).get(0);
        turnTowards(player.getX(), player.getY());
        move(speed);
    }
}

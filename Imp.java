import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Imps are tiny enemies that have little hp and constantly run toward the player.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class Imp extends Enemy {
    String pattern, curDirection;
    
    /**
     * Constructs an imp.
     * 
     * @param id        id of the imp
     * @param health    imp's health
     * @param speed     imp's speed
     * @param scale     amount to scale the imp by
     */
    public Imp(int id, int health, double speed, double scale) {
        super("imp", id, health, speed, scale);
    }
    
    public void act() {
        super.act();
        move();
        runAnimate();
    }
    
    /**
     * Constantly runs toward the player
     */
    public void move() {
        Player player = (Player) getWorld().getObjects(Player.class).get(0);
        turnTowards(player.getX(), player.getY());
        move(speed);
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BigDemon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BigDemon extends Enemy
{   
    public BigDemon(int health, double speed, double scale) {
        super(health, "big_demon", speed, scale);
    }
    
    public void act() {
        super.act();
        if (actCount > 100 & actCount < 200) {
            move();
            runAnimate();
        }
        else {
            idleAnimate();
        }
    }
    
    public void move() {
        // moves towards player
        Player player = getWorld().getObjects(Player.class).get(0);
        turnTowards(player.getX(), player.getY());
        move(speed);
        
        // turn back
        setRotation(0);
    }
    
    public void spreadAttack() {
        // fires a bunch of fireballs in a circular pattern
        int turnAmount = 0;
        for (int i = 0; i < 12; i++) {
            BigDemonBall b = new BigDemonBall(3, 2.5, false);
            getWorld().addObject(b, getX(), getY());
            turn(turnAmount);
            turnAmount += 30;
        }
    }
    
    public void targetedAttack() {
        BigDemonBall b = new BigDemonBall(1, 2.5, true);
        Player player = getWorld().getObjects(Player.class).get(0);
        
        getWorld().addObject(b, getX(), getY());
        b.turnTowards(player.getX(), player.getY());
    }
    
    public void largeSizeAttack() {
        BigDemonBall b = new BigDemonBall(0.5, 4.5, false);
        Player player = getWorld().getObjects(Player.class).get(0);
        
        getWorld().addObject(b, getX(), getY());
        b.turnTowards(player.getX(), player.getY());
    }
    
    public void idleAnimate() {
        if (actCount % 8 == 0) {
            if (facingRight) setImage(idleFacingRight[idle_index]);
            else setImage(idleFacingLeft[idle_index]);
            idle_index++;
            idle_index %= idle_size;
        }
    }
    
    public void runAnimate() {
        if (actCount % 8 == 0) {
            if (facingRight) setImage(runFacingRight[run_index]);
            else setImage(runFacingLeft[run_index]);
            run_index++;
            run_index %= run_size;
        }
    }
    
    /*
     * attacks:
     * aura attack
     * 3 quick targeted attacks
     * large ball attack
     * 
     * movement:
     * periodically moves toward player
     */
}

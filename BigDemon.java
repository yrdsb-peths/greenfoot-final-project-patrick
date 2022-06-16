import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The final boss. Has 3 different attacks and moves towards the player periodically.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class BigDemon extends Enemy
{   
    /**
     * Sets big demon's id, health, speed, and scale
     * 
     * @param id        big demon's id
     * @param health    amount of health big demon has
     * @param speed     move speed of big demon
     * @param scale     amount to scale big demon's size by
     */
    public BigDemon(int id, int health, double speed, double scale) {
        super("big_demon", id, health, speed, scale);
    }
    
    public void act() {
        super.act();
        // move
        int t1 = 60;
        // spread attack time frame
        int t2 = t1 + 30;
        int t3 = t2 + 2;
        // targeted attack
        int t4 = t3 + 80;
        int t5 = t4 + 50;
        // large size attack
        int t6 = t5 + 80;
        int t7 = t6 + 30;
        // calculate the total number to mod by
        int x = actCount % (t7 + 30);
        
        if (x < t1) {
            move();
            runAnimate();
        } else {
            idleAnimate();
        }
        if (x > t2 && x < t3) {
            spreadAttack();
        }
        if (x > t4 && x < t5) {
            targetedAttack();
        }
        if (x > t6 && x < t7) {
            largeSizeAttack();
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
    
    /**
     * Fires 12 fireballs in a circular pattern
     */
    public void spreadAttack() {
        int turnAmount = 0;
        for (int i = 0; i < 12; i++) {
            BigDemonBall b = new BigDemonBall(2.5, 0.1, false);
            getWorld().addObject(b, getX(), getY());
            b.turn(turnAmount);
            turnAmount += 30;
        }
    }
    

    /**
     * In specified time frame, fires accelerating fireballs towards the player
     */
    public void targetedAttack() {
        if (actCount % 10 == 0) {
            BigDemonBall b = new BigDemonBall(0.25, 0.1, true);
            Player player = getWorld().getObjects(Player.class).get(0);
            
            getWorld().addObject(b, getX(), getY());
            b.turnTowards(player.getX(), player.getY());    
        }
    }
    
    /**
     * In specified time frame, fires very large fireballs toward player
     */
    public void largeSizeAttack() {
        if (actCount % 10 == 0) {
            BigDemonBall b = new BigDemonBall(3.5, 0.3, false);
            Player player = getWorld().getObjects(Player.class).get(0);
            
            getWorld().addObject(b, getX(), getY());
            b.turnTowards(player.getX(), player.getY());
        }
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
}

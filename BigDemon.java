import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The final boss. Has 3 different attacks and moves towards the player periodically.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class BigDemon extends Enemy
{   
    private int t1, t2, t3, t4, t5, t6, t7, x; // time stamps for demon's attacks
    public boolean isDead = false;
    GreenfootSound spreadAttackSound = new GreenfootSound("./sounds/spread-fireball.mp3");
    GreenfootSound quickFireballSound = new GreenfootSound("./sounds/quick-fireball.mp3");
    GreenfootSound angryFireballSound = new GreenfootSound("./sounds/angry-fireball.mp3");
    GreenfootSound scream = new GreenfootSound("./sounds/demon-death-scream.mp3");
    

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
        // initialize attack and movement time frames
        // move time frame (between 0 and 70 acts)
        t1 = 70;
        // spread attack time frame
        t2 = t1 + 30;
        t3 = t2 + 2;
        // targeted attack
        t4 = t3 + 90;
        t5 = t4 + 70;
        // large size attack
        t6 = t5 + 80;
        t7 = t6 + 30;
        
        spreadAttackSound.setVolume(100);
    }

    public void act() {
        super.act();
        checkDeath();
        // calculate the total number to mod by
        x = actCount % (t7 + 30);
        if (!isDead) {
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
        spreadAttackSound.stop(); spreadAttackSound.play();
        for (int i = 0; i < 12; i++) {
            BigDemonBall b = new BigDemonBall(2.5, 0.11, false);
            getWorld().addObject(b, getX(), getY());
            b.turn(turnAmount);
            turnAmount += 30;
        }
    }

    /**
     * In specified time frame, fires accelerating fireballs towards the player
     */
    public void targetedAttack() {
        if (actCount % 20 == 0) {
            BigDemonBall b = new BigDemonBall(0.25, 0.145, true);
            Player player = getWorld().getObjects(Player.class).get(0);

            getWorld().addObject(b, getX(), getY());
            b.turnTowards(player.getX(), player.getY());
            quickFireballSound.stop(); quickFireballSound.play();
        }
    }

    /**
     * In specified time frame, fires very large fireballs toward player
     */
    public void largeSizeAttack() {
        if (actCount % 20 == 0) {
            BigDemonBall b = new BigDemonBall(3.5, 0.3, false);
            Player player = getWorld().getObjects(Player.class).get(0);

            getWorld().addObject(b, getX(), getY());
            b.turnTowards(player.getX(), player.getY());
            angryFireballSound.stop(); angryFireballSound.play();
        }
    }

    /**
     * Checks if the demon has been killed. Scream once he is defeated.
     */
    public void checkDeath() {
        if (health == 0 && !isDead) {
            isDead = true;
            scream.play();
            Soundtrack.nightmareKing.stop();
        }
        if (isDead && !scream.isPlaying()) { // scream has finished
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(), getY());
            getWorld().removeObject(this); // remove the demon from world
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

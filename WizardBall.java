import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The wizard's projectile.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class WizardBall extends EnemyProjectile
{
    private double acceleration = 0.4;
    private int anim_size = 5, anim_index = 0, anim_speed = 12;  
    private int t1 = 2000, t2 = 2300;
    GreenfootImage[] animation = new GreenfootImage[anim_size];
    SimpleTimer timer = new SimpleTimer();
    
    public WizardBall() {
        super(1.4, 1.9);
        for (int i = 0; i < anim_size; i++) {
            animation[i] = new GreenfootImage("./sprites/blue-fireball-v2/blue-fireball" + i + ".png");
            animation[i].scale((int)(animation[i].getWidth() * scale), (int)(animation[i].getHeight() * scale));
        }
        setImage(animation[0]);
    }
    
    public void act() {
        super.act();
        move();
        animate();
        checkAtWall();
    }
    
    public void move() {
        Player player = (Player) getWorld().getObjects(Player.class).get(0);

        // for first second, just move forward
        if (timer.millisElapsed() < t1) {
            move(speed);
        }
        // between the 1st and 1.4th second
        if (timer.millisElapsed() > t1 && timer.millisElapsed() < t2) {
            turnTowards(player.getX(), player.getY());
            anim_speed = 6;
        }
        // after 1st second
        if (timer.millisElapsed() > t2) {
            move(speed);
            if (speed < 15)
                speed += acceleration;
        }
    }
    
    public void animate() {
        if (actCount % anim_speed == 0) {
            setImage(animation[anim_index]);
            anim_index++;
            anim_index %= anim_size;
        }
    }
}

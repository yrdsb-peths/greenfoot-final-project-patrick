import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WizardBall here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class WizardBall extends EnemyProjectile
{
    private double speed = 1.5;
    private double acceleration = 0.5;
    private int actCount = 0;
    private int anim_size = 5, anim_index = 0, anim_speed = 12;  
    private int t1 = 2000, t2 = 2300;
    private double scale = 1.9;
    GreenfootImage[] animation = new GreenfootImage[anim_size];
    SimpleTimer timer = new SimpleTimer();
    
    public WizardBall() {
        for (int i = 0; i < anim_size; i++) {
            animation[i] = new GreenfootImage("./sprites/blue-fireball-v2/blue-fireball" + i + ".png");
            animation[i].scale((int)(animation[i].getWidth() * scale), (int)(animation[i].getHeight() * scale));
        }
        setImage(animation[0]);
    }
    
    public void act()
    {
        actCount++;
        move();
        animate();
        checkPlayerHit();
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
    
    /*
     * blue fireball colours:
     * dark blue: 0080ff
     * light blue: 7ebfff
     * lightest blue: e4f4ff
     */
}
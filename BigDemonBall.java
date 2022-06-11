import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BigDemonBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BigDemonBall extends EnemyProjectile
{
    private double speed, scale, acceleration = 0.08;
    private int actCount = 0;
    private int anim_size = 5, anim_index = 0;
    private boolean accelerate;
    String attackType;
    GreenfootImage[] animation = new GreenfootImage[anim_size];
    SimpleTimer timer = new SimpleTimer();
    
    public BigDemonBall(double speed, double scale, boolean accelerate) {
        this.speed = speed;
        this.scale = scale;
        this.accelerate = accelerate;
        for (int i = 0; i < anim_size; i++) {
            animation[i] = new GreenfootImage("./sprites/fireball-v2/fireball" + i + ".png");
            animation[i].scale((int)(animation[i].getWidth() * scale), (int)(animation[i].getHeight() * scale));
        }
        setImage(animation[0]);
    }
    
    public void act() {
        actCount++;
        move();
        animate();
        checkPlayerHit();
        checkAtWall();
    }
    
    public void move() {
        if (accelerate) {
            speed += acceleration;
        }
        move(speed);
    }
    
    public void animate() {
        if (actCount % 5 == 0) {
            setImage(animation[anim_index]);
            anim_index++;
            anim_index %= anim_size;
        }
    }
}

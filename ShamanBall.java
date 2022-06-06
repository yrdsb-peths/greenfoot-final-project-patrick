import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShamanBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShamanBall extends EnemyProjectile
{
    private int speed = 2;
    private int actCount = 0;
    private int anim_size = 5, anim_index = 0;
    private double scale = 0.1;
    GreenfootImage[] animation = new GreenfootImage[anim_size];
    SimpleTimer timer = new SimpleTimer();
    
    public ShamanBall() {
        for (int i = 0; i < anim_size; i++) {
            animation[i] = new GreenfootImage("./sprites/fireball-v2/fireball" + i + ".png");
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
        // for first 2 seconds, track the player 
        if (timer.millisElapsed() < 2000) {
            Player player = (Player) getWorld().getObjects(Player.class).get(0);
            turnTowards(player.getX(), player.getY());
        }
        move(speed);
    }
    
    public void checkPlayerHit() {
        if (isTouching(Player.class)) {
            GameWorld world = (GameWorld) getWorld();
            world.gameOver();
        }
    }
    
    public void animate() {
        if (actCount % 5 == 0) {
            setImage(animation[anim_index]);
            anim_index++;
            anim_index %= anim_size;
        }
    }
}

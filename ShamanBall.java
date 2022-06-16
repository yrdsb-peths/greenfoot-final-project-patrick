import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The shaman's projectile.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class ShamanBall extends EnemyProjectile
{
    private int anim_size = 5, anim_index = 0;
    GreenfootImage[] animation = new GreenfootImage[anim_size];
    SimpleTimer timer = new SimpleTimer();
    
    public ShamanBall() {
        super(3, 0.1);
        for (int i = 0; i < anim_size; i++) {
            animation[i] = new GreenfootImage("./sprites/fireball-v2/fireball" + i + ".png");
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
        // for first 1.5 seconds, track the player 
        if (timer.millisElapsed() < 1500) {
            Player player = (Player) getWorld().getObjects(Player.class).get(0);
            turnTowards(player.getX(), player.getY());
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

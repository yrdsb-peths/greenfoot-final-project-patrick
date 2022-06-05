import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Skeletons only shoot in one direction and cannot move.
 * Their shots do not track the player.
 * Skeletons die upon touch and when hit by an arrow.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Skeleton extends Enemy
{
    String shotDirection;
    private int idle_size = 4, idle_index = 0;
    private int actCount = 0;
    GreenfootImage[] idle = new GreenfootImage[idle_size];
    
    public Skeleton(String shotDirection) {
        this.shotDirection = shotDirection;
        // initialize idle sprites
        for (int i = 0; i < idle_size; i++) {
            idle[i] = new GreenfootImage("./sprites/skeleton/skelet_idle_anim_f" + i + ".png");
            idle[i].scale((int)(getImage().getWidth() * 2.5), (int)(getImage().getHeight() * 2.2));
        }
    }
    
    public void act() {
        actCount++;
        idleAnimate();
        checkDeath();
    }
    
    public void fireBall() {
        GameWorld world = (GameWorld) getWorld();
        Ball ball = new Ball(shotDirection);
        world.addObject(ball, getX(), getY());
    }
    
    public void idleAnimate() {
        if (actCount % 10 == 0) {
            setImage(idle[idle_index]);
            idle_index++;
            idle_index %= idle_size;
        }
    }
    
    public void checkDeath() {
        if (getWorld() == null) return;
        if (isTouching(Player.class)) {
            getWorld().removeObject(this);
        }
    }
}

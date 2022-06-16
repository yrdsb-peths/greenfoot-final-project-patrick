import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Subclass of Projectile that deals with the bow's arrow. Arrows follow a straight line and travel
 * at a constant speed. They deal 1 damage to enemies.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class Arrow extends Projectile
{
    private int damage = 1;
    private int speed = 15;
    private int decceleration = 2; // not used in final product
    private int actCount = 0;
    private double scale = 1.2;
    GreenfootSound hitSound = new GreenfootSound("./sounds/arrow-hit2.mp3");
    
    public Arrow() {
        setImage("sprites/bow/weapon_arrow.png");    
        getImage().scale((int)(getImage().getWidth() * scale), (int)(getImage().getHeight() * scale));
        hitSound.setVolume(30);
    }
    
    public void act() {
        actCount++;
        move(speed);
        checkEnemyHit();
        checkAtWall();
    }
    
    /**
     * Checks if arrow has come into contact with an enemy.
     */
    public void checkEnemyHit() {
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if (enemy != null) {
            hitSound.play();
            if (enemy.health - damage <= 0) {
                enemy.removeHealthBar();
                removeTouching(Enemy.class);
            }
            else enemy.health -= damage;
            
            // remove arrow from world
            if (getWorld() == null) return;
            else getWorld().removeObject(this);
        }
    }
    
    /**
     * Deccelerates the arrow. Not used in final version.
     */
    public void deccelerate() {
        if (actCount % 10 == 0 && speed > 7) {
            speed -= decceleration;
        }
    }
}

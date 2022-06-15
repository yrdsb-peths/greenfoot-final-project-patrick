import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spear here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Spear extends SmoothMover
{
    private int damage = 1;
    private int attack_size = 13, attack_index = 0;
    private double scale = 0.13;
    private boolean isAttacking = false;
    GreenfootImage[] attackImages = new GreenfootImage[attack_size];
    SimpleTimer animTimer = new SimpleTimer();
    private int animTimerThreshold = 20;
    SimpleTimer attackTimer = new SimpleTimer();
    GreenfootSound attackSound = new GreenfootSound("./sounds/spear-attack.mp3");
    GreenfootSound hitSound = new GreenfootSound("./sounds/spear-hit.mp3");
    
    public Spear() {
        for (int i = 0; i < attack_size; i++) {
            attackImages[i] = new GreenfootImage("./sprites/spear-long-v2/attack" + i + ".png");
            attackImages[i].scale((int)(attackImages[i].getWidth() * (scale + 0.05)), (int)(attackImages[i].getHeight() * scale));
        }
        setImage(attackImages[0]);
        
        // adjust sound volumes
        attackSound.setVolume(60);
        hitSound.setVolume(20);
    }
    
    public void act() {
        faceCursor();
        checkAttack();
        if (isAttacking) {
            attackAnimate();
        }
    }
    
    public void faceCursor() {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null) {
            turnTowards(mi.getX(), mi.getY());
        }
    }
    
    public void checkAttack() {
        if (Greenfoot.isKeyDown("space")) {
            attackSound.stop(); attackSound.play();
            isAttacking = true;
        }
        else if (attack_index >= attack_size) {
            isAttacking = false;
            attack_index = 0;
        }
    }
    
    public void attackAnimate() {
        if (attack_index >= attack_size) return;
        if (animTimer.millisElapsed() > animTimerThreshold) {
            setImage(attackImages[attack_index]);
            attack_index++;
            animTimer.mark();
            checkEnemyHit();
            animTimerThreshold -= 4; // accelerate the animation
        }
    }
    
    public void checkEnemyHit() {
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if (enemy != null && attackTimer.millisElapsed() > 400) {
            hitSound.play();
            if (enemy.health - damage == 0) {
                enemy.removeHealthBar();
                removeTouching(Enemy.class);    
            }
            else enemy.health -= damage;
            attackTimer.mark();
        }
    }
    
    // currently not using 
    public void checkEnemyProjectileHit() {
        EnemyProjectile p = (EnemyProjectile) getOneIntersectingObject(EnemyProjectile.class);
        if (p != null) {
            removeTouching(EnemyProjectile.class);
        }
    }
}

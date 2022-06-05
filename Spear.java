import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spear here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Spear extends SmoothMover
{
    private int attack_size = 13, attack_index = 0;
    private double scale = 0.13;
    private boolean isAttacking = false;
    GreenfootImage[] attackImages = new GreenfootImage[attack_size];
    SimpleTimer attackTimer = new SimpleTimer();
    private int timerThreshold = 20;
    
    public Spear() {
        for (int i = 0; i < attack_size; i++) {
            attackImages[i] = new GreenfootImage("./sprites/spear-long-v2/attack" + i + ".png");
            attackImages[i].scale((int)(attackImages[i].getWidth() * (scale + 0.05)), (int)(attackImages[i].getHeight() * scale));
        }
        setImage(attackImages[0]);
    }
    
    public void act()
    {
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
            isAttacking = true;
        }
        else if (attack_index >= attack_size) {
            isAttacking = false;
            attack_index = 0;
        }
    }
    
    public void attackAnimate() {
        if (attack_index >= attack_size) return;
        if (attackTimer.millisElapsed() > timerThreshold) {
            setImage(attackImages[attack_index]);
            attack_index++;
            attackTimer.mark();
            checkEnemyHit();
            timerThreshold -= 4;
        }
    }
    
    public void checkEnemyHit() {
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if (enemy != null) {
            removeTouching(Enemy.class);
        }
    }
}

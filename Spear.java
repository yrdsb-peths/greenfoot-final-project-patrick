import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The player's spear weapon.
 * 
 * @author Patrick Hu
 * @version June 2022
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
    
    /**
     * Makes the spear face the cursor.
     */
    public void faceCursor() {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null) {
            turnTowards(mi.getX(), mi.getY());
        }
    }
    
    /**
     * Checks whether the spear in the attacking state.
     * If so, trigger its attack animation.
     */
    public void checkAttack() {
        if (Greenfoot.isKeyDown("space")) {
            attackSound.stop(); attackSound.play();
            isAttacking = true;
            // states are needed as simply calling attackAnimate() here would only call it once since
            // "space" is only pressed once when the player wants to attack.
            // Thus a state is needed. If (isAttacking) then animate the spear and check if its touching an enemy.
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
}

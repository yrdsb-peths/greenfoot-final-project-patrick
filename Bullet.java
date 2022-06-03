import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{   
    private int speed = 3;
    private double scaleSmall = 0.5;
    private double scaleLarge = 6;
    
    public Bullet(boolean isEnemyBullet) {
        if (isEnemyBullet) {
            setImage("sprites/bullets/enemyBullet2.png");
            getImage().scale((int)(getImage().getWidth() * scaleLarge), (int)(getImage().getHeight() * scaleLarge));
        }
        else {
            switch (GameInfo.currentWeapon) {
                case "pistol":
                    setImage("sprites/guns/PNG/small_bullet.png"); // pistol bullet
                case "bow":  
            }
            
            getImage().scale((int)(getImage().getWidth() * scaleSmall), (int)(getImage().getHeight() * scaleSmall));
        }
        
    }

    public void act()
    {
        move(speed);
    }
}

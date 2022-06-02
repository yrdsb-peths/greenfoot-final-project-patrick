import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Weapon extends Actor
{
    private int bulletSpeed = 0;
    private int bulletDmg = 0;
    
    public Weapon(int bulletSpeed, int bulletDmg) {
        this.bulletSpeed = bulletSpeed;
        this.bulletDmg = bulletDmg;
    }
    
    public void checkMovement() {
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - Player.speed);
        }
        if (Greenfoot.isKeyDown("a")) {
            move(Player.speed * -1);
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + Player.speed);
        }
        if (Greenfoot.isKeyDown("d")) {
            move(Player.speed);
        }
    }
}

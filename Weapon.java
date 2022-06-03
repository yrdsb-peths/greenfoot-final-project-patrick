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
}

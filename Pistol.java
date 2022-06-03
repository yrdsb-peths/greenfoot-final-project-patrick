import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pistoll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pistol extends Weapon
{
    public Pistol() {
        setImage("sprites/guns/PNG/pistol.png");
        getImage().scale(30, 30);
    }
    
    public void act()
    {        
        faceCursor();
        checkFire();
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends GameWorld
{   
    public Level1() {
        super();
        GameInfo.currentWeapon = "pistol";
        // spawn player
        Player player = new Player();
        addObject(player, WIDTH / 2, HEIGHT / 2);
        // spawn pistol
        Pistol pistol  = new Pistol();
        addObject(pistol, WIDTH / 2 + 30, HEIGHT / 2 + 30);
        // spawn enemies
        Level1Enemy e1 = new Level1Enemy();
        addObject(e1, WIDTH / 4, HEIGHT / 4);
        Level1Enemy e2 = new Level1Enemy();
        addObject(e2, WIDTH - WIDTH / 4, HEIGHT / 4);
        Level1Enemy e3 = new Level1Enemy();
        addObject(e3, WIDTH / 4, HEIGHT - HEIGHT / 4);
        Level1Enemy e4 = new Level1Enemy();
        addObject(e4, WIDTH - WIDTH / 4, HEIGHT - HEIGHT / 4);
    }
}

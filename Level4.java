import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4 extends GameWorld {
    SimpleTimer spawnTimer = new SimpleTimer();
    Shaman sha1, sha2, sha3;
    Wizard wiz1, wiz2;
    Imp i1, i2, i3, i4;
    boolean[] spawned = new boolean[5];
    
    public Level4() {
        super(800, 600, 1);
        // spawn player
        Player p = new Player(4);
        addObject(p, getWidth() / 2, getHeight()  - 50);
        // spawn spear
        Spear s = new Spear();
        addObject(s, getWidth() / 2, getHeight()  - 50);
        // create num arrow label
        NumArrowLabel numArrowLabel = new NumArrowLabel(20);
        addObject(numArrowLabel, getWidth() - 40, getHeight() - 40);
    }
    
    public void act() {
        // once last enemy's been killed, spawn watermelon
        if (spawnTimer.millisElapsed() > 500 && !spawned[0]) {
            sha1 = new Shaman(2, "horizontal", "right", true);
            addObject(sha1, 72, 58);
            sha2 = new Shaman(2, "horizontal", "left", true);
            addObject(sha2, 723, 507);
            spawned[0] = true;
        }
        // once both shamans have been killed, spawn a wizard
        if (spawned[0] && sha1.getWorld() == null && sha2.getWorld() == null && !spawned[1]) {
            wiz1 = new Wizard(5, true);
            addObject(wiz1, 50, getHeight() / 2);
            
            spawned[1] = true;
        }
        if (spawned[1] && wiz1.getWorld() == null && !spawned[2]) {
            i1 = new Imp(1);
            i2 = new Imp(1);
            i3 = new Imp(1);
            i4 = new Imp(1);
            addObject(i1, getWidth() / 2, 0);
            addObject(i2, getWidth(), getHeight() / 2);
            addObject(i3, getWidth() / 2, getHeight());
            addObject(i4, 0, getHeight() / 2);
            spawned[2] = true;
        }
        if (spawned[2] && i1.getWorld() == null && i2.getWorld() == null && i3.getWorld() == null && i4.getWorld() == null && !spawned[3]) {
            wiz2 = new Wizard(7, false);
            addObject(wiz2, getWidth() - 50, getHeight() / 2);
            sha3 = new Shaman(5, "vertical", "down", true);
            addObject(sha3, 50, getHeight() / 2);
            spawned[3] = true;
        }
        if (spawned[3] && wiz2.getWorld() == null && sha3.getWorld() == null) {
            // spawn watermelon
            Watermelon melon = new Watermelon(4);
            addObject(melon, getWidth() / 2, getHeight() / 2);
        }
    }
    
    public void levelPass() {
        Greenfoot.setWorld(new Level4Pass());
    }
}

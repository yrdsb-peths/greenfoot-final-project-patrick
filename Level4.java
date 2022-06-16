import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The 4th level of the game. Contains multiple stages that spawn after the previous
 * one has been defeated.
 * Stage 1 - contains 2 shamans on the top left and bottom right that move back and forth.
 * Stage 2 - a new enemy is introduced - wizard. 1 appears in this stage.
 * Stage 3 - 4 imps spawn from the top, right, bottom, and left.
 * Stage 4 - final stage. Contains 2 wizards.
 * The watermelon spawns after each stage is defeated.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class Level4 extends GameWorld
{
    SimpleTimer spawnTimer = new SimpleTimer();
    Shaman sha1, sha2;
    Wizard wiz1, wiz2, wiz3;
    Imp i1, i2, i3, i4;
    boolean[] spawned = new boolean[5];
    boolean watermelonSpawned = false;
    
    public Level4() {
        super(800, 600, 1, 4);
        // spawn player
        Player p = new Player();
        addObject(p, getWidth() / 2, getHeight() / 2);
        // spawn spear
        Spear s = new Spear();
        addObject(s, getWidth() / 2, getHeight() / 2);
        // create num arrow label
        NumArrowLabel numArrowLabel = new NumArrowLabel(40);
        addObject(numArrowLabel, getWidth() - 40, getHeight() - 40);
    }
    
    /**
     * Spawns each stage only after the previous one has been passed.
     */
    public void act() {
        super.act();
        // once last enemy's been killed, spawn watermelon
        if (spawnTimer.millisElapsed() > 500 && !spawned[0]) {
            sha1 = new Shaman(0, 2, 3, 3, "horizontal", "right");
            addObject(sha1, 72, 100);
            sha2 = new Shaman(1, 2, 3, 3, "horizontal", "left");
            addObject(sha2, 723, 507);
            spawned[0] = true;
        }
        // once both shamans have been killed, spawn a wizard
        if (spawned[0] && sha1.getWorld() == null && sha2.getWorld() == null && !spawned[1]) {
            wiz1 = new Wizard(2, 6, 3, 2.5);
            addObject(wiz1, 50, getHeight() / 2);
            
            spawned[1] = true;
        }
        if (spawned[1] && wiz1.getWorld() == null && !spawned[2]) {
            i1 = new Imp(3, 1, 1.2, 2.5);
            i2 = new Imp(4, 1, 1.2, 2.5);
            i3 = new Imp(5, 1, 1.2, 2.5);
            i4 = new Imp(6, 1, 1.2, 2.5);
            addObject(i1, getWidth() / 2, 0);
            addObject(i2, getWidth(), getHeight() / 2);
            addObject(i3, getWidth() / 2, getHeight());
            addObject(i4, 0, getHeight() / 2);
            spawned[2] = true;
        }
        if (spawned[2] && i1.getWorld() == null && i2.getWorld() == null && i3.getWorld() == null && i4.getWorld() == null && !spawned[3]) {
            wiz2 = new Wizard(7, 5, 3, 2.5);
            addObject(wiz2, getWidth() - 50, getHeight() / 2);
            wiz3 = new Wizard(8, 5, 3, 2.5);
            addObject(wiz3, 50, getHeight() / 2);
            spawned[3] = true;
        }
        if (spawned[3] && wiz2.getWorld() == null && wiz3.getWorld() == null && !watermelonSpawned) {
            // spawn watermelon
            Watermelon melon = new Watermelon(4);
            addObject(melon, getWidth() / 2, getHeight() / 2);
            watermelonSpawned = true;
        }
    }
    
    public void levelPass() {
        Greenfoot.setWorld(new Level4Pass());
    }
}

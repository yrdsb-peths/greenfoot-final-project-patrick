import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * First level of the game. Contains a line of skeletons that take turns shooting.
 * Player only has a spear and must dodge the enemy projectiles and kill a skeleton to proceed.
 * 
 * @ Patrick Hu 
 * @ June 2022
 */
public class Level1 extends GameWorld
{   
    private boolean flip = false;
    ArrayList<Skeleton> skellies = new ArrayList<Skeleton>();
    
    public Level1() {
        super(800, 600, 1, 1);
        // spawn player
        addObject(player, getWidth() / 2, getHeight() - 50);
        // spawn spear
        addObject(spear, getWidth() / 2, getHeight() - 50);
        // generate walls
        for (int x = 170, y = getHeight(); y >= -20;) { // condition of y >= -20 to ensure last wall gets placed
            Wall wall = new Wall("vertical");
            addObject(wall, x, y);
            y -= wall.getImage().getHeight();
        }
        for (int x = getWidth() - 170, y = getHeight(); y >= -20;) {
            Wall wall = new Wall("vertical");
            addObject(wall, x, y);
            y -= wall.getImage().getHeight();
        }
        // spawn skeletons
        for (int i = 0, x = 220, y = 140; i < 7; x += 60, i++) {
            Skeleton skel = new Skeleton(i, 1, 0, 2.5, "down", 0, false);
            addObject(skel, x, y);
            skellies.add(skel);
        }
        
        // spawn watermelon
        Watermelon melon = new Watermelon(1);
        addObject(melon, getWidth() / 2, 45);
    }
    
    public void act() {
        super.act();
        // periodically make skellies shoot
        if (actCount % 70 == 0 && flip) {
            // even numbers attack
            for (int i = 0; i < skellies.size(); i += 2) {
                if (skellies.get(i).getWorld() != null)
                    skellies.get(i).fire();
            }
            flip = false;
        }
        else if (actCount % 70 == 0 && !flip) {
            // odd numbers attack
            for (int i = 1; i < skellies.size(); i += 2) {
                if (skellies.get(i).getWorld() != null)
                    skellies.get(i).fire();
            }
            flip = true;
        }
    }
    
    public void levelPass() {
        Greenfoot.setWorld(new Level1Pass());
    }
}

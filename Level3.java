import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Third level of the game. Player only has a few arrows to pass. 
 * A line of skeletons fire a fast rate protected within a set of walls.
 * A shaman also attacks the player from the left.
 * The way to complete this level is to first kill the shaman and then kill the first skeleton
 * on the right. This makes it possible to go inside the walls and use the spear to kill the rest
 * of the skeletons.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class Level3 extends GameWorld
{
    private boolean flip = false;
    ArrayList<Skeleton> skellies = new ArrayList<Skeleton>();
    
    public Level3() {
        super(800, 600, 1, 3);
        // spawn player
        Player p = new Player();
        addObject(p, getWidth() - 60, getHeight() / 2);
        // spawn spear
        Spear s = new Spear();
        addObject(s, getWidth() - 60, getHeight() / 2);
        // create num arrow label
        NumArrowLabel numArrowLabel = new NumArrowLabel(8);
        addObject(numArrowLabel, getWidth() - 40, getHeight() - 40);
        // spawn walls
            // right side
        for (int i = 0, x = 670, y = 70; i < 3; i++) {
            Wall w = new Wall("vertical");
            addObject(w, x, y);
            y += w.getImage().getHeight();
        }
            // left side
        for (int i = 0, x = 151, y = 70; i < 3; i++) {
            Wall w = new Wall("vertical");
            addObject(w, x, y);
            y += w.getImage().getHeight();
        }
            // middle line
        for (int i = 0, x = 651, y = 52; i < 11; i++) {
            Wall w = new Wall("horizontal");
            addObject(w, x, y);
            x -= w.getImage().getWidth();
        }   
            // rest
        Wall w1 = new Wall("horizontal");
        w1.getImage().mirrorVertically();
        addObject(w1, 651, 185);
        Wall w2 = new Wall("horizontal");
        w2.getImage().mirrorVertically();
        addObject(w2, 171, 185);
        Wall w3 = new Wall("diagonal-facing-up");
        addObject(w3, 690, 35);
        Wall w4 = new Wall("diagonal-facing-up");
        addObject(w4, 720, 4);
        // spawn skellies
        for (int i = 0, x = 595, y = 95; i < 9; i++) {
            Skeleton skel = new Skeleton(i, 1, 0, 2.5, "down", 150, false);
            addObject(skel, x, y);
            skellies.add(skel);
            x -= 47;
        }
        // spawn shaman
        Shaman sha = new Shaman(0, 2, 3, 3, "vertical", "up");
        addObject(sha, 100, 505);
        // spawn watermelon
        Watermelon melon = new Watermelon(3);
        addObject(melon, 75, 95);
    }
    
    public void act() {
        super.act();
        // periodically make skellies shoot
        if (actCount % 10 == 0 && flip) {
            // even numbers attack
            for (int i = 0; i < skellies.size(); i += 2) {
                if (skellies.get(i).getWorld() != null)
                    skellies.get(i).fire();
            }
            flip = false;
        }
        else if (actCount % 10 == 0 && !flip) {
            // odd numbers attack
            for (int i = 1; i < skellies.size(); i += 2) {
                if (skellies.get(i).getWorld() != null)
                    skellies.get(i).fire();
            }
            flip = true;
        }
    }
    
    public void levelPass() {
        Greenfoot.setWorld(new Level3Pass());
    }
}

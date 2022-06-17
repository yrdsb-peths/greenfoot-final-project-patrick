import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * 5th and last level of the game. Contains the final boss - "Big Demon"
 * The player's friend is trapped inside walls that only disappear once big demon has
 * been defeated. 
 * See BigDemon.java for a description on its attacks and movement.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class Level5 extends GameWorld
{
    BigDemon demon;
    private int actCount = 0;
    private int wallTransparency = 255;
    
    public Level5() {
        super(800, 600, 1, 5);
        // spawn player
        Player player = new Player();
        addObject(player, getWidth() / 2, getHeight()  - 50);
        // spawn spear
        Spear spear = new Spear();
        addObject(spear, getWidth() / 2, getHeight()  - 50);
        // create num arrow label
        NumArrowLabel numArrowLabel = new NumArrowLabel(40);
        addObject(numArrowLabel, getWidth() - 40, getHeight() - 40);
        // spawn big demon
        demon = new BigDemon(0, 25, 2.6, 2.5);
        addObject(demon, getWidth() / 2, getHeight() / 2 - 100);
        // spawn friend
        Friend friend = new Friend();
        addObject(friend, 60, 52);
        // spawn walls around friend
        for (int i = 0, x = 115, y = 26; i < 3; i++) {
            Wall w = new Wall("vertical");
            addObject(w, x, y);
            y += w.getImage().getHeight() - 10;
        }
        for (int i = 0, x = 97, y = 125; i < 3; i++) {
            Wall w = new Wall("horizontal");
            w.getImage().mirrorVertically();
            addObject(w, x, y);
            x -= w.getImage().getWidth();
        }
    }
    
    public void act() {
        super.act();
        if (!demon.isDead) Soundtrack.nightmareKing.playLoop();
        // once the demon's been removed from world
        if (demon.getWorld() == null) {
            fadeWalls();
            if (wallTransparency <= 0) {
                List<Wall> walls = getObjects(Wall.class);
                for (Wall w : walls) {
                    removeObject(w);
                }
            }
        }
    }
    
    /**
     * Makes the walls fade away. Gradually lowers their transparency.
     */
    public void fadeWalls() {
        if (wallTransparency == 0) return;
        if (actCount % 10 == 0) {
            List<Wall> walls = getObjects(Wall.class);
            for (Wall w : walls) {
                w.getImage().setTransparency(wallTransparency);
            }
            wallTransparency -= 5;
        }
    }

    public void levelPass() {
        Greenfoot.setWorld(new GameWinWorld());
    }
}

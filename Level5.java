import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Level5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level5 extends GameWorld
{
    BigDemon demon;
    private int actCount = 0;
    private int wallTransparency = 255;
    
    public Level5() {
        super(800, 600, 1);
        // spawn player
        Player player = new Player(5);
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
        // once the demon's been killed
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

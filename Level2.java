import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bow is unlocked with a limited amount of arrows.
 * 
 * @ Patrick Hu 
 * @version (a version number or a date)
 */
public class Level2 extends GameWorld
{
    private int skelFireRate = 150;
    private int skelX = 680;
    
    public Level2() {
        super(800, 600, 1, 2);
        // spawn player
        Player player = new Player();
        addObject(player, 100, getHeight() / 2);
        // spawn spear
        Spear s = new Spear();
        addObject(s, 100, getHeight() / 2);
        // create num arrow label
        NumArrowLabel numArrowLabel = new NumArrowLabel(25);
        addObject(numArrowLabel, getWidth() - 40, getHeight() - 40);
        // spawn two walls
        for (int i = 0, x = 190, y = 118; i < 3; i++) {
            Wall w = new Wall("vertical");
            addObject(w, x, y);
            y += w.getImage().getHeight();
        }
        for (int i = 0, x = 190, y = 486; i < 3; i++) {
            Wall w = new Wall("vertical");
            addObject(w, x, y);
            y -= w.getImage().getHeight();
        }
        // spawn skeletons
        Skeleton skel1 = new Skeleton(0, 1, 0, 2.5, "left", skelFireRate, true);
        addObject(skel1, skelX, 535);
        Skeleton skel2 = new Skeleton(1, 1, 0, 2.5, "left", skelFireRate, true);
        addObject(skel2, skelX, 300);
        Skeleton skel3 = new Skeleton(2, 1, 0, 2.5, "left", skelFireRate, true);
        addObject(skel3, skelX, 60);
        // spawn shamans
        Shaman sha1 = new Shaman(4, 2, 3, 3, "vertical", "up");
        addObject(sha1, 550, 400);
        // spawn watermelon
        Watermelon melon = new Watermelon(2);
        addObject(melon, getWidth() - 50, getHeight() / 2);
    }
    
    public void act() {
        super.act();
    }
    
    public void levelPass() {
        Greenfoot.setWorld(new Level2Pass());
    }
}

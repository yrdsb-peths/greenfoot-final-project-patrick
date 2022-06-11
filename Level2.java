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
    private int shamanX = 550;
    
    public Level2() {
        super(800, 600, 1);
        // spawn player
        Player player = new Player(2);
        addObject(player, 100, getHeight() / 2);
        // spawn spear
        Spear s = new Spear();
        addObject(s, 100, getHeight() / 2);
        // create num arrow label
        NumArrowLabel numArrowLabel = new NumArrowLabel(20);
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
        Skeleton skel1 = new Skeleton(1, 0, 2.5, "left", skelFireRate, true);
        addObject(skel1, skelX, 535);
        Skeleton skel2 = new Skeleton(1, 0, 2.5, "left", skelFireRate, true);
        addObject(skel2, skelX, 60);
        Skeleton skel3 = new Skeleton(1, 0, 2.5, "left", skelFireRate, true);
        addObject(skel3, skelX, 254);
        Skeleton skel4 = new Skeleton(1, 0, 2.5, "left", skelFireRate, true);
        addObject(skel4, skelX, 338);
        // spawn shamans
        Shaman sha1 = new Shaman(2, 3, 3, "vertical", "up");
        addObject(sha1, shamanX, 245);
        Shaman sha2 = new Shaman(2, 3, 3, "vertical", "up");
        addObject(sha2, shamanX, 545);
        //Shaman sha3 = new Shaman(2, "vertical", false);
        //addObject(sha3, shamanX - 100, 375);
        // spawn watermelon
        Watermelon melon = new Watermelon(2);
        addObject(melon, getWidth() - 50, getHeight() / 2);
    }
    
    public void levelPass() {
        Greenfoot.setWorld(new Level2Pass());
    }
}

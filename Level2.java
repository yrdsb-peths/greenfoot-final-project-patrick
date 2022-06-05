import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bow is unlocked with a limited amount of arrows.
 * 
 * @ Patrick Hu 
 * @version (a version number or a date)
 */
public class Level2 extends GameWorld
{
    public Level2()
    {
        super(800, 600, 1);
        resetArrowCount();
        // spawn player
        Player player = new Player();
        addObject(player, getWidth() / 2, getHeight() - 100);
        // spawn bow
        Bow bow = new Bow();
        addObject(bow, getWidth() / 2, getHeight() - 100);
        // create num arrow label
        initNumArrowLabel();
    }
    
    public void act() {
        updateNumArrowLabel();
    }
    
    public void resetArrowCount() {
        Bow.numArrows = Bow.STARTING_NUM_ARROWS;
    }
}

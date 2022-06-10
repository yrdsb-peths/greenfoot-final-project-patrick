import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1Pass here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Level1Pass extends LevelPassWorld
{
    public Level1Pass() {
        super(800, 600, 1);
        Image player = new Image("./sprites/player/lizard_m_idle_anim_f0.png", 8);
        player.turn(-45);
        addObject(player, 130, 460);
        Image melon = new Image("./sprites/watermelon/watermelon.png", 0.4);
        melon.turn(0);
        addObject(melon, 170, 447);
        
        Label l1 = new Label("You Passed Level 1!", 40);
        addObject(l1, getWidth() / 2, 50);
        Label l2 = new Label("You found a bow lying around! Press 1 and 2 to switch between the spear and bow.", 40);
        
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Level2());
        }
    }
}

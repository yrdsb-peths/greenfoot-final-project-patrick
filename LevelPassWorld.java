import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelPassWorld here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class LevelPassWorld extends World
{
    private int playerScale = 5;
    private int actCount = 0;
    private int idle_size = 4, idle_index = 0;
    Image player = new Image("./sprites/player/lizard_m_idle_anim_f0.png", playerScale);
    GreenfootImage[] idleFacingLeft = new GreenfootImage[idle_size];
    
    public LevelPassWorld(int width, int height, int pixelSize) {    
        super(width, height, pixelSize);
        // initialize player sprite
        for (int i = 0; i < idle_size; i++) {
            idleFacingLeft[i] = new GreenfootImage("./sprites/player/lizard_m_idle_anim_f" + i + ".png");
            idleFacingLeft[i].scale((int)(idleFacingLeft[i].getWidth() * playerScale), (int)(idleFacingLeft[i].getHeight() * playerScale));
            idleFacingLeft[i].mirrorHorizontally();
        }
        player.getImage().mirrorHorizontally();
        //player.turn(-45);
        addObject(player, 400, 345);
        Image melon = new Image("./sprites/watermelon/watermelon.png", 0.23);
        melon.turn(45);
        addObject(melon, 370, 371);
    }
    
    public void act() {
        actCount++;
        idleAnimate();
    }
    
     public void idleAnimate() {
        if (actCount % 9 == 0) {
            player.setImage(idleFacingLeft[idle_index]);
            idle_index++;
            idle_index %= idle_size;
        }
    }
}

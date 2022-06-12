import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWinWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWinWorld extends World
{    
    private double scale = 6.5;
    private int player_x = 295, player_y = getHeight() - 40;
    private int friend_x = 500, friend_y = player_y;
    private int actCount = 0;
    private int idle_size = 4, idle_index = 0;
    Image player = new Image();
    Image friend = new Image();
    Image player_melon = new Image();
    Image friend_melon = new Image();
    GreenfootImage[] playerIdleFacingRight = new GreenfootImage[idle_size];
    GreenfootImage[] friendIdleFacingLeft = new GreenfootImage[idle_size];
    
    public GameWinWorld() {    
        super(800, 600, 1);
        setBackground("./images/game-complete.png");
        // initialize player sprites
        for (int i = 0; i < idle_size; i++) {
            playerIdleFacingRight[i] = new GreenfootImage("./sprites/player/lizard_m_idle_anim_f" + i + ".png");
            playerIdleFacingRight[i].scale((int)(playerIdleFacingRight[i].getWidth() * scale), (int)(playerIdleFacingRight[i].getHeight() * scale));
        }
        // initialize friend sprites
        for (int i = 0; i < idle_size; i++) {
            friendIdleFacingLeft[i] = new GreenfootImage("./sprites/friend/lizard_f_idle_anim_f" + i + ".png");
            friendIdleFacingLeft[i].scale((int)(friendIdleFacingLeft[i].getWidth() * scale), (int)(friendIdleFacingLeft[i].getHeight() * scale));
            friendIdleFacingLeft[i].mirrorHorizontally();
        }
        // set images
        player.setImage(playerIdleFacingRight[0]);
        friend.setImage(friendIdleFacingLeft[0]);
        // initialize watermlon images
        for (int i = 0; i < 2; i++) {
            Image melon = new Image();
            melon.setImage("./sprites/watermelon/watermelon.png");
            melon.getImage().scale((int)(melon.getImage().getWidth() * 0.26), (int)(melon.getImage().getHeight() * 0.26));    
            melon.turn(45);
            if (i == 0) {
                player_melon = melon;
            }
            else friend_melon = melon;
        }
        // add player, friend and watermelons to world
        addObject(player, player_x, player_y);
        addObject(player_melon, player_x + 23, player_y + 32);
        addObject(friend, friend_x, friend_y);  
        addObject(friend_melon, friend_x - 23, friend_y + 32);
    }
    
    public void act() {
        actCount++;
        idleAnimate();
    }
    
     public void idleAnimate() {
        if (actCount % 9 == 0) {
            player.setImage(playerIdleFacingRight[idle_index]);
            friend.setImage(friendIdleFacingLeft[idle_index]);
            idle_index++;
            idle_index %= idle_size;
        }
    }
}

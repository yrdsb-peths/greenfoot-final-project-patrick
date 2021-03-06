import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world the player is taken to once they complete the game.
 * 
 * @author Patrick Hu
 * @version June 2022
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
    GifImage night;
    Image gameCompleteText;
    Image credit;
    
    public GameWinWorld() {    
        super(800, 600, 1);
        // initialize starry night gif
        night = new GifImage("./gifs/blue_sky_pixel_animation.gif");
        for (GreenfootImage img : night.getImages()) {
            img.scale((int)(img.getWidth() * 2), (int)(img.getHeight() * 2));
        }
        // initialize game complete text
        gameCompleteText = new Image("./images/galactica/game-complete.png", 1);
        addObject(gameCompleteText, getWidth() / 2, getHeight() / 2);
        // initialize art and music credits
        credit = new Image("./images/vecna/credit.png", 1);
        addObject(credit, 237, 44);
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
        animateBackground();
        idleAnimate();
        Soundtrack.stopAllExceptGameWin();
        Soundtrack.gameWinTrack.playLoop();
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new GameStartWorld());
        }
    }
    
    /**
     * Animate the background gif.
     */
    public void animateBackground() {
        setBackground(night.getCurrentImage());        
    }
    
    /**
     * Idle animation for the player and friend.
     */
    public void idleAnimate() {
        if (actCount % 9 == 0) {
            player.setImage(playerIdleFacingRight[idle_index]);
            friend.setImage(friendIdleFacingLeft[idle_index]);
            idle_index++;
            idle_index %= idle_size;
        }
    }
    
    public void stopped() {
        Soundtrack.gameWinTrack.pause();
    }
}

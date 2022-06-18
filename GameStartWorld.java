import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The starting screen for the game.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class GameStartWorld extends World
{
    private int actCount = 0;
    private double scale = 0.7;
    Image title;
    Image startButton;
    
    public GameStartWorld() {
        super(800, 600, 1);
        setBackground("./images/castle2.jpg");
        
        // place all text images
        title = new Image("./images/future-time-splitters/title.png", 1);
        addObject(title, 220, 115);
        startButton = new Image("./images/vecna/start-game.png", scale);
        addObject(startButton, 151, 260);
        
        // whenever user goes back to GameStartWorld their health should be reset
        Player.health = 3;
        // although health is also reset after dying, it needs to be reset after winning
        // health is reset after dying for testing reasons when the user wants to immediately replay a stage after dying
    }
    
    public void act() {
        Soundtrack.stopAllExceptMain(); // sometimes previous audio is playing when jumping between worlds when testing
        {
            Soundtrack.setVolumes();
            Soundtrack.mainSoundtrack.playLoop();
            // main soundtrack is played in act() instead of started() or constructor GameStartWorld() because
            // 1. when player dies they are taken back to GameStartWorld but music won't play because started() is only called when "Run" is hit
            // 2. GameStartWorld() will cause the music to play before "Run" is hit due to it being called early
        }
        // hovering effect for start button
        if (Greenfoot.mouseMoved(startButton)) {
            startButton.setImage("./images/vecna/start-game-yellow.png");
            startButton.scale(scale);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(startButton)) {
            startButton.setImage("./images/vecna/start-game.png");
            startButton.scale(scale);
        }
        if (Greenfoot.mouseClicked(startButton)) {
            Greenfoot.setWorld(new Instructions());
        }
    }
    
    public void stopped() {
        Soundtrack.mainSoundtrack.pause();
    }
}

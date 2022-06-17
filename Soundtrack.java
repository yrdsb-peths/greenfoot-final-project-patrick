import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Contains the soundtracks of Castle and Nightmare King which can be accessed 
 * throughout the program because they are static fields.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class Soundtrack extends Actor
{
    public static GreenfootSound castle = new GreenfootSound("./sounds/castle.mp3");
    public static GreenfootSound nightmareKing = new GreenfootSound("./sounds/nightmare-king.mp3");
    public static GreenfootSound mainSoundtrack = new GreenfootSound("./sounds/enter-hallownest2.mp3");
    public static GreenfootSound gameWinTrack = new GreenfootSound("./sounds/dating-start.mp3");
    
    /**
     * Sets the volumes of all soundtracks to an appropriate volume.
     */
    public static void setVolumes() {
        castle.setVolume(50);
        nightmareKing.setVolume(100);
        mainSoundtrack.setVolume(60);
        gameWinTrack.setVolume(80);
    }
    
    public static void stopAll() {
        castle.stop();
        nightmareKing.stop();
        mainSoundtrack.stop();
        gameWinTrack.stop();
    }
    
    /**
     * Stops all soundtracks except for the main one. Useful when testing the game as it allows
     * the programmer to jump between worlds and have the correct soundtrack playing.
     * For example, in Level 5 nightmareKing is playing, and jumping to any other level will result in nightmareKing still playing beneath the main soundtrack.
     * Stopping all tracks except for main resolves this issue.
     */
    public static void stopAllExceptMain() {
        castle.stop();
        nightmareKing.stop();
        gameWinTrack.stop();
    }
    
    /**
     * Stops all tracks except for nightmare king.
     */
    public static void stopAllExceptNightmareKing() {
        castle.stop();
        mainSoundtrack.stop();
        gameWinTrack.stop();
    }
    
    public static void stopAllExceptGameWin() {
        castle.stop();
        mainSoundtrack.stop();
        nightmareKing.stop();
    }
}

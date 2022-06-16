import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Contains the soundtracks of Castle and Nightmare King which can be accessed 
 * throughout the program because they are static fields.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Soundtrack extends Actor
{
    public static GreenfootSound castle = new GreenfootSound("./sounds/dead-cells-castle.mp3");
    public static GreenfootSound nightmareKing = new GreenfootSound("./sounds/nightmare-king.mp3");
    public static GreenfootSound merchant = new GreenfootSound("./sounds/dead-cells-merchant.mp3");
    
    public static void setVolumes() {
        castle.setVolume(40);
        nightmareKing.setVolume(40);
    }
    
    public static void reset() {
        castle.stop();
        nightmareKing.stop();
        merchant.stop();
    }
}

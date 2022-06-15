import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Soundtrack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soundtrack extends Actor
{
    public static GreenfootSound castle = new GreenfootSound("./sounds/dead-cells-castle.mp3");
    public static GreenfootSound nightmareKing = new GreenfootSound("./sounds/nightmare-king.mp3");
    SimpleTimer timer = new SimpleTimer();
    
    public static void setVolumes() {
        castle.setVolume(40);
        nightmareKing.setVolume(40);
    }
    
    public static void reset() {
        castle.stop();
        nightmareKing.stop();
    }
    
    public static void fadeCastle() {
        
    }
}

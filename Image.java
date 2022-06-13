import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Wrapper class for Actor.
 * Simply an Actor with just an image.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Image extends Actor
{
    public Image() {
        
    }
    
    public Image(String path, double scale) {
        setImage(path);
        getImage().scale((int)(getImage().getWidth() * scale), (int)(getImage().getHeight() * scale));
    }
    
    public void scale(double amount) {
        getImage().scale((int)(getImage().getWidth() * amount), (int)(getImage().getHeight() * amount));
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Wrapper class for Actor.
 * Simply an Actor with just an image.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class Image extends Actor
{
    /**
     * Empty constructor. Used when initializing an image is not desired.
     */
    public Image() {
                
    }
    
    /**
     * Constructs an actor with an image.
     * 
     * @param path      file path to image
     * @param scale     amount to scale image by
     */
    public Image(String path, double scale) {
        setImage(path);
        getImage().scale((int)(getImage().getWidth() * scale), (int)(getImage().getHeight() * scale));
    }
    
    /**
     * Scales an image by specified amount
     * 
     * @param amount    amount to scale image by
     */
    public void scale(double amount) {
        getImage().scale((int)(getImage().getWidth() * amount), (int)(getImage().getHeight() * amount));
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A single segment of a wall.
 * 
 * @author Patrick Hu
 * @version June 2022
 */
public class Wall extends Actor
{
    String type;
    
    /**
     * Constructs a wall segment. 
     * 
     * @param type      the type of wall. Either "vertical" or "horizontal".
     */
    public Wall(String type) {
        this.type = type;
        switch (type) {
            case "vertical": {
                setImage("./sprites/walls/simple/vertical-wall.png");
                break;
            }                
            case "horizontal": {
                setImage("./sprites/walls/simple/horizontal-wall.png");
                break;
            }
            case "diagonal-facing-up": {
                setImage("./sprites/walls/simple/vertical-wall.png");
                setRotation(45);
                break;
            }
            case "diagonal-facing-down": {
                setImage("./sprites/walls/simple/vertical-wall.png");
                setRotation(-45);
                break;
            }
        }
        getImage().scale((int)(getImage().getWidth() * 3), (int)(getImage().getHeight() * 3));
    }
}

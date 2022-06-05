import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WallTile here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    String type;
    
    public Wall(String type) {
        this.type = type;
        switch (type) {
            case "vertical":
                setImage("./sprites/walls/simple/vertical-wall.png");
                break;
            case "horizontal":
                setImage("./sprites/walls/simple/horizontal-wall.png");
                break;
        }
        getImage().scale((int)(getImage().getWidth() * 3), (int)(getImage().getHeight() * 3));
    }
    
    public void act()
    {

    }
}

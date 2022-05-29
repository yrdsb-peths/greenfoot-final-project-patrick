import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends MainObjects
{
    public int speed = 3;
    public int jumpHeight = -11;
    public int verticalSpeed = 0;
    public int acceleration = 1;
    
    public void act()
    {
        checkMovement();
        checkFalling();
        checkOffMap();
    }
    
    public void checkMovement() {
        Actor ladderBelow = getOneObjectAtOffset(0, 50, Ladder.class);
        if (isTouching(Ladder.class)) {
            if (Greenfoot.isKeyDown("w")) {
                setLocation(getX(), getY() - speed);
            }
            if (Greenfoot.isKeyDown("s") && !isOnGround()) {
                setLocation(getX(), getY() + speed);
            }
        }
        if (ladderBelow != null) {
            if (Greenfoot.isKeyDown("s")) {
                setLocation(getX(), getY() + speed);
            }
        }
        if (Greenfoot.isKeyDown("d")) {
            move(speed);
        }
        if (Greenfoot.isKeyDown("a")) {
            move(speed * -1);
        }
        if (Greenfoot.isKeyDown("space") && isOnGround()) {
            verticalSpeed = jumpHeight;
            fall();
        }        
    }
    
    public void checkFalling() {
        if (!isOnGround() && !isTouching(Ladder.class)) {
            fall();
        }
    }
    
    public void fall() {
        setLocation(getX(), getY() + verticalSpeed);
        verticalSpeed += acceleration;
    }
    
    public void checkOffMap() {
        if (getY() == Level1.HEIGHT - 1) { // on the floor of the world
            Level1 world = (Level1) getWorld();
            world.gameOver();
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Projectile
{
    private int speed = 3;
    private double scale = 3.2;
    String direction;
    
    public Ball(String direction) {
        this.direction = direction;
        setImage("./sprites/bullets/orc-shaman-bullet.png");
        getImage().scale((int)(getImage().getWidth() * scale), (int)(getImage().getHeight() * scale));
    }
    
    public void act()
    {
        move();
        checkPlayerHit();
        checkAtWall();
    }
    
    public void move() {
        int dx = 0, dy = 0; 
        switch (direction) {
            case "up":
                dy -= speed;
            case "down":
                dy += speed;
            case "left":
                dx -= speed;
            case "right": 
                dx += speed;
        }
        setLocation(getX() + dx, getY() + dy);
    }
    
    public void checkPlayerHit() {
        if (isTouching(Player.class)) {
            GameWorld world = (GameWorld) getWorld();
            world.gameOver();
        }
    }
}

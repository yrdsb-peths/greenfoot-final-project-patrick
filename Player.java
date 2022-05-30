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
    public int run_index = 0;
    public boolean facingRight = false;
    SimpleTimer animTimer = new SimpleTimer();
    GreenfootImage[] runFacingRight = new GreenfootImage[10];
    GreenfootImage[] runFacingLeft = new GreenfootImage[10];
    
    public Player() {
        for (int i = 0; i <= 9; i++) {
            int x = i + 1;
            runFacingRight[i] = new GreenfootImage("./sprites/knight/Run (" + x + ").png");
            runFacingRight[i].scale(60, 60);
            runFacingLeft[i] = new GreenfootImage("./sprites/knight/Run (" + x + ").png");
            runFacingLeft[i].scale(60, 60);
            runFacingLeft[i].mirrorHorizontally();
        }
        setImage(runFacingLeft[0]);
    }
    
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
            facingRight = true;
            move(speed);
            runAnimate();
        }
        if (Greenfoot.isKeyDown("a")) {
            facingRight = false;
            move(speed * -1);
            runAnimate();
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
    
    public void runAnimate() {
        if (animTimer.millisElapsed() > 60) {
            if (facingRight) {
                setImage(runFacingRight[run_index]);
            }
            else {
                setImage(runFacingLeft[run_index]);    
            }
            run_index++;
            run_index %= 10;
            animTimer.mark();
        }
    }
}

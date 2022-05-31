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
    public int jumpHeight = -12;
    public int verticalSpeed = 0;
    public int acceleration = 1;
    public int run_index = 0;
    public int run_size = 6;
    public int idle_index = 0;
    public int idle_size = 4;
    public boolean facingRight = false;
    SimpleTimer animTimer = new SimpleTimer();
    GreenfootImage[] runFacingRight = new GreenfootImage[run_size];
    GreenfootImage[] runFacingLeft = new GreenfootImage[run_size];
    GreenfootImage[] idleFacingRight = new GreenfootImage[idle_size];
    GreenfootImage[] idleFacingLeft = new GreenfootImage[idle_size];
    
    public Player() {
        // init run sprites
        int catWidth = 50;
        int catHeight = 40;
        for (int i = 0; i < run_size; i++) {            
            runFacingRight[i] = new GreenfootImage("./sprites/Ninjarun/run" + i +".png");
            runFacingRight[i].scale(catWidth, catHeight);
            runFacingLeft[i] = new GreenfootImage("./sprites/Ninjarun/run" + i +".png");
            runFacingLeft[i].scale(catWidth, catHeight);
            runFacingLeft[i].mirrorHorizontally();
        }
        // init idle sprites
        for (int i = 0; i < 3; i++) {
            idleFacingRight[i] = new GreenfootImage("./sprites/Ninjarun/run" + i +".png");
            idleFacingRight[i].scale(catWidth, catHeight);
            idleFacingLeft[i] = new GreenfootImage("./sprites/Ninjarun/run" + i +".png");
            idleFacingLeft[i].scale(catWidth, catHeight);
            idleFacingLeft[i].mirrorHorizontally();
        }
        setImage(idleFacingLeft[0]);
    }
    
    public void act()
    {
        checkMovement();
        checkFalling();
        checkOffMap();
        
    }
    
    public void checkMovement() {
        Actor ladderBelow = getOneObjectAtOffset(0, 50, Ladder.class);
        boolean up = Greenfoot.isKeyDown("w");
        boolean down = Greenfoot.isKeyDown("s");
        boolean left = Greenfoot.isKeyDown("a");
        boolean right = Greenfoot.isKeyDown("d");
        boolean jump = Greenfoot.isKeyDown("space");
        
        if (isTouching(Ladder.class)) {
            if (up) {
                setLocation(getX(), getY() - speed);
            }
            if (down && !isOnGround()) {
                setLocation(getX(), getY() + speed);
            }
        }
        if (ladderBelow != null) {
            if (down) {
                setLocation(getX(), getY() + speed);
            }
        }
        if (right) {
            facingRight = true;
            move(speed);
            runAnimate();
        }
        if (left) {
            facingRight = false;
            move(speed * -1);
            runAnimate();
        }
        if (jump && isOnGround()) {
            verticalSpeed = jumpHeight;
            fall();
        }
        if (!up && !down && !left && !right && !jump) {
            idleAnimate();
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
            Level1 level1 = (Level1) getWorld();
            level1.gameOver();
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
            run_index %= run_size;
            animTimer.mark();
        }
    }
    
    public void idleAnimate() {
        if (animTimer.millisElapsed() > 120) {
            if (facingRight) {
                setImage(idleFacingRight[idle_index]);
            }
            else {
                setImage(idleFacingLeft[idle_index]);    
            }
            idle_index++;
            idle_index %= idle_size;
            animTimer.mark();
        }
    }
}

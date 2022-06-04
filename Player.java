import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public static int speed = 3;
    private boolean facingRight = false;
    private int idle_size = 4, idle_index = 0;
    private int run_size = 4, run_index = 0;
    private double playerScale = 2.6;
    GreenfootImage[] idleFacingRight = new GreenfootImage[idle_size];
    GreenfootImage[] idleFacingLeft = new GreenfootImage[idle_size];
    GreenfootImage[] runFacingRight = new GreenfootImage[run_size];
    GreenfootImage[] runFacingLeft = new GreenfootImage[run_size];
    SimpleTimer idleTimer = new SimpleTimer();
    SimpleTimer runTimer = new SimpleTimer();
    
    public Player() {
        // initialize sprites
        for (int i = 0; i < idle_size; i++) {
            idleFacingRight[i] = new GreenfootImage("./sprites/player/lizard_m_idle_anim_f" + i + ".png");
            idleFacingRight[i].scale((int)(getImage().getWidth() * playerScale), (int)(getImage().getHeight() * playerScale));
            idleFacingLeft[i] = new GreenfootImage("./sprites/player/lizard_m_idle_anim_f" + i + ".png");
            idleFacingLeft[i].scale((int)(getImage().getWidth() * playerScale), (int)(getImage().getHeight() * playerScale));
            idleFacingLeft[i].mirrorHorizontally();
        }
        for (int i = 0; i < run_size; i++) {
            runFacingRight[i] = new GreenfootImage("./sprites/player/lizard_m_run_anim_f" + i + ".png");
            runFacingRight[i].scale((int)(getImage().getWidth() * playerScale), (int)(getImage().getHeight() * playerScale));
            runFacingLeft[i] = new GreenfootImage("./sprites/player/lizard_m_run_anim_f" + i + ".png");
            runFacingLeft[i].scale((int)(getImage().getWidth() * playerScale), (int)(getImage().getHeight() * playerScale));
            runFacingLeft[i].mirrorHorizontally();
        }
    }
    
    public void act()
    {
        move();
        moveGun();
    }
    
    public void move() {
        int dx = 0, dy = 0;
        if (Greenfoot.isKeyDown("w")) {
            dy -= speed;
            runAnimate();
        }
        if (Greenfoot.isKeyDown("a")) {
            facingRight = false;
            dx -= speed;
            runAnimate();
        }
        if (Greenfoot.isKeyDown("s")) {
            dy += speed;
            runAnimate();
        }
        if (Greenfoot.isKeyDown("d")) {
            facingRight = true;
            dx += speed;
            runAnimate();
        }
        if (!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("d") && !Greenfoot.isKeyDown("space")) {
            idleAnimate();
        }
        setLocation(getX() + dx, getY());
        // check wall collision
        if (getOneIntersectingObject(WallTile.class) != null)
            setLocation(getX() - dx, getY());
        setLocation(getX(), getY() + dy);
        if (getOneIntersectingObject(WallTile.class) != null)
            setLocation(getX(), getY() - dy);
    }
    
    public void moveGun() {
        Actor pistol = (Actor)getWorld().getObjects(Pistol.class).get(0);
        pistol.setLocation(getX() + 21, getY() + 30);
    }
    
    public void idleAnimate() {
        if (idleTimer.millisElapsed() > 150) {
            if (facingRight) setImage(idleFacingRight[idle_index]);
            else setImage(idleFacingLeft[idle_index]);
            idle_index++;
            idle_index %= idle_size;
            idleTimer.mark();
        }
    }
    
    public void runAnimate() {
        if (runTimer.millisElapsed() > 100) {
            if (facingRight) setImage(runFacingRight[run_index]);
            else setImage(runFacingLeft[run_index]);
            run_index++;
            run_index %= run_size;
            runTimer.mark();
        }
    }
}
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wizard here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Wizard extends Enemy
{
    private int speed = 3;
    private int health;
    private int idle_size = 4, idle_index = 0;
    private int run_size = 4, run_index = 0;
    private int actCount = 0;
    private double scale = 2.5;
    private boolean facingRight = false;
    GreenfootImage[] idleFacingRight = new GreenfootImage[idle_size];
    GreenfootImage[] idleFacingLeft = new GreenfootImage[idle_size];
    GreenfootImage[] runFacingRight = new GreenfootImage[run_size];
    GreenfootImage[] runFacingLeft = new GreenfootImage[run_size];
    
    public Wizard(int health) {
        this.health = health;
        for (int i = 0; i < idle_size; i++) {
            idleFacingRight[i] = new GreenfootImage("./sprites/wizard/wizzard_m_idle_anim_f" + i + ".png");
            idleFacingRight[i].scale((int)(idleFacingRight[i].getWidth() * scale), (int)(idleFacingRight[i].getHeight() * scale));
            idleFacingLeft[i] = new GreenfootImage("./sprites/wizard/wizzard_m_idle_anim_f" + i + ".png");
            idleFacingLeft[i].scale((int)(idleFacingLeft[i].getWidth() * scale), (int)(idleFacingLeft[i].getHeight() * scale));
            idleFacingLeft[i].mirrorHorizontally();
        }
        for (int i = 0; i < run_size; i++) {
            runFacingRight[i] = new GreenfootImage("./sprites/wizard/wizzard_m_run_anim_f" + i + ".png");
            runFacingRight[i].scale((int)(runFacingRight[i].getWidth() * scale), (int)(runFacingRight[i].getHeight() * scale));
            runFacingLeft[i] = new GreenfootImage("./sprites/wizard/wizzard_m_run_anim_f" + i + ".png");
            runFacingLeft[i].scale((int)(runFacingLeft[i].getWidth() * scale), (int)(runFacingLeft[i].getHeight() * scale));
            runFacingLeft[i].mirrorHorizontally();
        }
        setImage(idleFacingLeft[0]);
    }
    
    public void act()
    {
        actCount++;
        teleport();
        if (actCount % 180 == 0)
            fire();
    }
    
    public void teleport() {
        Player player = (Player) getWorld().getObjects(Player.class).get(0);
        turnTowards(player.getX(), player.getY());
    }
    
    public void fire() {
        // fix ball spread
        Player player = (Player) getWorld().getObjects(Player.class).get(0);
        // initially have all 3 balls face player
        WizardBall b1 = new WizardBall();
        b1.turnTowards(player.getX(), player.getY());
        WizardBall b2 = new WizardBall();
        b2.turnTowards(player.getX(), player.getY());
        WizardBall b3 = new WizardBall();
        b3.turnTowards(player.getX(), player.getY());
        // turn b1 and b3, b2 stays facing the player
        b1.turn(45);
        b3.turn(-45);
        // add all objects to world
        getWorld().addObject(b1, getX(), getY());        
        getWorld().addObject(b2, getX(), getY());
        getWorld().addObject(b3, getX(), getY());
    }
    
    public void idleAnimate() {
        if (actCount % 9 == 0) {
            if (facingRight) setImage(idleFacingRight[idle_index]);
            else setImage(idleFacingLeft[idle_index]);
            idle_index++;
            idle_index %= idle_size;
        }
    }
    
    public void runAnimate() {
        if (actCount % 7 == 0) {
            if (facingRight) setImage(runFacingRight[run_index]);
            else setImage(runFacingLeft[run_index]);
            run_index++;
            run_index %= run_size;
        }
    }
}

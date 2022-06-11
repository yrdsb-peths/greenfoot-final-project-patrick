import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wizard here.
 * 
 * @ Patrick Hu
 * @version (a version number or a date)
 */
public class Wizard extends Enemy {
    private int transparency = 255;
    private boolean isFading = false;
    SimpleTimer fadeTimer = new SimpleTimer();
    SimpleTimer mainTimer = new SimpleTimer();
    
    public Wizard(int health, double speed, double scale) {
        super(health, "wizard", speed, scale);
    }
    
    public void act() {
        super.act();
        checkTeleportingState();
        if (isFading) {
            fade();
        }
        idleAnimate();
        if (actCount % 200 == 0)
            fire();
    }
    
    public void checkTeleportingState() {
        // in this time frame the wizard is fading away
        if (mainTimer.millisElapsed() > 2000 && transparency > 0) {
            isFading = true;
        }
        if (transparency == 0) {
            teleport();
            moveHealthBar();
            transparency = 255;
            // since different parts of the sprites array are now more transparent from fade(), we have to reset the transparency of all sprites to 255
            for (int i = 0; i < idle_size; i++) {
                idleFacingRight[i].setTransparency(255);
                idleFacingLeft[i].setTransparency(255);
            }
            mainTimer.mark();
            isFading = false;
        }
    }
    
    public void teleport() {
        // grab the health bar before teleporting
        var arr = getObjectsAtOffset(0, healthBar_dy, HealthBar.class);
        // get random coordinates that aren't too close to player
        Player player = getWorld().getObjects(Player.class).get(0);
        int rand_x;
        int rand_y;
        double distance;
        do {
            rand_x = getRandomNumber(20, getWorld().getWidth() - 20);
            rand_y = getRandomNumber(20, getWorld().getHeight() - 20);
            distance = getDistanceBetween(rand_x, player.getX(), rand_y, player.getY());    
        } while (distance < 350);
        setLocation(rand_x, rand_y);
        // teleport the health bar
        if (arr.size() == 1) {
            HealthBar bar = arr.get(0);
            bar.setLocation(getX(), getY() + (healthBar_dy));
        }
    }
    
    public void fade() {
        // slowly reduce the transparency of the image
        if (fadeTimer.millisElapsed() > 10 && transparency > 0) {
            getImage().setTransparency(transparency);
            transparency -= 15;
            fadeTimer.mark();
        }
    }
    
    public void fire() {
        WizardBall b1 = new WizardBall();
        WizardBall b2 = new WizardBall();
        WizardBall b3 = new WizardBall();        
        // add all objects to world
        getWorld().addObject(b1, getX(), getY());        
        getWorld().addObject(b2, getX(), getY());
        getWorld().addObject(b3, getX(), getY());
        Player player = (Player) getWorld().getObjects(Player.class).get(0);
        // initially have all 3 balls face player
        b1.turnTowards(player.getX(), player.getY());
        b2.turnTowards(player.getX(), player.getY());
        b3.turnTowards(player.getX(), player.getY());
        // turn b1 and b3 to make a fork pattern
        b1.turn(45);
        b3.turn(-45);
    }
    
    public int getRandomNumber(int start, int end) {
        int x = Greenfoot.getRandomNumber(end - start);
        return x + start;
    }
    
    public double getDistanceBetween(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}

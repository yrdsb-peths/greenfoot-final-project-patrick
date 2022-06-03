import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 *  
 * @ Patrick Hu 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    SimpleTimer shootTimer = new SimpleTimer();
    
    public void shoot() {
        if (shootTimer.millisElapsed() > 500) {
            EnemyBullet bullet = new EnemyBullet();
            Actor player = (Actor)getWorld().getObjects(Player.class).get(0);
            World world = getWorld();
            world.addObject(bullet, getX(), getY());
            bullet.turnTowards(player.getX(), player.getY());
            //bullet.turnTowards(player.getX(), player.getY());
            //bullet.turnTowards(player.getX(), player.getY());            
            shootTimer.mark();
        }        
    }
}
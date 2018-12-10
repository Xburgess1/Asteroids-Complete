import greenfoot.*;

/**
 * A bullet that can hit asteroids.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 */
public class Bullet extends SmoothMover
{
    //TODO (78): Declare a static integer instance constant called DAMAGE initialized to 16
    /** The damage this bullet will deal */
    public final static int DAMAGE = 16;
    
    //TODO (79): Declare an integer instance variable called life that is initialized to 30
    /** A bullet looses one life each act, and will disappear when life = 0 */
    private int life = 30;
    
    /**
     * Bullet is a constructor for objects of type Bullet that
     * allow customization of speed and rotation
     * 
     * @param speed represents the speed of the bullet
     * @param rotation represents the rotation of the bullet
     * @return An object of type Bullet
     */
    public Bullet(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addToVelocity(new Vector(rotation, 15));
        Greenfoot.playSound("EnergyGun.wav");
    }
    
    /**
     * act is the method that is run on every iteration of the act cycle. In the act method if the life of the bullet is equal to or less then 0
     * it removes itself from the world. Else it subtracts 1 from the life, moves the bullet and calls the checkAsteroidHit method.
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        //TODO (85): If the bullet's life is less than or equal to 0...
        if(life <= 0)
        {
            //TODO (86): Remove this bullet from the world
            getWorld().removeObject(this);
        }
        //TODO (87): Otherwise...
        else
        {
            //TODO (88): Decrease the life of the bullet by 1
            life--;
            
            //TODO (89): Make the bullet move
            move();
            
            //TODO (90): Check to see if the bullet has hit an asteroid
            checkAsteroidHit();
        }
    }
    
    /**
     * TODO (80): Declare a method called checkAsteroidHit that does not
     *          return anything and has no parameters
     *          
     * TODO (81): Declare a local Asteroid variable called asteroid that is initialized
     *          to a casted reference of one intersecting object of the Asteroid class
     *          
     * TODO (82): If asteroid is not nothing...
     *  
     *      TODO (83): Remove this object from the world
     *      
     *      TODO (84): Hit asteroid with DAMAGE
     */
    
    /**
     * checkAsteroidHit sets up a Asteroid variable called asteroid then if asteroid is not nothing it removes itself(the bullet) then hits the asteroid
     * with DAMAGE.
     * 
     * @param None there are no parameters
     * @return there is no return
     */
    private void checkAsteroidHit()
    {
        Asteroid asteroid = (Asteroid) getOneIntersectingObject(Asteroid.class);
        if(asteroid != null)
        {
            getWorld().removeObject(this);
            asteroid.hit(DAMAGE);
        }
    }
}
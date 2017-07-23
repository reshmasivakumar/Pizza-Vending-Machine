package shapes;

/**
 * Circle.java - Class respresenting Circle object.
 * 
 * @author Reshma Sivakumar
 * @version 2.0 3/14/2016
 * 
 * Description: This class is inherited from it's parent class Shape.
 *              The getArea () and draw () methods of Shape class are
 *              overriden with functionality specific to Circle class.
 *              
 */
import mainClasses.PizzaException;
import java.awt.geom.Ellipse2D;
import java.awt.*;
import javax.swing.JPanel;

public class Circle extends Shape implements Cloneable
{
    /** Instance Variables of Circle class. **/
    private double radius; // radius of the circle which determines
                            // the size of the circle.
    
    /**
    * Method :          Constructor
    * Purpose :         Constructor for the Circle class takes 
    *                   x and y coordinates as parameters and
    *                   calls the parent Shape class constructor.
    *                   to initialize.
    * @param            x - int value. 
    * @param            y - int value.
    * @preconditions    none.
    * @postconditions   A new Circle object is created with the x and
    *                   y coordinates initialized to specified values. 
    */  
    public Circle ( int x, int y ) throws PizzaException
    {
        super ( x, y );
        setRadius (0.0);
    }  
    
    /**
    * Method :          Constructor
    * Purpose :         Constructor for the Circle class takes 
    *                   x and y coordinates and radius as parameters
    *                   calls the parent Shape class constructor.
    *                   to initialize.
    * @param            x - int value. 
    * @param            y - int value.
    * @param            radius - double value.
    * @preconditions    none.
    * @postconditions   A new Circle object is created with the x and
    *                   y coordinates initialized to specified values. 
    */  
    public Circle ( int x, int y, double radius ) throws PizzaException
    {
        super ( x, y );
        setRadius (radius);
    }  
    
    /**
    * Method :          Copy Constructor
    * Purpose :         Creates a copy of the specified Circle object  
    *                   by calling the super constructor for setting
    *                   instance variables of super class and calls
    *                   setRadius method to set the radius.
    * 
    * @param            other - Circle object to compare
    * @preconditions    Circle object cannot be null.         
    *          
    * @postconditions   A copy of Circle object is created and set 
    *                   to this object with radius set to the
    *                   specified  Circle object.               
    */
    public Circle ( Circle other ) 
    {
        super(other.getX(), other.getY());
        if ( other == null )
            throw new NullPointerException("Null value passed");
        try
        {
            setRadius ( other.getRadius() );   
        } catch (PizzaException pe)
        {
            System.out.println( pe.getMessage() );
        }
    }
    
    /**
    * Method  :         setRadius
    * Purpose :         Mutator method for setting this object with 
    *                   specified radius in double. 
    *
    * @param            radius - double value
    * @preconditions    Valid double value - Cannot be negative.
    * @postconditions   The radius is set to specified valid values.
    * @throws           PizzaException when invalid data specified for
    *                   radius. 
    */
    public void setRadius ( double radius ) throws PizzaException
    {
        if ( radius < 0 )
            throw new PizzaException (" Cannot set negative value for radius");
        
        this.radius = radius;
    }
    
    /**
    * Method :          getRadius
    * Purpose :         Accessor method to return the radius value 
    *                   represented by this object.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          double value representing the radius of this
    *                   object.
    *            
    */ 
    public double getRadius()
    {
        return this.radius;
    }
    
    /** Overriding methods from parent Shape class **/

    /** 
    * Method :          getArea
    * Purpose :         Overriden Accessor method to return the area 
    *                   of this Circle object. Area is calculated using
    *                   the formula: pi* radius^2
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          double value representing the area of this
    *                   Circle object.
    *            
    */
    @Override
    public double getArea ()
    {
        double area = Math.PI * ( this.radius * this.radius );
        return area;
    }
    
    /**
    * Method  :         draw
    * Purpose :         Overridden method of Shape superclass which 
    *                   calls the Graphics2D class methods to set the
    *                   color of the Circle and draw a Circle filled 
    *                   with that onto the Jpanel which calls it.
    *                       
    * @param            g - Graphics object of Jpanel.
    * @preconditions    None
    * @postconditions   The Circle shape is rendered to Jpanel.
    *  
    */
    @Override
    public void draw ( Graphics g )
    {
    
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor( Color.GREEN );
 
        g2D.setPaint( new GradientPaint( super.getX(), super.getY(), 
                    Color.BLACK, super.getX()+ (int)this.getRadius()/4,
                    super.getY()+ (int)this.getRadius()/4, Color.GREEN, true));
        
    
        for( int i = 0; i < 30; i++) {
             int  xOffset = (int) (Math.random()*50)  ;
             int  yOffset = (int) (Math.random()*50)  ;
             g2D.fill (new Ellipse2D.Double ( super.getX() + 800 + xOffset,
                      super.getY()+yOffset, 1.25 * this.getRadius(),
                      1.50 * this.getRadius() ));
        }
     }
     
    /**
    * Method :          clone
    * Purpose :         Overridden clone method to create
    *                   a copy of this Circle object
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   Creates a deep copy of this object to
    *                   a new Circle object .  
    * @returns          Object - Newly created Circle Object                      
    *            
    */
   
    @Override
    public Object clone() 
    {
      return new Circle(this);
    }  
    
     /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object.  
    *                   
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   .                          
    *            
    */
    public String toString()
    {
        return "Circular";
    }
}
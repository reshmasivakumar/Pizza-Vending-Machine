package shapes;

import java.awt.*;
/**
 * Shape.java - Class respresenting the Super class in the Shape Heirarchy.
 * 
 * @author Reshma Sivakumar
 * @version 2 3/14/2016
 * 
 * Description: This class represents the parent class Shape.
 *              The getArea () and draw () methods of Shape class are
 *              abstract and will be overriden by subclass with functionality
 *              specific to subclass.
 *              
 */
 

public abstract class Shape extends Object implements Cloneable{
    
    /** super class instance variables **/
    private int x = 0;
    private int y = 0;
    
    /**
    * Method :          Constructor
    * Purpose :         Constructor for the Shape class and sets the x and 
    *                   y coordinates to the specified values.
    *                   to initialize.
    * @param            a - int value representing x. 
    * @param            b - int value representing y.
    * @preconditions    None.
    * @postconditions   None. 
    */      
    public Shape( int a, int b ) {
        x=a;
        y=b;
    }
    
    /**
    * Method :          getArea
    * Purpose :         Abstract method for returning the area of the shape.
    * @param            None.
    * @returns          -1.
    * @preconditions    None.
    * @postconditions   None. 
    */          
    public double getArea(){ return -1; }

    /**
    * Method :          draw
    * Purpose :         Abstract method for rendering the shape to Graphics context
    * @param            g- Graphics object.
    * @returns          None.
    * @preconditions    None.
    * @postconditions   None. 
    */  
    public void draw( Graphics g ){}
    
    /**
    * Method :          getX
    * Purpose :         Accesor method for to return x value of this object
    * @param            None.
    * @returns          int value representing x.
    * @preconditions    None.
    * @postconditions   None. 
    */      
    public int getX() { return x; }
    
    /**
    * Method :          getY
    * Purpose :         Accesor method for to return y value of this object
    * @param            None.
    * @returns          int value representing x.
    * @preconditions    None.
    * @postconditions   None. 
    */      
    public int getY() { return y; }
    
    /**
    * Method :          clone
    * Purpose :         Overridden clone abstract method
    *                   to create a copy of this Shape
    *                   class child object
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   Creates a deep copy of this object's subclass
    * @returns          Object - Newly created Shape sub-class Object                      
    *            
    */
   
    @Override
    public abstract Object clone();
}
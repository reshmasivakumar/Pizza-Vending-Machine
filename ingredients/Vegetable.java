package ingredients;
import mainClasses.PizzaException;
import mainClasses.Money;

import java.awt.Color;
/**
 * Vegetable.java - Class respresenting Vegetable object.
 * 
 * @author Reshma Sivakumar
 * @version 1.0 03/14/2016
 * 
 * Description: This class is inherited from it's parent class 
 *              Ingredient. This class represents a Vegetable
 *              object. It inherits the super class variables:
 *              description, cost and calories. Along with this,
 *              the Vegetable class also contains the color
 *              instance variable which stores the color of 
 *              the vegetable.
 */
public class Vegetable extends Ingredient
{
    private Color color;
    
    /**
    * Method :          Constructor
    * Purpose :         Constructs a Vegetable object which calls
    *                   the super class constructor.    
    * @param            description - String value to store description
    *                   of Vegetable.
    * @param            cost - Money value to store cost of Vegetable
    * @param            calories - int value to store calories of Vegetable
    *                   per serving.             
    * @preconditions    none.              
    * @postconditions   A new Vegetable object is created
    */ 
   public Vegetable ( String description, Money cost, int calories) throws PizzaException
   {
       super(description, cost, calories);
   }
   
   /**
    * Method :          Constructor
    * Purpose :         Constructs a Vegetable object which calls
    *                   the super class constructor.    
    * @param            description - String value to store description
    *                   of Vegetable.
    * @param            cost - Money value to store cost of Vegetable
    * @param            calories - int value to store calories of Vegetable
    *                   per serving.    
    * @param            color - Color value to store the color for the
    *                   vegetable.
    * @preconditions    none.              
    * @postconditions   A new Vegetable object is created
    */ 
   public Vegetable (String description, Money cost, int calories, Color color) throws PizzaException
   {
       super(description, cost, calories);
       this.color = color;
   }
   
   /**
    * Method :          setColor
    * Purpose :         Mutator method for setting color value in this
    *                   Vegetable object.  
    *            
    * 
    * @param            color - Color value to represent thr color of
    *                   this Vegetable object.
    * @preconditions    Specified color value should not be null
    *                   and should be of type Color.
    * @postconditions   The color value of this object will be set to 
    *                   the specified value.                   
    * @returns          None.                          
    * 
    * @throws           NullPointerException when specified color 
    *                   value is null
    * @throws           ClassCastException when specified color
    *                   is not of type Color.    
    */
   public void setColor ( Color color )
   {
       if ( color == null )
            throw new NullPointerException
                        ("Object passed is null");
       
       if (! ( color instanceof Color) )
            throw new ClassCastException
                      ("Object is not of type Color");
                      
       Color temp = color;     
       this.color = temp;
   }
   
   /**
    * Method :          getColor
    * Purpose :         Accessor method for getting the color 
    *                   represented by this Vegetable object.  
    *            
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          Color value of this Vegetable object
    */
   public Color getColor ()
   {
       Color temp = this.color;
       return temp;
   }
   
   /**
    * Method :          equals
    * Purpose :         Compares this object with the specified object to see  
    *                   if they are equal. 
    * 
    * @param            Object -  Object of type Vegetable
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          boolean - true if equals, false otherwise.                         
    *            
    */
   @Override
   public boolean equals ( Object other )
   {
       if ( other == null )
           return false;
       
       if (! ( other instanceof Vegetable) )
             return false; 
       
       Vegetable temp = (Vegetable) other;
       if ( this.color == temp.color && super.equals (temp) )
            return true;
       else
            return false;
    }
   
   /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing the description, cost, calories
    *                   and color for this Vegetable object 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Vegetable object .                                     
    */
   public String toString ()
   {
       String retVal = "Ingredient Vegetable: "; 
       return retVal += super.toString() + " "+this.color;
   } 
}

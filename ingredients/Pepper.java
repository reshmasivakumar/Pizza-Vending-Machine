package ingredients;
import mainClasses.PizzaException;
import mainClasses.Money;

import java.awt.Color;
/**
 * Pepper.java - Class respresenting Pepper object.
 * 
 * @author Reshma Sivakumar
 * @version 1.0 03/14/2016
 * 
 * Description: This class is inherited from it's parent class 
 *              Vegetable. This class represents a Pepper
 *              object. It inherits the super class variables:
 *              description, cost, calories and color. 
 */
public class Pepper extends Vegetable
{
   /**
    * Method :          Constructor
    * Purpose :         Constructs a Pepper object which calls
    *                   the Vegetable super class constructor with 
    *                   description, cost and calorie for Pepper.
    * @param            none.
    * @preconditions    none.              
    * @postconditions   A new Pepper object is created
    */ 
   public Pepper () throws PizzaException
   {
       super("Pepper: ", new Money (3,50), 70, Color.RED);
   }
   
    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing the description, cost, calories
    *                   and color for this Pepper object 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Pepper object .                                     
    */
   public String toString ()
   {
       String retVal = "Ingredient Pepper: "; 
       return retVal += super.toString(); 
   } 
}

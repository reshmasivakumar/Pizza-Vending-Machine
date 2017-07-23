package ingredients;
import mainClasses.PizzaException;
import mainClasses.Money;

import java.awt.Color;
/**
 * Alfredo.java - Class respresenting Alfredo object.
 * 
 * @author Reshma Sivakumar
 * @version 1.0 03/14/2016
 * 
 * Description: This class is inherited from it's parent class 
 *              Base. This class represents a Alfredo
 *              object. It inherits the super class variables:
 *              description, cost and calories.
 */
public class Alfredo extends Base
{
   /**
    * Method :          Constructor
    * Purpose :         Constructs a Alfredo object which calls
    *                   the Base super class constructor with 
    *                   description, cost and calorie for Alfredo.
    * @param            none.
    * @preconditions    none.              
    * @postconditions   A new Alfredo object is created
    */ 
   public Alfredo ( ) throws PizzaException
   {
       super("Alfredo: ", new Money ( 1, 50 ), 200);
   }
   
    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Alfredo object 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Alfredo object .                                     
    */
   public String toString ()
   {
       String retVal = "Ingredient Alfredo: "; 
       return retVal += super.toString(); 
   } 
}

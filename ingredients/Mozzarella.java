package ingredients;

import mainClasses.PizzaException;
import mainClasses.Money;
/**
 * Mozzarella.java - Class respresenting Mozzarella object.
 * 
 * @author Reshma Sivakumar
 * @version 1.0 03/14/2016
 * 
 * Description: This class is inherited from it's parent class 
 *              Cheese. This class represents a Mozzarella
 *              object. It inherits the super class variables:
 *              description, cost and calories.
 */
public class Mozzarella extends Cheese
{
   /**
    * Method :          Constructor
    * Purpose :         Constructs a Mozzarella object which calls
    *                   the Cheese super class constructor with 
    *                   description, cost and calorie for Mozzarella.
    * @param            none.
    * @preconditions    none.              
    * @postconditions   A new Mozzarella object is created
    */ 
   public Mozzarella () throws PizzaException
   {
       super("Mozzarella: ", new Money(1,50), 200);
   }
   
    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Mozzarella object 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Mozzarella object .                                     
    */
   public String toString ()
   {
       String retVal = "Ingredient Mozzarella: "; 
       return retVal += super.toString(); 
   } 
}

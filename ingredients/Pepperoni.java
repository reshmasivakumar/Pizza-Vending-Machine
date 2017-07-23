package ingredients;
import mainClasses.PizzaException;
import mainClasses.Money;

import java.awt.Color;
/**
 * Pepperoni.java - Class respresenting Pepperoni object.
 * 
 * @author Reshma Sivakumar
 * @version 1.0 03/14/2016
 * 
 * Description: This class is inherited from it's parent class 
 *              Meat. This class represents a Pepperoni
 *              object. It inherits the super class variables:
 *              description, cost and calories.
 */
public class Pepperoni extends Meat
{
   /**
    * Method :          Constructor
    * Purpose :         Constructs a Pepperoni object which calls
    *                   the Meat super class constructor  with 
    *                   description, cost and calorie for Pepperoni.
    * @param            none.
    * @preconditions    none.              
    * @postconditions   A new Pepperoni object is created
    */ 
   public Pepperoni () throws PizzaException
   {
       super("Pepperoni: ", new Money(2,50), 400);
   }
   
    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Pepperoni object 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Pepperoni object .                                     
    */
   public String toString ()
   {
       String retVal = "Ingredient Pepperoni: "; 
       return retVal += super.toString(); 
   } 
}

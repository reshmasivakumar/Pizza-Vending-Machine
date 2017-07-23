package ingredients;
import mainClasses.PizzaException;
import mainClasses.Money;

import java.awt.Color;
/**
 * Sausage.java - Class respresenting Sausage object.
 * 
 * @author Reshma Sivakumar
 * @version 1.0 03/14/2016
 * 
 * Description: This class is inherited from it's parent class 
 *              Meat. This class represents a Sausage
 *              object. It inherits the super class variables:
 *              description, cost and calories.
 */
public class Sausage extends Meat
{
   /**
    * Method :          Constructor
    * Purpose :         Constructs a Sausage object which calls
    *                   the Meat super class constructor with 
    *                   description, cost and calorie for Sausage.
    * @param            none.
    * @preconditions    none.              
    * @postconditions   A new Sausage object is created
    */ 
   public Sausage () throws PizzaException
   {
       super("Sausage: ", new Money(3,50), 320);
   }
   
    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Sausage object 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Sausage object .                                     
    */
   public String toString ()
   {
       String retVal = "Ingredient Sausage: "; 
       return retVal += super.toString(); 
   } 
}

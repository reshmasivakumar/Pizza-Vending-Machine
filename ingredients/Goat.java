package ingredients;
import mainClasses.PizzaException;
import mainClasses.Money;
import java.awt.Color;
/**
 * Goat.java - Class respresenting Goat object.
 * 
 * @author Reshma Sivakumar
 * @version 1.0 03/14/2016
 * 
 * Description: This class is inherited from it's parent class 
 *              Cheese. This class represents a Goat
 *              object. It inherits the super class variables:
 *              description, cost and calories.
 */
public class Goat extends Cheese 
{
   /**
    * Method :          Constructor
    * Purpose :         Constructs a Goat object which calls
    *                   the Cheese super class constructor with 
    *                   description, cost and calorie for Goat.
    * @param            none.
    * @preconditions    none.              
    * @postconditions   A new Goat object is created
    */ 
   public Goat () throws PizzaException
   {
       super("Goat: ", new Money (2,0), 120);
   }
   
    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Goat object 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Goat object .                                     
    */
   public String toString ()
   {
       String retVal = "Ingredient Goat: "; 
       return retVal += super.toString(); 
   } 
}

package ingredients;
import mainClasses.PizzaException;
import mainClasses.Money;
import java.awt.Color;
/**
 * Marinara.java - Class respresenting Marinara object.
 * 
 * @author Reshma Sivakumar
 * @version 1.0 03/14/2016
 * 
 * Description: This class is inherited from it's parent class 
 *              Base. This class represents a Marinara
 *              object. It inherits the super class variables:
 *              description, cost and calories.
 */
public class Marinara extends Base
{
   /**
    * Method :          Constructor
    * Purpose :         Constructs a Marinara object which calls
    *                   the Base super class constructor with 
    *                   description, cost and calorie for Marinara.    
    * @param            none.
    * @preconditions    none.              
    * @postconditions   A new Marinara object is created
    */ 
   public Marinara () throws PizzaException
   {
       super("Marinara", new Money (1, 75), 250);
   }
   
    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Marinara object 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Marinara object .                                     
    */
   public String toString ()
   {
       String retVal = "Ingredient Marinara: "; 
       return retVal += super.toString(); 
   } 
}

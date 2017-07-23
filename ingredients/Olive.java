package ingredients;
import mainClasses.PizzaException;
import mainClasses.Money;
import java.awt.Color;
/**
 * Olive.java - Class respresenting Olive object.
 * 
 * @author Reshma Sivakumar
 * @version 1.0 03/14/2016
 * 
 * Description: This class is inherited from it's parent class 
 *              Vegetable. This class represents a Olive
 *              object. It inherits the super class variables:
 *              description, cost, calories and color. 
 */
public class Olive extends Vegetable
{
   /**
    * Method :          Constructor
    * Purpose :         Constructs a Olive object which calls
    *                   the Vegetable super class constructor with 
    *                   description, cost and calorie for Olive.
    * @param            none.
    * @preconditions    none.              
    * @postconditions   A new Olive object is created
    */ 
   public Olive () throws PizzaException
   {
       super("Olive: ", new Money(2,50), 50, Color.GREEN);
   }
   
    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing the description, cost, calories
    *                   and color for this Olive object 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Olive object .                                     
    */
   public String toString ()
   {
       String retVal = "Ingredient Olive: "; 
       return retVal += super.toString(); 
   } 
}

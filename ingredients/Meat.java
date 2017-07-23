package ingredients;

import mainClasses.PizzaException;
import mainClasses.Money;

/**
 * Meat.java - Class respresenting Meat object.
 * 
 * @author Reshma Sivakumar
 * @version 1.0 03/14/2016
 * 
 * Description: This class is inherited from it's parent class 
 *              Ingredient. This class contains a constructor
 *              which calls the super class constructor to 
 *              set the values for description, cost and
 *              calories per serving. The toString() method
 *              returns the String representation of the
 *              Meat object.              
 */

public class Meat extends Ingredient 
{
    /**
    * Method :          Constructor
    * Purpose :         Constructs a Meat object which calls
    *                   the super class constructor.    
    * @param            description - String value to store description
    *                   of Meat.
    * @param            cost - Money value to store cost of Meat
    * @param            calories - int value to store calories of Meat
    *                   per serving.             
    * @preconditions    none.              
    * @postconditions   A new Meat object is created
    */ 
   public Meat ( String description, Money cost, int calories) throws PizzaException
   {
       super(description, cost, calories);
   }
   
    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Meat object 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Meat object .                                     
    */
   public String toString ()
   {
       String retVal = "Ingredient Meat: "; 
       return retVal += super.toString();
   }
}

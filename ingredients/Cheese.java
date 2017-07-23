package ingredients;
import mainClasses.PizzaException;
import mainClasses.Money;

/**
 * Cheese.java - Class respresenting Cheese object.
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
 *              cheese object.              
 */

public class Cheese extends Ingredient 
{
    /**
    * Method :          Constructor
    * Purpose :         Constructs a Cheese object which calls
    *                   the super class constructor.    
    * @param            description - String value to store description
    *                   of cheese.
    * @param            cost - Money value to store cost of cheese
    * @param            calories - int value to store calories of cheese
    *                   per serving.             
    * @preconditions    none.              
    * @postconditions   A new Cheese object is created
    */ 
   public Cheese ( String description, Money cost, int calories) throws PizzaException
   {
       super(description, cost, calories);
   }
   
    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Cheese object 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Cheese object .                                     
    */
   public String toString ()
   {
       String retVal = "Ingredient Cheese: "; 
       return retVal += super.toString();
   }
}


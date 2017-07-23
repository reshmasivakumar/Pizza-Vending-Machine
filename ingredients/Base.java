package ingredients;
import mainClasses.PizzaException;
import mainClasses.Money;

/**
 * Base.java - Class respresenting Base object.
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
 *              Base object.              
 */

public class Base extends Ingredient 
{
    /**
    * Method :          Constructor
    * Purpose :         Constructs a Base object which calls
    *                   the super class constructor.    
    * @param            description - String value to store description
    *                   of Base.
    * @param            cost - Money value to store cost of Base
    * @param            calories - int value to store calories of Base
    *                   per serving.             
    * @preconditions    none.              
    * @postconditions   A new Base object is created
    */ 
   public Base ( String description, Money cost, int calories) throws PizzaException
   {
       super(description, cost, calories);
   }
   
    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Base object 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing the description, cost and calories
    *                   for this Base object .                                     
    */
   public String toString ()
   {
       String retVal = "Ingredient Base: "; 
       return retVal += super.toString();
   }
}

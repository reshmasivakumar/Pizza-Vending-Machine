package ingredients;

import mainClasses.Money;
import mainClasses.PizzaException;

/**
 *
 * Ingredient.java - Class respresenting Ingredient object.
 * 
 * @author Reshma Sivakumar
 * @version 1.0 3/14/2016
 * 
 * Description: This is the parent class for all the ingredients
 *              that make up the Pizza object. This class 
 *              implements Comparable interface.
 *              
 */

public abstract class Ingredient implements Comparable
{
    
    /**   Instance Variables **/
    private String description;
    private Money cost;
    private int calories;
    
    /**
    * Method :          Constructor
    * Purpose :         Super Constructor to create a new
    *                   an Ingredient object.
    *                    
    * @param            desc - String value to store description
    *                   of Ingredient.
    * @param            cost - Money value to store cost of Ingredient
    * @param            calories - int value to store calories of Ingredient
    *                   per serving.             
    * @preconditions    none.              
    * @postconditions   none.
    * @throws           PizzaException - When desc and cost is null
    *                                   - calories <=0
    */ 
    
    public Ingredient(String desc, Money cost, int calories) throws PizzaException
    {

        if ( desc == null || desc.length() <= 0 || cost == null || calories <= 0)
            throw new PizzaException("Invalid ingredients input");
            
        this.description = desc;
        this.cost = (Money) cost.clone();
        this.calories = calories;
    }

    
    
    /**
    * Method :          compareTo
    * Purpose :         Compares the cost of specified Ingredient
    *                   object with this object. 
    *                   
    * @param            that - Object of Ingredient class to 
    *                   be compared.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          integer - a negative integer, zero, 
    *                   or a positive integer if the cost of this 
    *                   object is less than, equal to, or greater
    *                   than the specified object.                          
    */
    @Override
    public int compareTo(Object that) {
        int retVal = -1;
        try
        {
            // compare ingredients by cost only.
            if ( that == null )
                throw new   PizzaException ("Object passed is null");
                
            if (!(that instanceof Ingredient))
                throw new PizzaException ("Object is not of type Ingredient");
                
            Ingredient other = (Ingredient) that;
            // call money's compareTo method
            retVal = (this.cost).compareTo(other.cost);
        }catch (PizzaException pe)
        {
            System.out.println(pe.getMessage());
        }
        
        return retVal;
    }
    
     /**
    * Method :          equals
    * Purpose :         Compares this object with the specified object to see  
    *                   if they are equal. 
    * 
    * @param            object   -  Ingredient class object
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          boolean - true if equals, false otherwise.                         
    *            
    */
      @Override
    public boolean equals ( Object object )
    {
        if ( object == null )
           return false;
       
        if (! ( object instanceof Ingredient) )
           return false;
                    
        Ingredient other = (Ingredient) object;
        boolean retVal = false;
        
        try
        {
            retVal = ( this.description.equals
                 (other.description) &&
                 this.cost.equals(other.cost) &&
                 this.calories == other.calories );
        }catch (PizzaException pe)
        {
            System.out.println (pe.getMessage());
        }
        return retVal;
    }

    /**
    * Method :          getCalories
    * Purpose :         Returns the calories of the ingredient subclass
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          int value representing the calories of the ingredient   
    *                   subclass
    *            
    */
    public int getCalories ()
    {
        return this.calories;
    }

    /**
    * Method :          getCost
    * Purpose :         Returns the cost of the ingredient subclass
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          int value representing the cost of the ingredient subclass                     
    *            
    */
    public Money getCost ()
    {
        return (Money) this.cost.clone();
    }
     
    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing the description, cost and calories
    *                   per serving.
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing the description, cost and calories
    *                   per serving.                          
    *            
    */
    public String toString()
    {
        return this.description +": Costs $" + this.cost +
                "calories per serving: " + this.calories;
        
    }
}



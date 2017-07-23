package mainClasses;
import java.text.DecimalFormat;

import shapes.Circle;
import shapes.Shape;
import shapes.Square;
import timeStamp.Date;
import timeStamp.TimeStamp;
import ingredients.*;

 /**
 * Pizza.java - Class representing Pizza object
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 3/13/2016
 *
 * Description:  This class represents a Pizza object which contains a list of ingredients, a shape (Circular or Square), cost and calories. 
 *               The cost of the Pizza will be the sum of the cost of all ingredients and the calories will be the sum of the cost of all
 *               the calories in the ingredients. Pizza can be eaten maintains the remaining fraction of the Pizza object. When a Pizza is made
 *               this fraction will be 1/1. When this Pizza is completely eaten they will be removed from the PizzaManager's list. 
 *              
 *               The Pizza class implements PizzaComparable interface and provides implementation to compare Pizzas by cost, calories
 *               and size. These methods will be used in the PizzaManager class to sort the Pizza list by cost, calories and size.
 *                           
 *              
 * Class Invariants:  - The pizza to be eaten should be specified in proper fraction.
 *                    - When a Pizza is made, it starts with 100% of it’s area left (so a Fraction of 1/1)
 *                    - A Pizza’s remaining ratio must be between (0,1] excluding 0 and including 1.
 *                    - When a Pizza’s fraction remaining reaches 0  an  exception is thrown and that is caught by the  
 *                      PizzaManager which will remove this Pizza object from the PizzaManager list.
 *                    - A Pizza’s price is the sum of its ingredients’ costs.
 *                    - A Pizza’s calorie count is the sum of its ingredients’ calories and represents the caloric consumption per 
 *                      serving and remains static.
 *                   - Adding ingredients will add the price of a Pizza.
 *                   - Reducing the remaining Fraction of pizza left will reduce the price of the Pizza accordingly
 *               
 */


public class Pizza implements PizzaComparable
{
    private Date made;
    private Money cost;
    private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
    private Shape myShape;
    private int calorieCount;
    private Fraction remaining;

    /**
    * Method :          Default Contructor
    * Purpose :         Default constructor creates a new Pizza object with random shape (Circle or Square)and list of 
    *                   ingredients.
    *   
    * @param            None.
    * @preconditions    None. 
    * @postconditions   creates a new Pizza object with random shape (Circle or Square)and list of ingredients.
    *                    
    * @returns          None.                          
    * 
    */    
    public Pizza() throws PizzaException{ 
         
         
        made = new TimeStamp( MyPizzaManager.getCurrDate(), MyPizzaManager.getCurrTime() );
        this.cost = new Money (0,0);
        this.ingredientList = new ArrayList<Ingredient>();
        this.remaining = new Fraction (1,1);
  
        Circle circle = new Circle ((int)(Math.random() * 100), 
                                    (int)(Math.random() * 100),  
                                    (int)(Math.random() * 100));

        Square square = new Square ((int)(Math.random() * 100),
                                     (int)(Math.random() * 110), 
                                     (int)(Math.random() * 100));     

        switch( ( int )(Math.random() * 7) ) {
               case 0:      
                            addIngredient ( new Marinara ());
                            addIngredient ( new Goat ());
                            addIngredient ( new Pepper ());
                            addIngredient ( new Pepperoni ());
                            this.myShape = circle;
                            break;
               case 1:    
                            addIngredient ( new Alfredo ());
                            addIngredient ( new Goat ());
                            addIngredient ( new Pepper ());
                            addIngredient ( new Pepperoni ());
                            this.myShape = circle;
                            break;  
               case 2:     
                            addIngredient ( new Marinara ());
                            addIngredient ( new Mozzarella ());
                            addIngredient ( new Pepper ());
                            addIngredient ( new Pepperoni ());
                            this.myShape = square;
                            break;
                               
               case 3:     
                            addIngredient ( new Marinara ());
                            addIngredient ( new Mozzarella ());
                            addIngredient ( new Olive ());
                            addIngredient ( new Pepperoni ());
                            this.myShape = circle;
                            break;
               case 4:     
                            addIngredient ( new Marinara ());
                            addIngredient ( new Mozzarella ());
                            addIngredient ( new Olive ());
                            addIngredient ( new Sausage ());
                            this.myShape = square;
                            break;
               case 5:     
                            addIngredient ( new Alfredo ());
                            addIngredient ( new Mozzarella ());
                            addIngredient ( new Pepper ());
                            addIngredient ( new Pepperoni ());
                            this.myShape = circle;
                            break;
                               
               case 6:     
                            addIngredient ( new Alfredo ());
                            addIngredient ( new Mozzarella ());
                            addIngredient ( new Olive ());
                            addIngredient ( new Pepperoni ());
                            this.myShape = square;
                            break;
               case 7:     
                            addIngredient ( new Alfredo ());
                            addIngredient ( new Mozzarella ());
                            addIngredient ( new Olive ());
                            addIngredient ( new Sausage ());
                            this.myShape = circle;
                            break;
        }
    }

    /**
    * Method :          getMadeDate
    * Purpose :         This method will be return the date the pizza is made(current date)
    * 
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          Date object that represents the date the pizza is made (current date).                          
    * 
    * @throws           PizzaException from Date class
    */
 
    public Date getMadeDate() throws PizzaException{ 
        return new Date(made); 
    }
    
    /**
    * Method :          setRemaining
    * Purpose :         This method will be called when a Pizza fraction is eaten to set the remaining fraction of the Pizza. 
    *                   The input fraction specified will be subtracted from the remaining Pizza fraction. The cost of the Pizza
    *                   will be adjusted accordingly.
    * 
    * @param            f - Fraction to be subtracted from remaining fraction of this Pizza object.
    * @preconditions    None. 
    * @postconditions   The input fraction specified will be subtracted from the remaining Pizza fraction. The cost of the Pizza
    *                   will be adjusted accordingly.
    *                    
    * @returns          None.                          
    * 
    * @throws           PizzaException - when remaining Pizza fraction becomes negative.
    *                                   - when Pizza fractions becomes 0.
    *                                   - when  null fraction is passed.
    */
    public void setRemaining ( Fraction f ) throws PizzaException
    {
        if (f == null)
            throw new PizzaException
                    ("Fraction passed is null");
            
        if (! ( f instanceof Fraction ) ) 
            throw new PizzaException
                    ("Fraction passed is not of type Fraction");
        
        double fractionVal = 0.0;
        
        fractionVal = (double)((double)remaining.getNumerator() /(double)remaining.getDenominator());
         
        if ( fractionVal < 0 )
            throw new PizzaException
                        ("Only " + remaining.toString() + "left! Cannot satisfy requested " + f.toString());
                        
        if ( fractionVal == 0 )
            throw new PizzaException
                        ("No Pizza Left!");   
                        
        // Set the new cost of Pizza remaining
        //Calculate cost for current pizza  
        double currentCost = cost.getMoney() / fractionVal;    
        //check if requested fraction to eat is greater than the remaining amount
        if ( (this.remaining.compareTo(f)) < 0)
          throw new PizzaException("Only " + remaining.getNumerator() +"/" + remaining.getDenominator() + " left! Cannot satisfy requested " + f.toString());
        this.remaining = this.remaining.subtract(f);      
        if ( (this.remaining.getNumerator()) == 0)
            throw new PizzaException ("Pizza is eaten completely and is removed from list ");             
          //Calculate cost after subtracting
        fractionVal = (double)((double)remaining.getNumerator() / (double)remaining.getDenominator());
        double newCost = currentCost * fractionVal;
           // System.out.println("new"+newCost);
        String costStr = Double.toString ( newCost );
        //System.out.println("After"+costStr);
        String[] costArr = costStr.split("\\.");
        int dollars = Integer.parseInt(costArr[0]);
        int cents = Integer.parseInt(costArr[1].substring(0,1));
        this.cost = new Money ( dollars, cents );
    }
    
    /**
    * Method :          getRemaining
    * Purpose :         This method will be called to return the current value representing the remaining Pizza fraction.
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          Fraction value - representing the remaining Pizza fraction.                          
    * 
    * @throws           None.
    */              
    
    public Fraction getRemaining ()
    {
        return new Fraction ( this.remaining);
    }
    
    /**
    * Method :          getCalories
    * Purpose :         This method will be called to return the current value representing the total calories in the Pizza,
    *                   which is the sum of all the calories in the ingredients of this Pizza object.
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          integer value - representing the  sum of all the calories in the ingredients of this Pizza object.
    * @throws           None.
    */      
     
    public int getCalories ()
    {
        return this.calorieCount;
    }
    
      /**
    * Method :          getCost
    * Purpose :         This method will be called to return the current value representing the total cost in the Pizza,
    *                   which is the sum of all the cost in the ingredients of this Pizza object.
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          Money object - representing the  sum of all the cost of the ingredients of this Pizza object.
    * @throws           None.
    */  
    
    public Money getCost ()
    {
        return (Money) (this.cost).clone();
    }
    
     /**
    * Method :          getRemainingArea
    * Purpose :         This method will be called to return the current value representing the area of the of the remaining
    *                   fraction depending on the shape of this Pizza object.
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          double value - representing remaining fraction depending on the shape of this Pizza object.
    * @throws           None.
    */      
    public double getRemainingArea ()
    {
        double area = this.myShape.getArea();
        
        // return the area of the remaining Pizza(Fraction). 
        return (area * ((double)this.remaining.getNumerator() /
                        (double)this.remaining.getDenominator()));
    }
    
    /**
    * Method :          setShape
    * Purpose :         This method will be called to set the shape value for this Pizza object to specified value.
    *                   The shape can be Circle or Square.
    * @param            s- Shape object representing the shape of this Pizza object.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          None.
    * @throws           None.
    */     
    public void setShape (Shape s) 
    {
        if ( s == null)
            throw new RuntimeException ("Shape cannot be null");
            
        this.myShape = (Shape) s.clone();
    }
    
    /**
    * Method :          getShape
    * Purpose :         This method will be called to get the shape value for this Pizza object.
    *                   The shape can be Circle or Square.
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          Shape object representing the shape of this Pizza object..
    * @throws           None.
    */      
    public Shape getShape ()
    {
        return (Shape) this.myShape.clone();
    }
    
     /**
    * Method :          addIngredient
    * Purpose :         This method will be called to add specified ingredient to this Pizza object. The cost of
    *                   ingredient will be added to the current cost of the  Pizza. The calories of the ingredient 
    *                   will be added to the current calories of the Pizza.
    *                    
    * @param            a- Ingredient object to be added to his Pizza.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          None.
    * @throws           PizzaException - when specified input is null.
    */      
    public void addIngredient ( Ingredient a ) 
                                throws PizzaException
    {
        this.ingredientList.add ( a );
        this.calorieCount += a.getCalories();
        this.cost.add(a.getCost().getDollars(), a.getCost().getCents());
    }
    
    /**
    * Method :          eatSomePizza
    * Purpose :         This method will be called by the MyPizzaManager when user selects eat pizza option. The specified
    *                   input represents the amount requested to be eaten. The input specified will be subtracted from the 
    *                   remaining fraction of this object and the cost and calories will be scaled to the remaining
    *                   fraction. 
    *                   When all the Pizza is eaten, the cost and calories of the this object will be set to 0 and an 
    *                   exception will be thrown. The PizzaManager will catch this exception and remove this object from 
    *                   the Pizza list.
    *
    * @param            amt- Fraction object to be eaten from this Pizza.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          None.
    * @throws           PizzaException - when input specified is null.
    *                                  - input not of type Fraction
    *                                  - remaining fraction becomes 0 indicating the Pizza is eaten fully.
    *                                  - remaining fraction is negative
    *                               
    */      
    
    public void eatSomePizza ( Fraction amt ) throws PizzaException
    {
        if (amt == null)
            throw new PizzaException
                    ("Fraction passed is null");
            
        setRemaining( amt );
    
        if ( this.remaining.getNumerator() == 0 )
        {
            this.cost = new Money ( 0, 0 );
            this.calorieCount = 0;
            throw new PizzaException
                ("Your request completed a Pizza in the list!");
        }
        
        if ( this.remaining.getNumerator() < 0 )
            throw new PizzaException
                    ("Error: Cannot eat an eaten Pizza!");
    }
    
     /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object showing cost, caloriecount, date made and the
    *                   remaining fraction
    *                       
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object for printing showing cost, caloriecount, date made and the 
    *                   remaining fraction  .                          
    *            
    */
    
    public String toString ()
    {
        String retVal = "";
        DecimalFormat df = new DecimalFormat ("0.00");
        String area = df.format(this.getRemainingArea());
  
        retVal= ("Pizza has a price: " + this.cost.toString() 
            + " and calories: "
            + this.calorieCount + ", Fraction remaining: "
            + this.remaining.toString() + " made on "+ this.made.toString()
            + " and area left: " 
            + area + " and Shape: " + this.myShape);
    
        return retVal;
    }

    /**
    * Method :          compareTo
    * Purpose :         Overriden method to compare by price of Pizza.
    *                   
    * @param            o - Pizza Object to be compared.
    *                   
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          integer - a negative integer, zero,or a positive integer as this object 
    *                   is less than, equal to, or greater than the specified object.                             
    *       
    */   

    @Override
    public int compareTo(Object o)  
    {
        try
        {
            //a.k.a compareToByPrice
            if ( o == null || ! (o instanceof Pizza ))
               throw new PizzaException ("Invalid input");
        } catch (PizzaException pe )
        {
           System.out.println(pe.getMessage()); 
        }
        Pizza other = (Pizza) o;
        return (this.cost.compareTo(other.cost));
    }

    /**
    * Method :          compareToBySize
    * Purpose :         Overriden method to compare by remaining area (size) of Pizza.
    *                   
    * @param            o - Pizza Object to be compared.  
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          integer - a negative integer, zero, or a positive integer as this object 
    *                   is less than, equal to, or greater than the specified object.                          
    *       
    */      
     @Override
    public int compareToBySize(Object o)
    {
        try
        {
            if ( o == null || ! (o instanceof Pizza ))
               throw new PizzaException ("Invalid input");
        } catch (PizzaException pe )
        {
           System.out.println(pe.getMessage()); 
        }
        Pizza other = (Pizza) o;
        double retVal = (this.getRemainingArea() - other.getRemainingArea());
        if ( retVal < 0 )
           return -1;
        else if (retVal == 0)
           return 0;
        else 
           return 1;
    }

    /**
    * Method :          compareToByCalories
    * Purpose :         Overriden method to compare by calories of Pizza.
    *                   
    * @param            o - Pizza Object to be compared.  
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          integer - a negative integer, zero, or a positive integer as this object 
    *                   is less than, equal to, or greater than the specified object.                          
    *       
    */    
    public int compareToByCalories(Object o) 
    { 
        try
        {
            if ( o == null || ! (o instanceof Pizza ))
               throw new PizzaException ("Invalid input");
        } catch (PizzaException pe )
        {
           System.out.println(pe.getMessage()); 
        }

        Pizza other = (Pizza) o;
        if (this.calorieCount < other.calorieCount )
           return -1;
        else if (this.calorieCount == other.calorieCount )
           return 0;
        else
           return 1;
    }

    /**
    * Method :          displayIngredients
    * Purpose :         Display ingredients of Pizza.
    *                   
    * @param            None.  
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          None.                          
    *       
    */    
    
    public void displayIngredients()
    {
        this.ingredientList.displayList();
    }
    
      /**
    * Method :          main
    * Purpose :         Test methods for testing the methods of this object.
    *   
    */
    public static void main ( String[] args )
    {
        Pizza firstPizza = null;
        Pizza secondPizza = null;
        Pizza thirdPizza = null;
        try
        {
            //Create a new Pizza - firstPizza
            System.out.println("First Pizza details");

            firstPizza = new Pizza ();
            System.out.println("firstPizza: "+firstPizza);
            System.out.println();
            firstPizza.displayIngredients();
            System.out.println();
            
            //Calling the eatSomePizza method
            System.out.println("Eat 1/4th of first pizza");
            firstPizza.eatSomePizza ( new Fraction (1, 4) );
            System.out.println(firstPizza); 
            System.out.println();

            System.out.println("Eat 3/4th of first pizza");
            firstPizza.eatSomePizza ( new Fraction (3, 4) );
            System.out.println(firstPizza);
            System.out.println();
            
            System.out.println("try to eat already eaten pizza");
            firstPizza.eatSomePizza ( new Fraction (3, 4) );
            System.out.println(firstPizza);
            System.out.println();

        }catch ( PizzaException pe )
        {
            System.out.println ( pe.getMessage());
            System.out.println();
        }
        
        try
        {
            //Create a new Pizza - secondPizza
            System.out.println("Second Pizza details");

            secondPizza = new Pizza ();
            System.out.println("secondPizza: "+secondPizza);
            System.out.println();
            secondPizza.displayIngredients();
            System.out.println();
            
            System.out.println("Adding Marinara to the second pizza");
            secondPizza.addIngredient ( new Marinara ());
            System.out.println(secondPizza);
            secondPizza.displayIngredients();
            System.out.println(); 
            
            System.out.println("Eat 1/4th of second pizza");
            //Calling the eatSomePizza method
            secondPizza.eatSomePizza ( new Fraction (1, 4) );
            System.out.println(secondPizza); 
            System.out.println();

            System.out.println("Call getShape()");
            System.out.println(secondPizza.getShape());
            System.out.println();
            
            Circle circle = new Circle ((int)(Math.random() * 100), 
                                        (int)(Math.random() * 100),  
                                        (int)(Math.random() * 100));
        
   
            
            System.out.println("Change shape to circle");
            secondPizza.setShape(circle);
            System.out.println();
            
            System.out.println("Call getShape() after changing shape");
            System.out.println(secondPizza.getShape());
            System.out.println(secondPizza);
            System.out.println();
            
            System.out.println("Call getCost()");
            System.out.println(secondPizza.getCost());
            System.out.println();
            
            System.out.println ("Comparing first and second pizza by cost");
            int c1 = firstPizza.compareTo(secondPizza);
            if ( c1 > 0 )
                  System.out.println("firstPizza is expensive than secondPizza");
            else if ( c1 == 0 )
                  System.out.println("Both pizzas cost the same");
            else
                  System.out.println("firstPizza is cheaper than secondPizza");
                  
                  
            System.out.println ("Comparing first and second pizza by calories");
            c1 = firstPizza.compareToByCalories(secondPizza);
            if ( c1 > 0 )
                  System.out.println("firstPizza has more calories than secondPizza");
            else if ( c1 == 0 )
                  System.out.println("Both pizzas have the same calories");
            else
                  System.out.println("firstPizza has less calories than secondPizza");
                   
            System.out.println ("Comparing first and second pizza by size");
            c1 = firstPizza.compareToBySize(secondPizza);
            if ( c1 > 0 )
                  System.out.println("firstPizza is larger than secondPizza");
            else if ( c1 == 0 )
                  System.out.println("Both pizzas are of the same size");
            else
                  System.out.println("firstPizza is smaller than secondPizza"); 
        }catch ( PizzaException pe )
        {
            System.out.println ( pe.getMessage());
        }
        
       
    
        //Create a new Pizza - thirdPizza
         try
        {
        System.out.println("Third Pizza details");
        thirdPizza = new Pizza ();
        System.out.println("thirdPizza: "+thirdPizza);
        System.out.println();
       
          System.out.println("Adding null to the third pizza");
          thirdPizza.addIngredient ( null);
        } catch (PizzaException pe1)
        {
            System.out.println(pe1.getMessage());
        }
           
      
    }
}


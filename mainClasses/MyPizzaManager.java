package mainClasses;
import java.util.Calendar;
import timeStamp.Date;
import timeStamp.Time;
import java.util.Scanner;
import java.util.InputMismatchException;

 /**
 * MyPizzaManager.java - Sub Class that extends PizzaManager object 
 * 
 * @author Reshma Sivakumar  
 * @version  2.0 3/13/2016
 *
 * Description:  This is the sub class for PizzaManager Superclass and is used to keep track of a list of objects
 *               of type Pizza and manages all the operations that can  be performed on the Pizza object. 
 *               PizzaManager class gives the user the following options
 *               - add a random new pizza
 *               - add hundred pizza (bulk add)
 *               - eat a fraction of a pizza
 *               - sort pizzas by price, cost and calories
 *               - search pizzas by calories
 *               - displays all pizzas in list with details on size remaining
 *                  cost and calories.
 *               - search pizzas made on a day
 *               - remove day old pizzas
 *               - reverse list of pizzas
 *              
  *               When a Pizza is first made, it has 100% (1/1) of it’s surface area available for eating. As a pizza is eaten,
 *               fractions are removed from the ratio of pizza remaining, until the pizza is gone and the ratio reaches 0.
 *               All pizzas will have a Timestamp when they are made.
 *               
 *              
 * Class Invariants:  - The pizza to be eaten should be specified in proper fraction.
 *                    - When a Pizza is made, it starts with 100% of it’s area left (so a Fraction of 1/1)
 *                    - A Pizza’s remaining ratio must be between (0,1] excluding 0 and including 1.
 *                    - When a Pizza’s fractionRemaining reaches 0, that 
 *                          a.  If a Pizza’s remaining fraction is less than 0,
 *                          throw an exception as this is an error case
 *                          b.  If a Pizza’s remaining fraction is equal to 0, 
 *                          throw an exception that is caught by your Manager 
 *                          and remove that eaten pizza from the list.
 *                    - A Pizza’s price is the sum of its ingredients’ costs.
 *                    - A Pizza’s calorie count is the sum of its ingredients’ calories and represents the caloric consumption per 
 *                      serving and remains static.
 *                   - Adding ingredients will add the price of a Pizza.
 *                  - Reducing the remaining Fraction of pizza left will reduce the price of the Pizza accordingly                
 */

public class MyPizzaManager extends PizzaManager 
{
    Scanner input = new Scanner(System.in);
    private ArrayList<Pizza> pizzaList = new ArrayList<Pizza>(); 

    /**
    * Method :          getNextChar
    * Purpose :         Overriden method is used to get next char from the console(menu option).
    * 
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          char value representing menu option.                          
    */      
    @Override
    protected char getNextChar() 
    {
       char selection = input.next().charAt(0);
       return selection;

    }

    /**
    * Method :          getNextInt
    * Purpose :         Overriden method is used to get next int from the console(menu option).
    * 
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          int value representing menu option.                          
    */   
    @Override
    protected int getNextInt() 
    {
       int selection = 0;
       try
       {
           selection = input.nextInt();
       }catch (InputMismatchException ie)
       {
           System.out.println ("Input should be an int value");
       }
       return selection;
    }

    /**
    * Method :          displayAllPizzas
    * Purpose :         This method is used to display all Pizza objects in the list.
    * 
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          None.                          
    * 
    * @throws           None .
    */       
    @Override
    protected void displayAllPizzas() 
    {
         for ( int i = 0; i < this.pizzaList.size(); i++ )
                System.out.println( this.pizzaList.get(i) );

    }
    
    
    /**
    * Method :       eatSomePizza
    * Purpose :      Method to be overriden. This method prompts the user to enter a fractional of  a pizza to be eaten along with the index to indicate 
    *                which pizza out of the list of available pizzas to choose. The pizza requested will be retrieved from the list and 
    *                the eatSomePizza of the Pizza class will be called. The pizza list will be displayed. 
    * 
    * @param           None.
    * @preconditions   The pizza amount should be specified as fraction eg 1/4..
    * @postconditions  The pizza amount will be subtracted from the pizza 
    *                  remaining. If the fraction reaches 0, the pizza will be removed from list.
    *                    
    * @returns          None.                          
    * 
    */   

    @Override
    protected void eatSomePizza() 
    {
        if ( this.pizzaList.isEmpty() )
         {
             System.out.println ("First add pizzas");
             return;
         }
        System.out.println("Eating a fraction of a pizza. How much? (a/b)");
        
        String pizzaFraction = input.next();
        int numerator = 0 ;
        int denominator = 0;
        int index = 0;
        Fraction amtToEat = null;
        Pizza pizzaToEat = null;
        
        try
        {
            if (! (pizzaFraction.contains("/")))
            {
                System.out.println("Invalid fraction entered!");
                return;
            }
       
        
        String str = new String(pizzaFraction).trim();
        String[] strSplit = str.split("/");
        int splitLength = str.length();
        
        if ( str.length() != 3 )
        {
           System.out.println("Invalid fraction entered!");
           return;   
        }
        // Convert String numerator to int and store in numerator 
        if (splitLength > 0 )
        {
            numerator = Integer.parseInt(strSplit[0]); 
            if (splitLength > 1 ) 
            {
                // Convert String denominator to int
                // and store in denominator
                denominator = Integer.parseInt(strSplit[1]);
            }
            else
                denominator = 1; 
            //create fraction object with numerator and denomintor read
            if ( numerator > denominator ) 
            {
                System.out.println ("Invalid Fraction entered!");
                return;
            }
            amtToEat = new Fraction(numerator,denominator);
            
        }
       
            System.out.println ("Enter an index of the Pizza you would like" +
                                    "to eat(1- " +this.pizzaList.size()+")");
            index = input.nextInt();
            if ( index < 1 || index > this.pizzaList.size())
            {
              System.out.println ("Invalid Index entered!");
                return;  
            }
            index = index - 1;
            pizzaToEat = this.pizzaList.get(index);
            
            pizzaToEat.eatSomePizza(amtToEat);
             

        }catch ( PizzaException pe )
        {
            
           System.out.println (pe.getMessage());
           try
           {
               if ( pizzaToEat.getRemaining ().getNumerator() == 0 )
               {
                    this.pizzaList.remove (index);
                }
           }catch ( PizzaException pe2 )
           {
               System.out.println (pe2.getMessage());
           }
        //}
       }catch ( NumberFormatException nfe )
           {
               System.out.println ("Invalid Fraction! Must be numbers");
           } catch (InputMismatchException ime )
           {
               System.out.println ("Invalid Fraction! Must be numbers");
            }
    }
    
  
   /**
    * Method :          addRandomPizza
    * Purpose :         This method is used to add a new Pizza object to the 
    *                   list. 
    * 
    * @param            None.
    * @preconditions    None. 
    * @postconditions   A new Pizza object will be added to the list.
    *                    
    * @returns          None.                          
    * 
    * @throws           PizzaException - When Pizza object creation fails and trying
    *                   to insert null object to list
    */   
    @Override
    protected void addRandomPizza() 
    {
       try
       {
         System.out.println("Adding a  pizza to the List."); 
           Pizza newPizza = new Pizza ();
           this.pizzaList.add ( newPizza );   
       }catch ( PizzaException pe2 )
       {
           System.out.println (pe2.getMessage());
       }
    }

    /**
    * Method :          quickSortByPrice
    * Purpose :         Overidden method is used to sort the list of Pizza 
    *                   objects by Price of the pizzas using Quick Sort algorithm.
    *                   Price is sorted lowest to highest.
    * 
    * @param            None.
    * @preconditions    None. 
    * @postconditions   The pizza list will be displayed in the sorted
    *                   order of the price of the pizzas in the list.
    *                    
    * @returns          None.                          
    * 
    */  

    @Override
    protected void quickSortByPrice() 
    {  
        try
        {
            quickSortByPrice( this.pizzaList, 0, this.pizzaList.size()-1 );
        }catch (PizzaException pe)
        {
            System.out.println(pe.getMessage());   
        }
    }
    
    private void quickSortByPrice( ArrayList<Pizza> data, int low, int high) throws PizzaException
    {  
        int pivot;
        //throw new RuntimeException( "quickSortByPrice() not yet implemented in MyPizzaManager subclass!");
        if ( data == null || data.size() == 0 )
            throw new PizzaException ("Nothing to sort. Empty Pizza List");
        if (low >= high)
            return;
 
        pivot = partitionPrice (data, low, high);
        quickSortByPrice ( data, low, pivot-1);
        quickSortByPrice ( data, pivot+1, high);
        
        
    }
    
    private int partitionPrice(ArrayList<Pizza> data, int low, int high) {
        int i = low + 1;
        int j = high;
        
         
        while(i <= j) 
        {
            if ( data.get(i).compareTo(data.get(low)) <= 0 )
            {
                i++;
            }
            else if(data.get(j).compareTo(data.get(low)) > 0)
            {
                j--;
            }
            else if(j < i)
                  break;
            else
            {
                data.swap(i, j);
            } 
        }
        data.swap(low, j); 
        return j;
    }
     
    /**
    * Method :          quickSortBySize
    * Purpose :         Overriden method is used to sort the list of Pizza 
    *                   objects by size(remaining area) of the pizzas using Quick Sort algorithm.
    *                   Size is sorted lowest to highest.
    * 
    * @param            None.
    * @preconditions    None. 
    * @postconditions   The pizza list will be displayed in the sorted
    *                   order of the size of the pizzas in the list.
    *                    
    * @returns          None.                          
    * 
    */  
        
    protected void quickSortBySize() 
    {
        try
        {
            quickSortBySize ( this.pizzaList, 0, this.pizzaList.size() - 1);
        }catch (PizzaException pe)
        {
           System.out.println(pe.getMessage()); 
        }
    }
    
    private void quickSortBySize( ArrayList<Pizza> data, int low, int high) throws PizzaException
    {  
        int pivot;
        //throw new RuntimeException( "quickSortByPrice() not yet implemented in MyPizzaManager subclass!");
        if ( data == null || data.size() == 0 )
            throw new PizzaException  ("Nothing to sort. Empty Pizza List");
        if (low >= high)
            return;
 
        pivot = partitionSize (data, low, high);
        quickSortBySize ( data, low, pivot-1);
        quickSortBySize ( data, pivot+1, high);
        
        
    }
    
    private int partitionSize(ArrayList<Pizza> data, int low, int high) {
        int i = low + 1;
        int j = high;
        
         
        while(i <= j) 
        {
            if ( data.get(i).compareToBySize(data.get(low)) <= 0 )
            {
                i++;
            }
            else if(data.get(j).compareToBySize(data.get(low)) > 0)
            {
                j--;
            }
            else if(j < i)
                  break;
            else
            {
                data.swap(i, j);
            } 
        }
        data.swap(low, j); 
        return j;
    }
 
    /**
    * Method :          quickSortByCalories
    * Purpose :         Overriden method is used to sort the list of Pizza 
    *                   objects by calories of the pizzas using Quick Sort algorithm.
    *                   Pizza list with calories is sorted lowest to highest.
    * 
    * @param            None.
    * @preconditions    None. 
    * @postconditions   The pizza list will be displayed in the sorted
    *                   order of the calories of the pizzas in the list.
    *                    
    * @returns          None.                          
    * 
    */  
    protected void quickSortByCalories() {
        //throw new RuntimeException( "quickSortByCalories() not yet implemented in MyPizzaManager subclass!");
        try
        {
            quickSortByCalories ( this.pizzaList, 0, this.pizzaList.size()-1);
        }catch (PizzaException pe)
        {
           System.out.println(pe.getMessage()); 
        }            
    }
        
    private void quickSortByCalories( ArrayList<Pizza> data, int low, int high) throws PizzaException
    {  
        int pivot;
        //throw new RuntimeException( "quickSortByPrice() not yet implemented in MyPizzaManager subclass!");
        if ( data == null || data.size() == 0 )
            throw new PizzaException  ("Nothing to sort. Empty Pizza List");
        if (low >= high)
            return;
 
        pivot = partitionCalories (data, low, high);
        quickSortByCalories ( data, low, pivot-1);
        quickSortByCalories ( data, pivot+1, high);
        
        
    }
    
    private int partitionCalories(ArrayList<Pizza> data, int low, int high) {
        int i = low + 1;
        int j = high;
        
         
        while(i <= j) 
        {
            if ( data.get(i).compareToByCalories(data.get(low)) <= 0 )
            {
                i++;
            }
            else if(data.get(j).compareToByCalories(data.get(low)) > 0)
            {
                j--;
            }
            else if(j < i)
                  break;
            else
            {
                data.swap(i, j);
            } 
        }
        data.swap(low, j); 
        return j;
    }
    
    
    /**
    * Method :          binarySearchByCalories
    * Purpose :         Overriden method is used to search the list of Pizza objects for a specified calories of the pizza
    *                    in the list using Binary Search algorithm. The list is first sorted on calories to be able to
    *                   perform a Binary search. The pizza with the requested calories will be displayed.
    *                   
    *                   Binary Search algortihm works as defined below:
    *
    *                     LowIndex = 0
    *                     HighIndex = arraySize – 1
    *                     While LowIndex is less than or equal to HighIndex
    *                       Set MidIndex to be equal to half way between the 
    *                       low and high index
    *                       If the target word matches the word at MidIndex, 
    *                       return MidIndex (first case)
    *                       If the target word is before the word at MidIndex,
    *                       then set HighIndex to MidIndex - 1
    *                       If the target word is after the word at MidIndex, 
    *                       then set LowIndex to MidIndex + 1
    *                    
    *
    * @param            None.
    * @preconditions    None. 
    * @postconditions   The pizza list will be searched for the one with the 
    *                   specified calories and displayed.                  
    *                    
    * @returns          int value that represents the index of the pizza in the list that satisfies the calories searched.                          
    * 
    */
    @Override
    protected int binarySearchByCalories(int cals) 
    {
        int retVal = -1;
        try
        {
           if (this.pizzaList.isEmpty())
                throw new PizzaException("Nothing to search. No Pizzas available");
            quickSortByCalories();
            retVal =  binarySearchByCalories ( this.pizzaList, cals, 0, this.pizzaList.size()-1);
        }catch (PizzaException pe)
        {
           System.out.println(pe.getMessage()); 
        }
        if ( retVal >= 0 )
          System.out.println( " Pizza list has Pizza with " +  cals + " calories.");
         
       return retVal;
    }       


    private int binarySearchByCalories (ArrayList<Pizza> data, int target, int lowIndex, int highIndex) throws PizzaException
                                                                           
    {
       int midIndex =  ( ( highIndex + lowIndex ) / 2 );  
       
       if ( lowIndex > highIndex )
            throw new PizzaException("No Pizza in the list has " +  target + " calories.");
       
           
       if ( target == data.get(midIndex).getCalories())
       {
          return midIndex;
       }
       else if (target > data.get(midIndex).getCalories() )// if greater
       {
           lowIndex = midIndex + 1;
           return  binarySearchByCalories ( data, target, lowIndex, highIndex );
       }
       else
       {
           highIndex = midIndex - 1;
           return  binarySearchByCalories ( data, target, lowIndex, highIndex );
       }
    }

   
    /**
    * Method :          linearSearchByDay
    * Purpose :         Method to override. This method is used to search the list of Pizza objects linearly to find the 
    *                   index of Pizza that is made on a given day
    *
    *
    * @param            None.
    * @preconditions    None. 
    * @postconditions   The pizza list will be searched find the  index of Pizza that is made on a given day                 
    *                    
    * @returns          int value that represents the index of Pizza that is made on a given day.                          
    * 
    */        
    protected int linearSearchByDay(int day) 
    {
        int retVal = -1;
        int index = 0;

        try
        {
            if ( this.pizzaList == null )
                throw new PizzaException ("No Pizzas to search");
            while (index <= this.pizzaList.size()-1)
            {
                  if ( ! (( this.pizzaList.get(index).getMadeDate()).getDay() == day))
                    index ++;
                  else
                  {
                      retVal = index;
                      break;
                  }
            }
            if (retVal == -1 )
                throw new PizzaException ("No Pizzas made on the day");
            else
               System.out.println("Pizza made on day "+ day + " "+ this.pizzaList.get(retVal));
         } catch (PizzaException pe )
         {
             System.out.println (pe.getMessage());
        }
        return retVal;
    }
 
    /**
    * Method :          getCurrDate
    * Purpose :         Static method is used to return current date
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    * @returns          Date object representing current date.                          
    * 
    */  
    public static Date getCurrDate() { 
        Calendar cal = Calendar.getInstance();
        return new Date(cal.get(Calendar.MONTH), cal.get(Calendar.DATE), cal.get(Calendar.YEAR));
    }

    /**
    * Method :          getCurrTime
    * Purpose :         Static method is used to return current time
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    * @returns          Time object representing current time.                          
    * 
    */     
    public static Time getCurrTime() {
        Calendar cal = Calendar.getInstance();
        return new Time(cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND)); 
    }

    /**
    * Method :          removeDayOldPizzas
    * Purpose :         Method to override. This method is used to remove all Pizza objects that are made before the current
    *                   day (1 day old)
    *
    * @param            None.
    * @preconditions    None. 
    * @postconditions   The pizza list will be searched and removes all Pizza objects that are made before the current
    *                   day (1 day old)
    * @returns          None.                          
    * 
    */  
   protected void removeDayOldPizzas() 
   {
           removeDayOldPizzas (this.pizzaList, getCurrDate(), 0);
   }
   
   private void removeDayOldPizzas (ArrayList<Pizza> data, Date target, int index)
   {
       try
       { 
            if (this.pizzaList.isEmpty())
                throw new PizzaException("Nothing to search. No Pizzas available");
            
            if (index >= this.pizzaList.size())
             {
                 System.out.println("No pizza was found to have older date");
                 return;
                }
                
           if (( data.get(index).getMadeDate()).compareTo (target) >=0 )
           {
               index = index + 1;
               removeDayOldPizzas ( data, target, index );
           }
           else
           {
               data.remove ( index );
               return;
           }
       }catch (PizzaException pe )
       {
            System.out.println(pe.getMessage());
       }
   }

    /**
    * Method :          reversePizzasWithStack
    * Purpose :         Method to override. This method is used to reverse list of Pizza Objects
    * @param            None.
    * @preconditions    None. 
    * @postconditions   The Pizza list will be reversed
    * @returns          None.                          
    * 
    */  
   protected void reversePizzasWithStack() 
   {
        try
        {
            if (this.pizzaList.isEmpty())
                throw new PizzaException("Nothing to search. No Pizzas available");
            Stack<Pizza> pizzaStack = new Stack<Pizza>();
                       
            for ( int i = 0; i < this.pizzaList.size(); i ++ )
            {
                //pizzaStack.push (this.pizzaList.get(this.pizzaList.size() - i -1));
                pizzaStack.push (this.pizzaList.get(i));
             }

            this.pizzaList = new ArrayList<Pizza>();
            while(!(pizzaStack.isEmpty()))
           {
               Pizza popped = pizzaStack.pop();
               this.pizzaList.add (popped); 
 
            }
 
        } catch ( PizzaException pe )
        {
            System.out.println(pe.getMessage());
        }
   }
}
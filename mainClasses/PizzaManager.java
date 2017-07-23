package mainClasses;

import java.util.Calendar;
import java.util.Scanner;

import timeStamp.Date;
import timeStamp.Time;


 /**
 * PizzaManager.java - Super Class representing PizzaManager object 
 * 
 * @author Rob Nash
 *
 * Description:  This is the Super class for PizzaManager subclass is used to keep track of a list of objects
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
 *                
 */
@SuppressWarnings("deprecation")
public class PizzaManager {
    
    /**
    * Method :          main
    * Purpose :         This method is used to start the PizzaManager and displays the menu interface to the user.
    *                   
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          None.                          
    * 
    * @throws           None.
    */   
    
    public final static void main(String[] args) {
        PizzaManager manager = new MyPizzaManager(); //new MyPizzaManagerSoln();  
        manager.start();
    }

    /**
    * Method :          start
    * Purpose :         This method provides a menu driven interface with  which the user can the list of pizzas
    *                   can be managed. The instructions and the menu will be displayed. 
    *                   The following actions can be requested:
    *                   (A)dd a random pizza
    *                   Add a (H)undred random pizzas
    *                   (E)at a fraction of a pizza
    *                   QuickSort pizzas by (P)rice
    *                   QuickSort pizzas by (S)ize
    *                   QuickSort pizzas by (C)alories
    *                   (B)inary Search pizzas by calories
    *                   (L)inear search pizzas by day
    *                   (R)everse order of pizzas with a stack
    *                   Remove (D)ay-old pizzas
    *                   (Q)uit
    *                   Every options displays all pizzas in list with details
    *                   on size, cost, calories and time made
    *                   
    *                    
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          None.                          
    * 
    * @throws           None.
    */   
 
    public final void start() {
    
        while(true) {
            displayAllPizzas();
            displayInstructions();

            switch( getNextChar() ) { //nextChar() doesn't exist for Scanner, so now what?  You do it.
                case    'A':    case    'a':    addRandomPizza();
                                                break;
                case    'H':    case    'h':    addOneHundredPizzas();
                                                break;                  
                case    'E':    case    'e':    eatSomePizza();
                                                break;          
                case    'P':    case    'p':    quickSortByPrice();
                                                break;  
                case    'S':    case    's':    quickSortBySize();
                                                break;
                case    'C':    case    'c':    quickSortByCalories();
                                                break;
                case    'L':    case    'l':    System.out.println("What day are you looking for?");
                                                linearSearchByDay(getNextInt());
                                                break;
                case    'D':    case    'd':    removeDayOldPizzas();
                                                break;
                case    'B':    case    'b':    System.out.println("What calorie count are you looking for?");
                                                binarySearchByCalories(getNextInt());
                                                break;
                case    'R':    case    'r':    reversePizzasWithStack();   
                                                break;
                case    'Q':    case    'q':    System.out.println("(Q)uitting...");
                                                 System.exit(0);
                                                break;
                default:                        System.out.println("Unrecognized input - try again");
            }
        }

    }
    /*
     * Begin free helper methods
     */
    protected static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nQuickSort pizzas by (P)rice\nQuickSort pizzas by (S)ize\nQuickSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(L)inear search pizzas by day\n(R)everse order of pizzas with a stack\nRemove (D)ay-old pizzas\n(Q)uit\n";
    
    /**
    * Method :          getCurrentDate
    * Purpose :         Helper method is used to print the display instructions of the menu.
    * 
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          None.                          
    */   
    
    protected void displayInstructions() {
        System.out.println(instructions);   
    }
    
    /**
    * Method :          getCurrentDate
    * Purpose :         Helper method is used to get current date.
    * 
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          Date object representing current date.                          
    */      
    public static Date getCurrentDate() { 
        Calendar cal = Calendar.getInstance();
        return new Date(cal.getTime().getMonth(), cal.getTime().getDay(), cal.getTime().getYear());
    }

    /**
    * Method :          getCurrentTime
    * Purpose :         Helper method is used to get current time.
    * 
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          Time object representing current time.                          
    */      
    public static Time getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        return new Time(cal.getTime().getHours(), cal.getTime().getMinutes(), cal.getTime().getSeconds()); 
    }

    /**
    * Method :          addOneHundredPizzas
    * Purpose :         Helper method is used to generate 100 randome pizzas.
    * 
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          None.                          
    */      
    public void addOneHundredPizzas() {
        System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
        for(int i = 0; i < 99; i++) {
            addRandomPizza();
        }
    }
    /*
     * End helper methods
     */
    
    
    
    /*
     * Methods to Override
     * Override the following methods your MyPizzaManager Subclass
     * Note that you don't change any of these methods here, but just replace them in the derived class.
     */
    /**
    * Method :          getNextChar
    * Purpose :         THis method will be overriden. This method is used to get next char from the console(menu option).
    * 
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          char value representing menu option.                          
    */       

    protected char getNextChar() {
        char[] options = {'A','H','E','P','S','C','B','R','Q'};
        return options[(int)(Math.random() * options.length)];  //wrong   
    }

    /**
    * Method :          getNextInt
    * Purpose :         THis method will be overriden. This method is used to get next int from the console(menu option).
    * 
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          int value representing menu option.                          
    */       
    protected int getNextInt() {
        return (int)(Math.random()*9+1);            //broken
    }

    /**
    * Method :          displayAllPizzas
    * Purpose :         THis method will be overriden. This method is used to display all Pizza objects in the list.
    * 
    * @param            None.
    * @preconditions    None. 
    * @postconditions   None.
    *                    
    * @returns          None.                          
    */       

    protected void displayAllPizzas() {
        System.out.println("BAD P!ZZAS");           //bad
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
    
    protected void eatSomePizza() {
        throw new RuntimeException( "eatSomePizza() not yet implemented in MyPizzaManager subclass!");
    }

    /**
    * Method :          addRandomPizza
    * Purpose :         Method needs to be overriden. This method is used to add a new Pizza object to the 
    *                   list. 
    * 
    * @param            None.
    * @preconditions    None. 
    * @postconditions   A new Pizza object will be added to the list.
    *                    
    * @returns          None.                          
    * 
    * @throws           PizzaException - .
    */   
    protected void addRandomPizza() {
        throw new RuntimeException( "addRandomPizza() not yet implemented in MyPizzaManager subclass!");
    }

    /**
    * Method :          quickSortByPrice
    * Purpose :         Method to be overriden. This method is used to sort the list of Pizza 
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
    
    protected void quickSortByPrice() {  
        throw new RuntimeException( "quickSortByPrice() not yet implemented in MyPizzaManager subclass!");
    }

    /**
    * Method :          quickSortBySize
    * Purpose :         Method to be overriden. This method is used to sort the list of Pizza 
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
    
    protected void quickSortBySize() {
        throw new RuntimeException( "quickSortBySize() not yet implemented in MyPizzaManager subclass!");
    }

    /**
    * Method :          quickSortByCalories
    * Purpose :         Method to be overriden. This method is used to sort the list of Pizza 
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
        throw new RuntimeException( "quickSortByCalories() not yet implemented in MyPizzaManager subclass!");
    }

    /**
    * Method :          binarySearchByCalories
    * Purpose :         Method to override. This method is used to search the list of Pizza objects for a specified calories of the pizza
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

    protected int binarySearchByCalories(int cals) {
        
        throw new RuntimeException( "binarySearchByCalories() not yet implemented in MyPizzaManager subclass!");
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
    protected int linearSearchByDay(int day) {
        throw new RuntimeException( "linearSearchByDay() not yet implemented in MyPizzaManager subclass!");
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
    protected void removeDayOldPizzas() {
        throw new RuntimeException( "removeDayOldPizzas() not yet implemented in MyPizzaManager subclass!");
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
    protected void reversePizzasWithStack() {
        throw new RuntimeException( "reversePizzasWithStack() not yet implemented in MyPizzaManager subclass!");
    }
}

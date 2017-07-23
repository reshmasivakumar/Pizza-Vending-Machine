package mainClasses;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;

/**
 * Money.java - Class representing Money object
 * 
 * @author Reshma Sivakumar  
 * @version  2.0 3/14/2016
 *
 * Description:  This class is used to track a USD amount 
 *       consisting of two integers to manage dollars
 *       and cents. 
 *
 *              
 * Class Invariants: All dollars and cents will be positive or 0.
 *           Cents will be between 0 to 99.
 *  
 *               
 */
public class Money implements Comparable, Cloneable
{

    /**   Instance Variables **/

    private int dollars; 
    private int cents;

    /**
    * Method :          Constructor
    * Purpose :         Constructs a Money object setting the dollars to
                        the specified dollar value and cents to 0.
    * 
    * @param            None.
    * @preconditions    Specified dollars value should not be negative.
    * @postconditions   A new Money object is created with dollars instance
    *                   variable set to specified value and cents will be 
    *                   set to 0. 
    * 
    * @throws           PizzaException when specified dollar value is
    *                   negative.
    */  
   
    public Money ( int dollars ) 
    {
        try
        {
            setMoney(dollars, 0);
        } catch (PizzaException pe)
        {
            System.out.println (pe.getMessage());
        }
    }
    
    /**
    * Method :          Constructor
    * Purpose :         Constructs a Money object setting the dollars and 
                        cents to the specified dollars and cents value.
    * 
    * @param            dollars - int value.
    * @preconditions    Specified dollars value should not be negative and 
    *                   specified cents value should be between 0 - 99.            
    *          
    * @postconditions   A new Money object is created with dollars instance
    *                   variable set to specified value and cents will be 
    *                   set to 0. 
    *
    * @throws           PizzaException when specified dollar value is
    *                   negative and cents value not between 0 - 99.
    */
   
    public Money ( int dollars, int cents )
    {
        try
        {
            setMoney ( dollars, cents );
        } catch (PizzaException pe)
        {
            System.out.println (pe.getMessage());
        }
    }

    /**
    * Method :          Copy Constructor
    * Purpose :         Creates a copy of the specified Money object  
                        by calling setDollars and setCents method
    * 
    * @param            other - Money object
    * @preconditions    None.         
    *          
    * @postconditions   A copy of Money object is created and set to this 
    *                   object with dollars and cents set to the specified
    *                   Money object.
    *                    
    */
   
    public Money ( Money other )
    {
        try
        {
            setDollars(other.dollars);
            setCents(other.cents);
        }catch (PizzaException pe)
        {
            System.out.println (pe.getMessage());
        }
    }

    /**
    * Method :          setDollars
    * Purpose :         Mutator method for setting dollar amount in this
    *                   money object.  
    *            
    * 
    * @param            dollars - int value.
    * @preconditions    Specified dollars value should not be negative. 
    * @postconditions   The dollars value of this object will be set to 
    *                   the specified value.
    *                    
    * @returns          None.                          
    * 
    * @throws           PizzaException when specified dollar value is
    *                   negative.
    */
    
    public void setDollars(int dollars) throws PizzaException
    {
        if ( dollars < 0 )
        {
            String msg = "Error in set: Provide a positive value for dollars";
            throw new PizzaException(msg);
        }
        else 
        {
            this.dollars = dollars; //set instance variable using dollars input
        }
    }
    
    /**
    * Method :          setCents
    * Purpose :         Mutator method for setting cents value in this
    *                   money object.  
    *            
    * 
    * @param            cents - int value.
    * @preconditions    Specified cents value should be between 0 to 99.     
    * @postconditions   The cents value of this object will be set to 
    *                   the specified value.                   
    * @returns          None.                          
    * 
    * @throws           PizzaException when specified cents value is
    *                   not between 0 to 99.
    */
    public void setCents ( int cents ) throws PizzaException
    {
       if ( cents < 0 || cents > 99 )
        {
            String msg = "Error in set: Cents should be between 0 and 99.";
            throw new PizzaException(msg);
        }
        else 
        {
            this.cents = cents; //set instance variable using cents input
        } 
    }

    /**
    * Method :          setMoney
    * Purpose :         Mutator method for setting dollars and cents amount in 
    *                   this money object.  
    *            
    * 
    * @param            dollars - int value.
    * @param            cents - int value.
    * @preconditions    Specified dollars value should not be negative. 
    *                   Specified cents value should be between 0 to 99.          
    *          
    * @postconditions   The dollars and cents value of this object will be  
    *                   set to the specified values.               
    * @returns          None.                          
    * 
    * @throws           PizzaException when specified dollar value is
    *                   negative or cents value is not between 0 to 99.
    */
    
    public void setMoney( int dollars, int cents ) throws PizzaException
    {
       setDollars ( dollars );
       setCents ( cents );
    }

    /**
    * Method :          getMoney
    * Purpose :         Accessor method for getting dollars and cents value 
    *                   represented by this money object.  
    *            
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          double value representation of this Money object.                          
    *                   For eg. if dollars value is 35 and cents is 75
    *                   getMoney() will return 35.75
    * @throws           PizzaException when specified dollar value is
    *                   negative or cents value is not between 0 to 99.
    */
    
    public double getMoney ()
    {
        double money = 0.0;
        money = this.dollars +  this.cents / 100.00 ;
        return money;
    }
    
    public int getDollars ()
    {
        return this.dollars;
    }
    
    public int getCents ()
    {
        return this.cents;
    }
    
    /**
    * Method :          add
    * Purpose :         Increments the value of the dollars stored in 
    *                   this object with the specified dollar value.  
    *            
    * 
    * @param            dollars - int value.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          None.                          
    *            
    * @throws           PizzaException when specified dollar value is
    *                   negative.
    */
   
    public void add(int dollars) throws PizzaException
    {
        if ( dollars < 0 )
        {
            String msg = "Error in add: Provide a positive value for dollars";
            throw new PizzaException(msg);
        }
        
        this.dollars += dollars;
    }
    
    /**
    * Method :          add
    * Purpose :         Increments the value of the dollars and cents stored in 
    *                   this object with the specified dollars value and
    *                   cents value.  
    *            
    * 
    * @param            dollars - int value.
    * @param            cents   - int value.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          None.                          
    *            
    * @throws           PizzaException when specified dollar value is
    *                   negative and cents value not between 0 to 99.
    */

    public void add(int dollars, int cents) throws PizzaException
    {
       if  ((cents < 0 ) || ( cents > 99 ))
           throw new PizzaException("Error in add: Cents should be 0 to 99");

        add ( dollars );
        this.cents += cents;
       if ( this.cents > 99 )
        {
            double centToDollars = this.cents / 100.00;
            this.dollars += centToDollars;
            int remainingCents = this.cents % 100;
            this.cents = remainingCents;
        } 
    }
    
    /**
    * Method :          add
    * Purpose :         Increments the value of the dollars and cents stored in 
    *                   this object with the values represented by the specified
    *                   object.  
    *            
    * 
    * @param            Money   -  Money class object
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          None.                          
    *            
    * @throws           PizzaException when specified object has dollar value
    *                   negative and cents value not between 0 to 99.
    */

    public void add ( Money other ) throws PizzaException
    {
        if ( other == null )
        {
            String msg = "Error in add: Cannot add from null refrence";
            throw new NullPointerException(msg);
        }
        
        Money temp = new Money ( other.dollars, other.cents );
        add ( temp.dollars, temp.cents );
    }
    
    /**
    * Method :          equals
    * Purpose :         Compares this object with the specified object to see  
    *                   if they are equal. 
    * 
    * @param            other   -  Money class object
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          boolean - true if equals, false otherwise.                         
    *            
    */

    public boolean equals ( Money other ) throws PizzaException
    {
        if ( other == null )
            return false;
            
        if (!(other instanceof Money ))    
            return false;
        
        Money temp = new Money ( other.dollars, other.cents );
        return this.dollars == temp.dollars &&
               this.cents == temp.cents;
    }
    
    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing in dollars and cents. 
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing in dollars and cents.  .                          
    *            
    */

    public String toString()
    {
        String retVal = "";
 
        if ( this.cents < 10 )
            retVal = "$" + this.dollars + "." + "0" + this.cents;
        else
            retVal = "$" + this.dollars + "." + this.cents;
        
        return retVal;
    }

    /**
    * Method :          compareTo
    * Purpose :         Compares the dollars and cents of 
    *                   specified object with this object. 
    *                   
    * @param            other - Object of Money class to 
    *                   be compared.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          integer - a negative integer, zero, 
    *                   or a positive integer as this object 
    *                   is less than, equal to, or greater
    *                   than the specified object.                          
    *      
    * @throws           NullPointerException - if the specified 
    *                   object is null
    *                   ClassCastException - if the specified 
    *                   object is not of type Money.          
    */
   
    @Override  
    public int compareTo (Object object)
    {
        Money other = (Money) object;
        if ( other == null )
            throw new NullPointerException ("Money object passed is null");
            
        if (!(other instanceof Money ))    
            throw new ClassCastException("Object passed is not of type Money");
         
        if  (this.dollars  == other.dollars &&  this.cents == other.cents )
               return 0;
               
        if (this.dollars > other.dollars )
                return 1;
                
        if (this.dollars <  other.dollars )
                return -1;
                
        if (this.cents > other.cents)
                return 1;
        else 
                return -1;
    }

    /**
    * Method :          clone
    * Purpose :         Overridden clone method to create
    *                   a copy of this Money object
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   Creates a deep copy of this object to
    *                   a new Money object .  
    * @returns          Object - Newly created Money Object                      
    *            
    */
   
    @Override
    public Object clone() 
    {
          return new Money(this);
    }
    
   public static void main(String[] args)
   {
        try 
        {
            System.out.println ("****Running tests for Money class HW8 - start ****");
            System.out.println ();
            System.out.println();
            System.out.println ( "Create money1 with dollars 10");    
            Money money1 = new Money(10);
            System.out.println (money1.toString());
            System.out.println ( "Create money2 with dollars=210 and cents=80");
            Money money2 = new Money(210,80);
            System.out.println(money2.toString());
            
            System.out.println("Calling compareTo on money1 and money2");
            if (money1.compareTo(money2) < 0)
                System.out.println("money1 is less than money2");
            else if (money1.compareTo(money2) > 0)
                System.out.println("money1 is greater than money2");
            else
                System.out.println("money1 is equal to money2");
                
            System.out.println();
            System.out.println ( "Create money3 with dollars=500 and cents=10");
            Money money3 =  new Money (500,10);
            System.out.println(money3.toString());
            
            System.out.println("Calling compareTo on money2 and money3");
            if (money2.compareTo(money3) < 0)
                System.out.println("money2 is less than money3");
            else if (money2.compareTo(money3) > 0)
                System.out.println("money2 is greater than money3");
            else
                System.out.println("money2 is equal to money3");
            
            System.out.println();
            System.out.println("Clone money3 to money4");
            Money money4 = (Money)money3.clone();
            System.out.println(money4.toString());     
            if (money3.compareTo(money4) == 0)
                System.out.println("money3 was cloned successfully");
                
            System.out.println();
            try
            {
                System.out.println("Test Serializable methods for Money class");
                System.out.println("Writing serialized money1 object to MoneyTest.txt");
                File f = new File ("c:\\temp\\MoneyTest.txt");
                FileOutputStream outFile = new FileOutputStream(f);
                ObjectOutputStream outStream = new ObjectOutputStream(outFile);
                outStream.writeObject(money1);
                outStream.flush();
                outStream.close();    
                
                System.out.println();
                System.out.println("Reading serialized money object from MoneyTest.txt");
                FileInputStream inFile = new FileInputStream(f);
                ObjectInputStream inStream = new ObjectInputStream(inFile);
                Money newMoney = (Money)inStream.readObject();
                System.out.println ( "Printing serialized money1 object read from file" );
                System.out.println ( newMoney.toString() );
                
                
            } catch (IOException ioe)
            {
               System.out.println (ioe.getMessage());
            }   
            catch (ClassNotFoundException cne)
            {
                System.out.println (cne.getMessage());
            }
                
        } catch (RuntimeException re)
        {
            System.out.println(re.getMessage());
        }                

        System.out.println();
        System.out.println ("**** End tests for Money class HW8 - End****");
        System.out.println();     
    }        

}

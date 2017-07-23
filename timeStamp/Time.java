package timeStamp;

import mainClasses.PizzaException;
import java.util.StringTokenizer;

/**
 * Date.java - Class representing Date object
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 3/14/2016
 *
 * Description:  This class represents a Time object which internally
 *       stores the hours, mintues and seconds as integer values representing
 *       24 hour clock.
 *              
 * Class Invariants: The class validates the following 
 *           - Hour should be between 0 to 23 (24 hour clock)
 *           - Minute should be between 0 - 59
 *           - Second should be between 0 - 59           
 *               
 */

public class Time 
{
    private int hour;
    private int minute;
    private int second;
    
    /**
    * Method :          Constructor
    * Purpose :         Constructor that takes hour, min and second valies as integer 
    *                   input and constructs a TimeStamp Object 
    *                   
    * @param            hour - int value representing hour between 0 to 23 (24 hour clock)
    * @param            minute - int value representing mintute between 0 - 59
    * @param            second - int value representing second between 0 - 59
    * @preconditions    Valid int values to be passed as input
    * @postconditions   A new Time object is created with the values
    *                   initialized to specified values.
    */  
    public Time (int hour, int minute, int second) 
    {
        setHour (hour);
        setMinute (minute);
        setSecond (second);
    }
 
        
    /**
    * Method :          COpy Constructor
    * Purpose :         Copy Constructor that time as String representation and
    *                   constructs a Time Object 
    *                   eg  new Time("hh:mm"ss")
    * @param            time - String value representing time in "hh:mm"ss" format
    * @preconditions    Valid String value representing time in "hh:mm"ss" format to be 
    *                   passed as input
    * @postconditions   A new Time object is created with the values
    *                   initialized to specified values.
    */  
    public Time (String time) 
    {
        try
        {
          
            // Time must be in hh:mm:ss format.
            if (time.length() < 8 )
                throw new PizzaException ("Specify a valid Time string in hh:mm:ss format");
            //tokenize to seperate hour, min and second values    
            StringTokenizer tokenizer = new StringTokenizer (time, ":");
            
            if (tokenizer.countTokens() != 3 )
                throw new PizzaException ("Specify a valid Time string in hh:mm:ss format");
               
            if (tokenizer.hasMoreTokens())
            {
                setHour (Integer.parseInt(tokenizer.nextToken()));
                setMinute (Integer.parseInt(tokenizer.nextToken()));
                setSecond (Integer.parseInt(tokenizer.nextToken()));
            }
        }catch( PizzaException pe)
        {
            System.out.println(pe.getMessage());
        }            
    }

    /**
    * Method :          Overloaded COpy Constructor
    * Purpose :         Copy Constructor that takes a valid Time object as input and 
    *                   constructs a Time Object 
    *                    
    * @param            other - Time object 
    * @preconditions    Valid  Time object as input 
    * @postconditions   A new Time object is created with the values
    *                   initialized to specified values.
    */  
    public Time (Time other) 
    {
        try
        {
            if ( other == null )
                throw new PizzaException ("Specify a valid time");
                
            Time temp = new Time ( other.getHour(), other.getMinute(), other.getSecond());
            this.hour = temp.hour;
            this.minute = temp.minute;
            this.second = temp.second;
        }catch( PizzaException pe)
        {
            System.out.println(pe.getMessage());
        }
    }
       
    
    /**
    * Method :          setHour 
    * Purpose :         Mutator method for setting this object with 
    *                   specified hour value.
    *
    * @param            hour - int value  
    * @preconditions    Valid hour value - 0 to 23
    *
    * @postconditions   The hour value of this object is 
    *                   set to specified valid value.
    *
    */
    public void setHour (int hour) 
    {
        try
        {
        // hour should be between 0 to 23 (24 hour clock)
            if (hour < 0 || hour > 23 )
                throw new PizzaException ("Specify an hour between 0 to 23");
            
            this.hour = hour;
        }catch( PizzaException pe)
        {
            System.out.println(pe.getMessage());
        }
    }

    /**
    * Method :          setMinute 
    * Purpose :         Mutator method for setting this object with 
    *                   specified minute value.
    *
    * @param            minute - int value  
    * @preconditions    Valid minute value - 0 to 59
    *
    * @postconditions   The minute value of this object is 
    *                   set to specified valid value.
    *
    */
    public void setMinute (int minute) 
    {
        try
        {
        // minute should be between 0 - 59
            if ( minute < 0 || minute > 59 )
                throw new  PizzaException ("Specify minute between 0 to 59");
               
            this.minute = minute;
        }catch( PizzaException pe)
        {
            System.out.println(pe.getMessage());
        }            
    }

    /**
    * Method :          setSecond 
    * Purpose :         Mutator method for setting this object with 
    *                   specified second value.
    *
    * @param            second - int value  
    * @preconditions    Valid second value - 0 to 59
    *
    * @postconditions   The second value of this object is 
    *                   set to specified valid value.
    *
    */
    public void setSecond (int second) 
    {
        try
        {
            // second should be between 0 - 59
            if ( second < 0 || second > 59 )
                throw new  PizzaException ("Specify second between 0 to 59");
               
            this.second = second;
        }catch( PizzaException pe)
        {
            System.out.println(pe.getMessage());
        }
    }

    /**
    * Method :          setTime 
    * Purpose :         Mutator method for setting this object with 
    *                   specified hour, minute and second values.
    *
    * @param            hour - int value  
    * @param            minute - int value
    * @param            day - int value
    * @preconditions    Valid hour value - 0 to 23
    *                   Valid minute value - 0 to 59
    *                   valid second value - 0 to 59
    *
    * @postconditions   The hour, minute and second values of this object is 
    *           set to specified valid values.
    *
    */
    public void setTime ( int hour, int minute, int second) 
    {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }
 
    /**
    * Method :          getHour
    * Purpose :         Accessor method to return this hour value of this object 
    *                               
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          int value representing the hour  
    *            
    */    
    public int getHour ()
    {
        return this.hour;
    }

    /**
    * Method :          getMinute
    * Purpose :         Accessor method to return this minute value of this object 
    *                               
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          int value representing the minute  
    *            
    */    
    public int getMinute ()
    {
        return this.minute;
    }
 
    /**
    * Method :          getSecond
    * Purpose :         Accessor method to return this second value of this object 
    *                               
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          int value representing the second  
    *            
    */    
    public int getSecond ()
    {
        return this.second;
    }

    /**
    * Method :          getTime
    * Purpose :         Accessor method to return this time object 
    *                               
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          This time object
    *            
    */   
    public Time getTime() 
    {
        return new Time (this);
    }
    
    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing in Time[hour=hh, minute=mm, second=ss]" format. 
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing in mm/dd/yyyy format.                             
    *            
    */ 
   @Override
    public String toString() {
        return "Time [hour=" + hour+ ", minute=" + minute + ", second="
                + second+ "]";
    }
    

    /**
    * Method :          equals 
    * Purpose :         Checks if the Time represented by this  
    *                   object is equal to the specified object.
    *            
    * @param            other - Time object
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          boolean - true if this Time object is equal
    *                   to specified object, false otherwise
    *        
    */   
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Time))
            return false;
        Time other = (Time) obj;
        if (hour != other.hour)
            return false;
        if (minute != other.minute)
            return false;
        if (second!= other.second)
            return false;
        return true;
    }
}

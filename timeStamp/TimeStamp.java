package timeStamp;

import mainClasses.PizzaException;

/**
 * TimeStamp.java - Class representing TimeStamp object
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 3/14/2016
 *
 * Description:  This class represents a TimeStamo object which extends the Date class 
 *       represents the Date and Time.
 *              
 * Class Invariants: The class validates the following 
 *           - day between 0 to 31. 
 *           - month between 0 to 12 or January to December
 *           - Year between 2014 to 2024
 *           - Hour should be between 0 to 23 (24 hour clock)
 *           - Minute should be between 0 - 59
 *           - Second should be between 0 - 59
 *  
 *               
 */
@SuppressWarnings("deprecation")
public class TimeStamp extends Date
{
      /** Instance Variables **/

    private final Time time; // time object
    
    
    /**
    * Method :          Constructor
    * Purpose :         Constructor that takes Date and Time Objects as  
    *                   input and constructs a TimeStamp Object 
    *                   
    * @param            newDate - Date object
    * @param            newTime - Time object
    * @preconditions    Valid Date Object and valid Time object passed as input.
    * @postconditions   A new TimeStamp object is created with the date and time
    *                   initialized to specified values.
    */  
    public TimeStamp (Date newDate, Time newTime)
    {
     
        super(newDate);
        this.time = new Time (newTime);
    }
    
    /**
    * Method :          getDate
    * Purpose :         Method that returns the Date object of this 
    *                   TimeStamp Object 
    *                   
    * @param            None
    * @preconditions    None
    * @postconditions   None
    * @returns          Date object of this TimeStamp Object 
    */      
    public Date getDate () 
    {
        return new Date (this);
    }

    /**
    * Method :          getTime
    * Purpose :         Method that returns the Time object of this 
    *                   TimeStamp Object 
    *                   
    * @param            None
    * @preconditions    None
    * @postconditions   None
    * @returns          Time object of this TimeStamp Object 
    */ 
    public Time getTime()  
    {
        return new Time (this.time);
    }   

   /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing in 
    *                   "TimeStamp at hh:mm:ss and mm/dd/yyyy"
    * 
    * @param            None
    * @preconditions    None       
    * @postconditions   None  
    * @returns          String representation of this object  
    *                   for printing in hh:mm:ss and mm/dd/yyyy  format.                             
    *            
    */
    public String toString() 
    {
        return " TimeStamp at: " + time.getHour() + ":" 
                + time.getMinute()+":"+ time.getSecond() + " and " 
                + super.toString();
    }
}

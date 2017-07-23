package timeStamp;

import mainClasses.PizzaException;
import java.util.Calendar;

/**
 * Date.java - Class representing Date object
 * 
 * @author Reshma Sivakumar  
 * @version  1.0 3/14/2016
 *
 * Description:  This class represents a Date object which internally
 *       stores the month, day and year as integer values. The
 *       class allows you to specify the month as String. This 
 *       class doesnot store the time information.
 *              
 * Class Invariants: The class validates the following 
 *           - day between 0 to 31. 
 *           - month between 0 to 12 or January to December
 *           - Year between 2014 to 2024
 *  
 *               
 */

public class Date implements Comparable
{

    /** Instance Variables **/

    private int month;
    private int day;
    private int year;

    /**
    * Method :          Constructor
    * Purpose :         Overloaded constructor that takes day and year as  
    *                   int values and month as String.
    *                   For eg., Date("January", 1, 2015). 
    * @param            month - String value (case insensitive)
    * @param            day - int value
    * @param            year - int value
    * @preconditions    Valid month values - January to December.
    *                   Valid day values - 1 to 31
    *                   valid year values - 2014 to 2024
    * @postconditions   A new Dateobject is created with the month, day
    *                   and year members initialized to specified values.
    *
    * @throws           PizzaException when invalid data specified for
    *                   month, day and year. 
    */  
       
    public Date (String month, int day, int year) 
    {
        setDate ( month, day, year );        
       
    }
    

    /**
    * Method :          Constructor
    * Purpose :         Overloaded constructor that takes day and year as  
    *                   and month as int values
    *                   For eg., Date(1, 1, 2015). 
    * @param            month - int value
    * @param            day - int value
    * @param            year - int value
    * @preconditions    Valid month values - 1 to 12.
    *                   Valid day values - 1 to 31
    *                   valid year values - 2014 to 2024
    * @postconditions   A new Dateobject is created with the month, day
    *                   and year members initialized to specified values.
    * @throws           PizzaException when invalid data specified for
    *                   month, day and year.
    * 
    */   
       
    public Date (int month, int day, int year) 
    {

        setDate ( month, day, year );        
        
    }

    /**
    * Method :          Copy Constructor
    * Purpose :         Constructs a copy of the Date Object specified 
    *                   to this object.
    * @param            Date - a Date object. 
    * @preconditions    None.
    * @postconditions   A new Dateobject is created with the month, day
    *           and year members copied from the specified object.
    * 
    */   
    
    public Date ( Date that ) 
    {
        try
        {
            if ( that == null )
                throw new PizzaException("Error:Cannot construct from null");
            
            Date temp = new Date ( that.month, that.day, that.year);
            this.month = temp.month;
            this.day = temp.day;
            this.year = temp.year;   
        }catch( PizzaException pe)
        {
            System.out.println(pe.getMessage());
        }
        
    }
    
  

    /**
    * Method :          setDate 
    * Purpose :         Mutator method for setting this object with 
    *                   specified month, day and year values.The month
    *                   specified here is in String. 
    *                   setDate("January", 1, 2015)  
    *
    * @param            month - String value (case insensitive)
    * @param            day - int value
    * @param            year - int value
    * @preconditions    Valid month values - January to December.
    *                   Valid day values - 1 to 3
    *                   valid year values - 2014 to 2024
    *
    * @postconditions   The month, day and year of this object is 
    *           set to specified valid values.
    *
    * @throws       PizzaException when invalid data specified for
    *           month, day and year. 
    */
    
    public void setDate ( String month, int day, int year) 
    {
        setMonth(month);
        setDay(day);    
        setYear(year);
 
    }

    /**
    * Method :          setDate 
    * Purpose :         Mutator method for setting this object with 
    *                   specified month, day and year values.The month
    *                   specified here is in String. 
    *                   setDate(1, 1, 2015)  
    *
    * @param            month - int value  
    * @param            day - int value
    * @param            year - int value
    * @preconditions    Valid month values - 1 to 12.
    *                   Valid day values - 1 to 31
    *                   valid year values - 2014 to 2024
    *
    * @postconditions   The month, day and year of this object is 
    *                   set to specified valid values.
    *
    * @throws           PizzaException when invalid data specified for
    *                   month, day and year. 
    */
    
    
    public void setDate (int month, int day, int year) 
    {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    /**
    * Method  :         setMonth 
    * Purpose :         Mutator method for setting this object with 
    *                   specified month in String. 
    *                   setDate("January" )  
    *
    * @param            month - String value (case insensitive)
    * @preconditions    Valid month values - January to December.
    * @postconditions   The month is set to specified valid values.
    * @throws           PizzaException when invalid data specified for
    *                   month. 
    */
    
    public void setMonth ( String month ) 
    {
       try
       {
        if ( month == null)
            throw new PizzaException ("Error: Month cannot be null.");
        if (!(isMonthStringValid(month)))
        {
            throw new PizzaException ("Error: Invalid month provided");
        }
        else 
            this.month = getMonthInt(month);
        }catch( PizzaException pe)
        {
            System.out.println(pe.getMessage());
        }            
    }

    
    /**
    * Method  :         setMonth 
    * Purpose :         Mutator method for setting this object with 
    *                   specified month as int value. 
    * @param            month - int value 
    * @preconditions    Valid month values - 1 to 12.
    * @postconditions   The month is set to specified valid values.
    * @throws           PizzaException when invalid data specified for
    *                   month. 
    */
    
    public void setMonth (int month )
    {
        try
        {
            if ( month <= 0 )
                throw new PizzaException ("Error: Month cannot be null.");
            if (!(isMonthValid(month)))
            {
                throw new PizzaException ("Error: Invalid month provided");
            }
            else 
                this.month = month;
            
        }catch( PizzaException pe)
        {
            System.out.println(pe.getMessage());
        }
    }

    /**
    * Method  :         setDay 
    * Purpose :         Mutator method for setting this object with 
    *                   specified day as int value. 
    * @param            day - int value.
    * @preconditions    Valid days 1 to 31.
    * @postconditions   The day is set to specified valid value.
    * @throws           PizzaException when invalid data specified for
    *                   day. 
    */
    
    public void setDay (int day ) 
    {
        try
        {
            if  (! (isDayValid (this.month, day )))
            {
               throw new PizzaException("Error: Invalid day");
            }
            else
                this.day = day;  
        }catch( PizzaException pe)
        {
            System.out.println(pe.getMessage());
        }      
    }    
    

    /**
    * Method  :         setYear
    * Purpose :         Mutator method for setting this object with 
    *                   specified year as int value. 
    * @param            year - int value.
    * @preconditions    Valid year - 2014 to 2024.
    * @postconditions   The day is set to specified valid value.
    * @throws           PizzaException when invalid data specified for
    *                   day. 
    */
    
    public void setYear (int year ) 
    {
        try
        {
            if (! (isYearValid ( year ) ))
            {
                 throw new PizzaException("Error:: Invalid year");
            }
            else 
                this.year = year;
        }catch( PizzaException pe)
        {
            System.out.println(pe.getMessage());
        }
    }
     
    /**
    * Method :          getMonth
    * Purpose :         Accessor method to return the month value 
    *                   represented by this object.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          int value representing the month of this
    *                   object.
    *            
    */
    
    public int getMonth()
    {
        return this.month;
    }
    

    /**
    * Method :          getDay
    * Purpose :         Accessor method to return the day value 
    *                   represented by this object.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          int value representing the day of this
    *                   year.
    *            
    */

    public int getDay()
    {
        return this.day;
    }
    

    /**
    * Method :          getYear
    * Purpose :         Accessor method to return the year value 
    *                   represented by this object.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          int value representing the year of this
    *                   object.
    *            
    */
    public int getYear()
    {
        return this.year;
    }

    /**
    * Method :          getDate
    * Purpose :         Accessor method to return this  
    *                   Date object 
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          Date - this object   
    *            
    */
    public Date getDate() 
    {
        return new Date(this.month, this.day, this.year);
        
     }    

    /**
    * Method :          precedes
    * Purpose :         Checks if the date represented by this  
    *                   object precedes the specified object.
    *            
    * @param            other - Date object
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          boolean - true if this date object precedes 
    *                   specified object, false otherwise.
    *@throws            PizzaException when null object specified.
    *        
    */

    public boolean precedes ( Date other ) 
    {
        try
        {
            if ( other == null )
            throw new PizzaException("Error: Date cannot be null");
        
        }catch( PizzaException pe)
        {
            System.out.println(pe.getMessage());
        }
        
        return ((this.year < other.getYear()) || (this.year == other.getYear() 
             && this.month < other.getMonth()) || (this.year == other.getYear() 
             && this.month == other.getMonth() && this.day < other.getDay()));
        
    }
 
    /**
    * Method :          equals 
    * Purpose :         Checks if the date represented by this  
    *                   object is equal to the specified object.
    *            
    * @param            other - Date object
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          boolean - true if this date object is equal
    *                   to specified object, false otherwise
    *        
    */   
    public boolean equals ( Date other )
    {
        if ( other == null)
        {
            return false;
        }
        
        if ( ! ( other instanceof Date ))
            return false;
        
        return this.month == other.month &&
               this.day == other.day &&
               this.year == other.year;
    }

    /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object  
    *                   for printing in mm/dd/yyyy format. 
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   for printing in mm/dd/yyyy format.                             
    *            
    */
    
    public String toString()
    {
        return this.month + "/"+this.day+"/"+this.year;
    }

    /** private methods **/
    /**
    * Method :          isDayValid 
    * Purpose :         Validates if the day specified    
    *                   for the month of this object. 
    * 
    * @param            month - int value
    * @param            day - int value
    * @returns          boolean - true if day is valid, 
    *                   false otherwise                            
    *            
    */
    
    private boolean isDayValid (int month, int day )
    {
        boolean retVal = false;
        if ( month == 2 )
         {
           retVal =  (day >=1 && day <= 28);     
          }
        
        else if ( month == 1 ||  month == 3  ||  month == 5  ||
            month == 7 || month == 8 || month == 10 ||
            month == 12 )
       
            retVal =(day >=1 && day <= 31);            
        
        else if ( month == 4  ||  month == 6  || month == 9 || 
            month == 11 )
       
            retVal =(day >=1 && day <= 30);     
        
        return retVal;
    }
    
 
    /**
    * Method :          getMonthInt
    * Purpose :         Returns the numeric representation    
    *                   of the month in String format. 
    * 
    * @param            month - String value
    * @returns          int value of given month string 
    *            
    */
    private int getMonthInt(String month)
    {
        int retMonth = 0;
        try
        {
            if (!( isMonthStringValid(month) ) )
            throw new PizzaException("Invalid month");

        
        switch ( month.toLowerCase() )
        {
            case "january": retMonth = 1;
                            break;
            case "february": retMonth = 2;
                            break;                
            case "march": retMonth = 3;
                            break;
            case "april": retMonth = 4;
                            break;
            case "may": retMonth = 5;
                            break;
            case "june": retMonth = 6;
                            break;
            case "july": retMonth = 7;
                            break;
            case "august": retMonth = 8;
                            break;
            case "september": retMonth = 9;
                            break;
            case "october": retMonth = 10;
                            break;
            case "november": retMonth = 11;
                            break;
            case "december": retMonth = 12;
                            break;  
            default : throw new PizzaException("Error: Invalid month");
        }
        }catch( PizzaException pe)
        {
            System.out.println(pe.getMessage());
        }
        return retMonth;
    }
    
    /**
    * Method :          isMonthStringValid 
    * Purpose :         Validates the specified month    
    * 
    * @param            month - String value
    * @returns          boolean - true if month string
    *                   specified is valid, false otherwise.
    *            
    */

    private boolean isMonthStringValid (String month)
    {
        return (month.equalsIgnoreCase ("January" ) || 
                month.equalsIgnoreCase("February") || 
                month.equalsIgnoreCase("March") || 
                month.equalsIgnoreCase("April") ||
                month.equalsIgnoreCase("May") ||
                month.equalsIgnoreCase("June") ||
                month.equalsIgnoreCase("July") ||
                month.equalsIgnoreCase("August") ||
                month.equalsIgnoreCase("September") ||
                month.equalsIgnoreCase("October") ||
                month.equalsIgnoreCase("November") ||
                month.equalsIgnoreCase("December") );
    }

    /**
    * Method :          isMonthValid 
    * Purpose :         Validates the specified month    
    * 
    * @param            month - int value
    * @returns          boolean - true if month 
    *                   specified is valid, false otherwise.
    *            
    */
    
    private boolean isMonthValid (int month)
    {
        if ( month <= 0 || month > 12 )
            return false;
        else
            return true;
    }

    /**
    * Method :          isYearValid 
    * Purpose :         Validates the specified year
    * 
    * @param            month - int value
    * @returns          boolean - true if year 
    *                   specified is valid, false otherwise.
    *            
    */
    
    private boolean isYearValid ( int year )
    {
       // System.out.println("Year "+year);
        return ( year >= 1970 && year <= 2050 );
    }
    
    @Override
    public int compareTo(Object obj) 
    {
        if ( obj == null || ! (obj instanceof Date ))
            throw new RuntimeException ("Invalid Date object passed.");
            
        Date that = (Date) obj;
        
        if (this.equals (that))
            return 0;   
        else if (this.year < that.year) 
            return -1;
        else if ( this.year == that.year && this.month < that.month)
            return -1;
        else if (this.year == that.year && this.month == that.month && this.day < that.day)
            return -1;
        else 
             return 1;
    }
    
    public static void main(String[] args)
    {
      //  try{
            Calendar cal = Calendar.getInstance();
           
        int i = (cal.get(Calendar.YEAR));
       
       /*   }catch (PizzaException pe)
          {
              System.out.println(pe.getMessage());
            }
        */ 
    }
}

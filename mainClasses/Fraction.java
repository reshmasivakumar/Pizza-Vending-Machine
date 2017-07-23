package mainClasses;


/**
 * Fraction.java - Class representing Fraction object
 * 
 * @author Reshma Sivakumar  
 * @version  3.0 03/13/2016
 *
 * Description: This class provides the data and methods to store and process
 *               a Fraction object. A Fraction object consists of two integers
 *               to represent the numerator and denominator. Eg., 3/5
 *               A valid Fraction should not have a denominator of Zero.
 *
 */
 
public class Fraction implements Comparable
{
    private final int numerator;   //store numerator of fraction
    private final int denominator; //store denominator of fraction
    
   
    /**
    * Method :           Constructor with  arguments numerator and denominator.
    * Purpose :          Constructs a new Fraction object containing the 
    *                    numerator and denominator set to the specified inputs.
    * 
    * @param             numerator - integer value.
    * @param             denominator - integer value.
    * @preconditions     denominator should not be 0.
    * @postconditions    A new Fraction object is created with numerator
    *                    and denominator initialized to parameters passed.
    * @returns           A new Fraction object.
    * @throw             IllegalArgumentException -When denominator passed as 0.
    */   
    public Fraction (int numerator, int denominator)
    {
        if( denominator == 0 )  
            throw new IllegalArgumentException
                   ("Invalid fraction read! Denominator cannot be zero.");
    
        int[] reducedFrac = reduceFraction (numerator, denominator);
        this.numerator = reducedFrac[0]; 
        this.denominator = reducedFrac[1];
    }
    
    /**
    * Method :          Copy Constructor
    * Purpose :         Creates a copy of the specified Fraction object  
    *                   and sets the numerator and denominator of
    *                   this fraction with the numerator and denominator
    *                   of the other Fraction object
    * 
    * @param            other - Fraction object to compare
    * @preconditions    Fraction object cannot be null and must be
    *                   an instance of Fraction
    *          
    * @postconditions   A copy of Fraction object is created and set 
    *                   to this object with denominator and numerator
    *                   set to the specified  Money object.     
    * @throws           NullPointerException - if the specified 
    *                   object is null
    *                   ClassCastException - if the specified 
    *                   object is not of type Fraction.          
    *
    */
    public Fraction ( Fraction other )
    {    
       if (other == null)
            throw new NullPointerException
                    ("Object passed is null");
            
       if (! ( other instanceof Fraction ) ) 
            throw new ClassCastException
                    ("Object passed is not of type Fraction");
   
       Fraction temp = other;
       this.numerator = temp.getNumerator();
       this.denominator = temp.getDenominator();
    }
    
    /**
    * Method :          getNumerator
    * Purpose :         Return the value for numerator member variable.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          Integer data stored in numerator member variable.
    */
    public int getNumerator ()
    {
        return this.numerator; 
    }
  
    /**
    * Method :          getDenominator
    * Purpose :         Return the value for denominator member variable.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          Integer data stored in denominator member variable.
    */
    public int getDenominator ()
    {
       return this.denominator;
    }
    
    /**
    * Method :          Subtract
    * Purpose :         Return a fraction object with the numerator and
    *                   denominator of this Fraction object subtracted 
    *                   from the numerator and denominator of the specified
    *                   Fraction object
    * 
    * @param            other - Fraction object to subtract from.
    * @preconditions    Fraction object passed cannot be null and must
    *                   be an instance of Fraction.
    * @postconditions   Returns the subracted fraction object.
    * @returns          Fraction object which is a value after subtracting
    *                   the two fractions.
    * @throws           NullPointerException - if the specified 
    *                   object is null
    *                   ClassCastException - if the specified 
    *                   object is not of type Fraction.          
    */
    public Fraction subtract (Fraction other)  
    {
        if (other == null)
            throw new NullPointerException
                    ("Object passed is null");
            
        if (! ( other instanceof Fraction ) ) 
            throw new ClassCastException
                    ("Object passed is not of type Fraction");

        int num= (numerator * other.denominator) 
                        - (denominator * other.numerator);
        int denom = (denominator * other.denominator);    
        
 
        int[] reduced = reduceFraction ( num, denom );
        return new Fraction ( reduced[0], reduced[1] );
    }
    
    /**
    * Method :          toString
    * Purpose :         Return the internal representation of Fraction Object
    *                   in numerator/denominator form as String for printing.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          A String representation of the fraction object.
    */
    public String toString()
    {
       return getNumerator() + "/" + getDenominator ();  
    }
    
    /**
    * Method :          equals
    * Purpose :         To compare if the input Fraction object is equal to 
    *                   the internal Fraction object
    * 
    * @param            that - another Fraction object to be compared to.
    * @preconditions    None.
    * @postconditions   None.
    * @returns          true - if the input Fraction object is equal
    *                   false - otherwise
    *                   
    */
    public boolean equals ( Fraction that )
    {
        if ( that == null ) 
            return false;
            
        if (! ( that instanceof Fraction ) ) 
            return false;

        return numerator * that.denominator == denominator * that.numerator;
    }  
    
    /**
    * Method :          compareTo
    * Purpose :         Compares the Numerator and denominator of 
    *                   specified object with this object. 
    *                   
    * @param            object - Object of Fraction class to 
    *                   be compared.
    * @preconditions    Value passed must not be null and must
    *                   be an instance of Fraction object.
    * @postconditions   None.  
    * @returns          integer - a negative integer, zero, 
    *                   or a positive integer as this object 
    *                   is less than, equal to, or greater
    *                   than the specified object.                          
    *      
    * @throws           NullPointerException - if the specified 
    *                   object is null
    *                   ClassCastException - if the specified 
    *                   object is not of type Fraction.          
    */
   
    @Override 
    public int compareTo ( Object object )
    {
        Fraction other = (Fraction) object;
        if ( other == null ) 
           throw new NullPointerException("Object passed is null");
            
        if (! ( other instanceof Fraction ) ) 
            throw new ClassCastException
                    ("Object passed is not of type Fraction");

        if ( this.equals (other))
            return 0; 
        
        else
            return ((numerator * other.denominator) - 
                                (denominator * other.numerator));
    }
    
    /**
    * Method :          gcd
    * Purpose :         To find the Greatest Common Divisor of the numerator 
    *                   and denominator used to reduce the fraction.
    * 
    * @param            numerator - integer value.
    * @param            denominator - integer value.
    * @preconditions    numerator and denominator should contain valid data.
    * @postconditions   None.
    * @returns          The Greatest Common Divisor of the numerator and
    *                   denominator.
    */
    private int gcd ( int numerator, int denominator )
    {
        while ( denominator != 0 )
        {
                int temp = denominator;
                denominator = numerator % denominator;
                numerator = temp;
        }
        return numerator;
    }
    
    /**
    * Method :          reduceFraction
    * Purpose :         To convert the internal Fraction to its lowest 
    *                   terms using the gcd value of its numerator and
    *                   denominator.
    * 
    * @param            None.
    * @preconditions    numerator and denominator should contain valid data.
    * @postconditions   None.
    * @returns          The Greatest Common Divisor of the numerator and
    *                   denominator.
    */
    private int[] reduceFraction (int numerator, int denominator)
    {
        
        int[] retVal = new int[2];
        int gcdVal = gcd (numerator, denominator);
        if( denominator == 0 )  
            throw new IllegalArgumentException
                   ("Invalid fraction read! Denominator cannot be zero.");
        if (numerator > 0 ) 
            retVal[0] = numerator / gcdVal;
        retVal[1] = denominator / gcdVal;
        return retVal;
    }
}


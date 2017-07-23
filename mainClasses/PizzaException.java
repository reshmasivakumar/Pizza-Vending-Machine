package mainClasses;


/**
 * PizzaException.java: Custom Exception Class implementation.
 *
 * @Description : This PizzaException class extends from
 *                RuntimeException class. It has only 2 constructors,
 *                one default which displays a generic message
 *                and the displays the input string.
 *                This class is used for List class and its 
 *                subclasses.
 *              
               
 * 
 * @author:     Reshma
 * @version:    1.0 3/14/2016
 */

public class PizzaException extends RuntimeException
{
    /**
    * Method :          Default Constructor
    * Purpose :         Constructs an PizzaException object which
    *                   displays a generic default message.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    */   
    public PizzaException()
    {
        super ("Pizza Exception");
    }

    /**
    * Method :          Constructor
    * Purpose :         Constructs an PizzaException object which
    *                   displays the specified  message.
    * 
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    */  
    public PizzaException(String message)
    {
        super (message);
    }
}

package mainClasses;

/** 
 * PizzaComparable.java - Interface for Pizza  
 * 
 * Description: This interface extends Comparable and has the compareTo
 *              method to be overriden along with two other compareTo 
 *              methods. This interface will be used in the PizzaManager
 *              project and the three compareTo methods will be implemented
 *              in the Pizza class to compare Pizza object by size, price
 *              and calories.
 *
 *              
 *     Author: Rob Nash           
 */
 
public interface PizzaComparable extends Comparable {  //Example of interface inheritance

    /**
    * Method :          compareTo
    * Purpose :         Comparable Interface method to be overriden in the 
    *                   implementation class. This method will be implemented 
    *                   in the Pizza class to compare by price of Pizza.
    *                   
    * @param            o - Object to be compared. For Pizza Project this will 
    *                       be Pizza object type.
    *                   
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          integer - a negative integer, zero, 
    *                   or a positive integer as this object 
    *                   is less than, equal to, or greater
    *                   than the specified object.                             
    *       
    */   

    @Override
    public int compareTo(Object o);             //a.k.a compareToByPrice

    /**
    * Method :          compareToBySize
    * Purpose :         Method to be overriden in the implementation
    *                   class. This method will be implemented in the Pizza
    *                   class to compare by remaining area (size) of Pizza.
    *                   
    * @param            o - Object to be compared. For Pizza Project this will 
    *                       be Pizza object type.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          integer - a negative integer, zero, 
    *                   or a positive integer as this object 
    *                   is less than, equal to, or greater
    *                   than the specified object.                          
    *       
    */      

    public int compareToBySize(Object o);       //a.k.a. compareToByAreaLeft

    /**
    * Method :          compareToByCalories
    * Purpose :         Method to be overriden in the implementation
    * 					class. This method will be implemented in the Pizza
	*					class to compare by calories of Pizza.
    *                   
    * @param            o - Object to be compared. For Pizza Project this will 
	*						be Pizza object type.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          integer - a negative integer, zero, 
    *                   or a positive integer as this object 
    *                   is less than, equal to, or greater
    *                   than the specified object.                          
    *       
    */	 	
    public int compareToByCalories(Object o);   
    
}

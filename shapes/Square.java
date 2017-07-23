package shapes;

import mainClasses.PizzaException;

/**
 * Square Class:Class respresenting Square object. 
 * 
 * @author Reshma Sivakumar
 * @version 2.0 3/14/2016
 * 
 * Description: This class is inherited from it's parent class Shape.
 *              The getArea () and draw () methods of Shape class are
 *              overriden with functionality specific to Square class.
 */

public class Square extends Shape
{
	/** Instance Variables for Square Class*/
  private double sideLength;
  private String shape;
  
	/**
	* Method :          Constructor
	* Purpose :         Default constructor for the Square class  
	*                   that initializes the super class Shape's 
	*                   instance variable by calling the parent 
						Shape class constructor and initializes
						the instance variables of Square class
						to zero.

	* @param           none 
	* @preconditions    none.
	* @postconditions   A new Square object is created with the x and
	*                   y coordinates , sideLength and shape initialized. 
	*/  
  public Square()
  {
      super ( 0, 0);
      this.sideLength = 0;
      this.shape = "[]";
  }
  
   /**
    * Method :          Constructor
    * Purpose :         Constructor for the Square class takes 
    *                   x and y coordinates as parameters and
    *                   calls the parent Shape class constructor.
						Sets the shape instance
						variable to the defaul square shape: "[]"
    *                   
    * @param            nx - int value for the x coordinate. 
    * @param            ny - int value for the y coordinate.
    * @preconditions    none.
    * @postconditions   A new Square object is created with the x and
    *                   y coordinates initialized to specified values. 
    */  
  public Square(int nx, int ny)
  {
    super ( nx, ny );
    this.shape = "[]";
  }
  
   /**
    * Method :          Constructor
    * Purpose :         Constructor for the Square class takes 
    *                   x and y coordinates and sideLength as parameters and
    *                   calls the parent Shape class constructor and sets 
    *                   the values to the specified values and sets sideLength
						to the specified sideLength. Sets the shape instance
						variable to the defaul square shape: "[]"
    * @param            nx - int value for the x coordinate. 
    * @param            ny - int value for the y coordinate.
	* @param            sl - int value for the sideLength of Square
    * @preconditions    none.
    * @postconditions   A new Square object is created with the x and
    *                   y coordinates and sideLength initialized to specified values. 
    */  
  public Square(int nx, int ny, int sl)
  {
    super ( nx, ny );
    this.sideLength = sl;
    this.shape = "[]";
  }
    /**
    * Method :          Copy Constructor
    * Purpose :         Creates a copy of the specified Square object  
    *                   by calling the super constructor for setting
    *                   instance variables of super class, calls
    *                   setSideLength method to set the sideLength and
					    calls setShape to set the shape of the Square object.
    * 
    * @param            other - Square object to compare
    * @preconditions    Square object cannot be null.         
    *          
    * @postconditions   A copy of Square object is created and set 
    *                   to this object with sideLength and shape set to the
    *                   specified  Square object.               
    */
  public Square ( Square other )
  {
      super ( other.getX(), other.getY() );
      setSideLength ( other.getSideLength() );
      setShape( other.getShape() );
  }
  
   /**
    * Method  :         draw
    * Purpose :         This method prints the shape of this Square object.
    *                       
    * @param            none.
    * @preconditions    none.
    * @postconditions   none.
    *  
    */
  public void draw()
  {
    System.out.println(this.shape);
  }
  
   /**
    * Method :          getSideLength
    * Purpose :         Accessor method to return the side Length value 
    *                   represented by this object.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          double value representing the sideLength of this
    *                   object.
    *            
    */ 
  public double getSideLength()
  {
      return this.sideLength;
  }
  
  /**
    * Method :          getWidth
    * Purpose :         Accessor method to return the super class
    *                   x coordinate by calling the getX() method
						of the super class.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          int value representing the x coordinate 
    *            
    */ 
  public int getWidth()
  {
      return super.getX();
  }
  
  /**
    * Method :          getHeight
    * Purpose :         Accessor method to return the super class
    *                   y coordinate by calling the getY() method
						of the super class.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          int value representing the y coordinate 
    *            
    */ 
  public int getHeight()
  {
      return super.getY();
  }

  /**
    * Method :          getShape
    * Purpose :         Accessor method to return the shape figure
	*					of this object.
    *            
    * @param            None.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          String value representing the shape figure 
    *            
    */   
  public String getShape ()
  {
      return this.shape;
  }
 
  /**
    * Method :          setSideLength
    * Purpose :         Mutator method to set the sidelength
	*					of this object.
    *            
    * @param            s1 - double value representing sidelength.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          None 
    *            
    */     
  public void setSideLength(double sl)
  {
      this.sideLength = sl;
  }

	/**
    * Method :          setShape
    * Purpose :         Mutator method to set the shape figure
	*					of this object to specified object.
    *            
    * @param            shape - String value representing shape.
    * @preconditions    None.
    * @postconditions   None.
    *
    * @returns          None 
    *            
    */    
  public void setShape ( String shape )
  {
      this.shape = shape;
  }
  
	/**
	* Method :          getArea
	* Purpose :         Accessor method to get Area
	*					of this object to specified object.
	*            
	* @param            None.
	* @preconditions    None.
	* @postconditions   None.
	*
	* @returns          double value representing area of this shape 
	*            
	*/    
  public double getArea()
  {
    double area = super.getX() * super.getY(); 
    return area;  
  }
  
	/**
	* Method :          equals
	* Purpose :         Method to check if this object is equal to input.
	*            
	* @param            None.
	* @preconditions    None.
	* @postconditions   None.
	*
	* @returns          true - if equal, false otherwise 
	*            
	*/      
   public boolean equals(Square that)
   {
    if(that == null) {
        return false;
    }
    
       if (! (that instanceof Square)) { 
        return false;
    }
   
    return super.getX() == that.getX() &&
           super.getY() == that.getY() && 
           this.sideLength == that.sideLength &&
           this.shape.equals(that.shape);
    
   }
   
   /**
    * Method :          clone
    * Purpose :         Overridden clone method to create
    *                   a copy of this Square object
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   Creates a deep copy of this object to
    *                   a new Square object .  
    * @returns          Object - Newly created Square Object                      
    *            
    */
   
    @Override
    public Object clone()
    {
      return new Square(this);
    }     

   /**
    * Method :          toString
    * Purpose :         Returns the String representation of this object.  
    *                   
    * 
    * @param            None.
    * @preconditions    None.       
    * @postconditions   None.  
    * @returns          String representation of this object  
    *                   .                          
    *            
    */    
    public String toString()
    {
        return "Square";
    }
}

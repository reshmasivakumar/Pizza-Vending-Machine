package mainClasses;

/** 
 * Stack.java: Class Stack implementation extending ArrayList .
 *
 * @Description : This class provides a LIFO implementation of the Stack by 
 *                inheriting from a List class. The Stack operations like
 *                push and pop are implemented by calling the List methods,
 *                insert and remove. The List is not an abstract 
 *                super class but the inherited "copies" of insert ,append
 *                remove and delete methods are overriden with versions that
 *                call the Stack push and pop methods. This ensures that Stack
 *                objects use only push and pop methods to insert and remove
 *                objects in the Stack.
 *              
 * Class Invariants:
 *              - Cannot pop from empty stack.               
 * 
 * @author:     Reshma Sivakumar
 * @ version:   2 3/13/2016
 */

public class Stack<Comparable> extends ArrayList<Comparable>
{
   /** No Instance variables - only inherited instance variables**/

    /**
    * Method :          push
    * Purpose :         This method is called to push an Object into  
    *                   the Stack. The method calls the insert method
    *                   of the List super class.   Stack top is assumed
    *                   to be at the end position of the list.
    * 
    * @param            item - Object type
    * @preconditions    None.
    * @postconditions   The specified object will be pushed to the Stack
    *                   at position size() of the List and will be the  
    *                   top element of the Stack.
    * 
    */     
   public void push ( Comparable item ) throws PizzaException
   {
       // Stack top is assumed to be at the size() position list
       super.insert ( item, super.size () );
   }
   

    /**
    * Method :          pop
    * Purpose :         This method is called to pop an Object from  
    *                   the Stack. The method calls the remove method
    *                   of the List super class.   Stack top is assumed
    *                   to be at the end position of the list.
    * 
    * @param            None.
    * @returns          Returns the item object that is being popped.
    * @preconditions    None.
    * @postconditions   The specified object will be popped from the Stack
    *                   at position size() of the List. The next Mode 
    *                   in the List of the popped Node will be considered
    *                     as top element of Stack.
    * @throws           LinkedListExecption -  WHen trying to pop from
    *                   empty stack.
    * 
    */         
    public Comparable pop () throws PizzaException 
   {
       Comparable retObj = null;
       //retObj = (Comparable) super.remove ( 0);
       retObj = (Comparable) super.remove ( super.size()-1);
        return retObj;
   }

   /** Overriden List Super class methods **/
   
    /**
    * Method :          insert
    * Purpose :         Overriden List class method which calls the push  
    *                   operation on the Stack.
    * 
    * @param            item - Object type
    * @param            index - int
    * @preconditions    None.
    * @postconditions   The specified object will be pushed to the Stack
    *                   at position size() of the List and will be the  
    *                   top element of the Stack.
    * 
    */     
   @Override
   public void insert(Comparable item, int index)
   {
       try
       {
           push ( item );
       }catch (PizzaException pe )
       {
           System.out.println(pe.getMessage());
       }
   }

   
    /**
    * Method :          append
    * Purpose :         Overriden List class method which calls the push  
    *                   operation on the Stack.
    * 
    * @param            item - Object type
    * @preconditions    None.
    * @postconditions   The specified object will be pushed to the Stack
    *                   at position size() of the List and will be the  
    *                   top element of the Stack.
    * 
    */     
    @Override 
    public void add ( Comparable item ) 
    {
       try
       {
           push ( item );
       }catch (PizzaException pe )
       {
           System.out.println(pe.getMessage());
       }
   }

    /**
    * Method :          remove
    * Purpose :         Overriden List class method which calls the pop  
    *                   operation on the Stack.
    * 
    * @param            index - int.
    * @returns          Returns the item object that is being popped.
    * @preconditions    None.
    * @postconditions   The specified object will be popped from the Stack
    *                   at position size() of the List. The next Mode 
    *                   in the List of the popped Node will be considered
    *                     as top element of Stack.
    * @throws           LinkedListExecption -  WHen trying to pop from
    *                   empty stack.
    * 
    */            
   @Override
   public Comparable remove ( int index ) throws PizzaException
   {
       return pop();
   }
   
   public static void main(String[] args)
   {
       try
      {
          ArrayList<Pizza> s =  new ArrayList<Pizza>();
          Stack<Pizza> s1 =  new Stack<Pizza>();
          for (int i=0; i<2; i++)
          {
              Pizza p = new Pizza();
              //s.add(p);
             s1.push(p);
             System.out.println("push "+p);
            }
            //System.out.println(s1.toString());   
           while(!(s1.isEmpty()))
          {
             //
             
            // System.out.println(s.remove(0));
             System.out.println(s1.pop());
             //System.out.println(s1.size());
              
            }
          
     
      
    }catch (PizzaException pe)
    {
        System.out.println(pe.getMessage());
    }
    }
}
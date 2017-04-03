//Arpita Nag
//APCS2 pd03
//HW #100002a: We Got a Little Ol’ Convoy...
//2017-3-12
/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 *****************************************************/

public class DLLNode<T> 
{

    private T _cargo;    //cargo may only be of type String
    private DLLNode _nextNode; //pointer to next LLNode
    private DLLNode _prevNode; //pointer to previous

    // constructor -- initializes instance vars
    public DLLNode( T value, DLLNode prev, DLLNode next) 
    {
        _cargo = value;
        _nextNode = next;
        _prevNode = prev;
    }


    //--------------v  ACCESSORS  v--------------
    public T getValue() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }
    
    public DLLNode getPrev() { return _prevNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public T setCargo( T newCargo ) 
    {
        T replaced = _cargo;
        _cargo = newCargo;
        return replaced;
    }

    public DLLNode setNext( DLLNode newNext ) 
    {
        DLLNode replaced = _nextNode;
        _nextNode = newNext;
        return replaced;
    }
    
    public DLLNode setPrev( DLLNode newPrev ) 
    {
        DLLNode replaced = _prevNode;
        _prevNode = newPrev;
        return replaced;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() { return _cargo.toString(); }



    //end main

}//end class LLNode

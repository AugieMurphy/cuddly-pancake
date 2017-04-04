import java.util.NoSuchElementException;

public class LLDeque<T> implements Deque<T> {
    private DLLNode<T> _front;
    private DLLNode<T> _end = _front;
    private int size;

    // default constructor creates an empty queue
    public LLDeque(){
	_front = _end = null;
    }

    // Means of adding an element to the end of the deque
    @Override
    public boolean add(T x) {
	addLast(x);
	return true;
    }

    // Means of adding an element to the front of the deque
    @Override
    public void addFirst(T x) {
	if ( isEmpty() ) {
	    _front = _end = new DLLNode<>(x, null, null);
	    return;
	}

	_front = new DLLNode<>(x, null, _front);
	_front.getNext().setPrev(_front);
    
    }
    
    // Means of adding an element to the end of the deque
    @Override
    public void addLast(T x) {
	if ( isEmpty() ) {
	    _front = _end = new DLLNode<>(x, null, null);
	    return;
	}

	_end = new DLLNode<>(x, _end, null);
	_end.getPrev().setNext(_end);
    }

    // Means of removing an element from the front of the deque
    @Override
    public T remove() {
	   return removeFirst();
    }

    // Means of removing an element from the front of the deque
    @Override
    public T removeFirst() {
	if ( isEmpty() ) {
	    throw new NoSuchElementException("The queue is empty");
	}

	T tmp = _front.getValue();
	if(_front.getNext() != null){
        _front = _front.getNext();
        _front.setPrev(null);}
        
    else {_front = _end = null;}
	
	return tmp;
    }

    // Means of removing an element from the end of the deque
    // Assumes deque is not empty (and throws an exception is it is)
    @Override
    public T removeLast() {
	if ( isEmpty() ) {
	    throw new NoSuchElementException("The queue is empty");
	}

	T tmp = _end.getValue();
    if(_end.getPrev() != null){
        _end = _end.getPrev();
	   _end.setNext(null);
    }
	else {_front = _end = null;}
	return tmp;
    }

    // Means of removing an element from the front of the deque
    // Handles possibility of an empty deque (returns null)
    @Override
    public T poll() {
	try {
	    return removeFirst();
	} catch ( NoSuchElementException e ) {
	    return null;
	}
    }

    // Returns true if there are no elements in the deque
    @Override
    public boolean isEmpty() {
	return _front == null ;
    }

    // Returns the first element of the deque without removing it
    @Override
    public T peek() {
	return peekFirst();
    }

    // Returns the first element of the deque without removing it
    @Override
    public T peekFirst() {
	if ( isEmpty() ) {
	    return null;
	}

	return _front.getValue();
    }

    // Returns the first element of the deque without removing it
    @Override
    public T peekLast() {
	if ( isEmpty() ) {
	    return null;
	}

	return _end.getValue();
    }
    
    @Override
    public String toString() 
    {   String retStr = "HEAD -> ";
        if(isEmpty()){
            return retStr + "TAIL";
        }
        DLLNode tmp = _front;
        while(tmp.getNext() != null){
            retStr += ( tmp.getValue() + " -> ");
            tmp = tmp.getNext();
        }
        retStr += (tmp.getValue() + " -> TAIL");
        return retStr;
    }

    public static void main( String[] args ){
       LLDeque<String> ship = new LLDeque<String>();

	   System.out.println("\nnow adding to the front"); 
	   ship.addFirst("James");
	   ship.addFirst("Todd");
       System.out.println("\nnow adding to the end"); 
	   ship.addLast("Smith");
       ship.addLast("William");
       System.out.println("\nnow adding to the front"); 
       ship.addFirst("Joe");
       ship.addLast("Ed");
        
	   System.out.println("\nnow testing toString()..."); 
	   System.out.println( ship ); // Should be Joe -> Todd -> James -> Smith -> William -> Ed

	   System.out.println("\nnow removing from the front"); 
	   System.out.println(ship.removeFirst()); //Joe
	   System.out.println(ship.removeFirst()); //Todd
       
       System.out.println( ship ); // Should be James -> Smith -> William -> Ed
      
	   System.out.println(ship.removeLast()); //Ed
        
       System.out.println( ship ); // Should be James -> Smith -> William 
    
       System.out.println("peek front: \n" + ship.peekFirst()); //James
       System.out.println("remove front: \n" + ship.removeFirst()); //James
       System.out.println("peek tail: \n" + ship.peekLast()); //William
       System.out.println("remove tail: \n" + ship.removeLast()); //William
       System.out.println(ship.removeLast());
      
       System.out.println( ship );
        
       System.out.println("\nnow testing auxillary methods");
       
       ship.add("Washington");
       ship.add("Adams");
       ship.add("Jefferson");
       System.out.println(ship);
       ship.peek(); //Washington
       ship.remove(); 
       ship.peek(); //Adams
       ship.remove();
       ship.remove();
       System.out.println(ship);
       System.out.println(ship.poll()); //Should be an null
        
	   System.out.println("\nRemoving from empty queue should yield error..."); 
	   System.out.println( ship.removeFirst() );
    }
}

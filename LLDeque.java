import java.util.NoSuchElementException;

public class LLDeque<T> implements Deque<T> {
    private DLLNode<T> _front;
    private DLLNode<T> _end = _front;
    //private int size;

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
	    throw new NoSuchElementException();
	}

	T tmp = _front.getValue();
	_front = _front.getNext();
	_front.setPrev(null);

	return tmp;
    }

    // Means of removing an element from the end of the deque
    // Assumes deque is not empty (and throws an exception is it is)
    @Override
    public T removeLast() {
	if ( isEmpty() ) {
	    throw new NoSuchElementException();
	}

	T tmp = _end.getValue();
	_end = _end.getPrev();
	_end.setNext(null);

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
	return _front == null;
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
    public static void main( String[] args ){
    }
}

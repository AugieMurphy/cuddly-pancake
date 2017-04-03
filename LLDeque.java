import java.util.NoSuchElementException;

public class LLDeque<T> implements Deque<T> {
	private DLLNode<T> _front;
	private DLLNode<T> _end = _front;
	private int size;

	@Override
	public boolean isEmpty() {
		return size <= 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public T peek() {
		return peekFirst();
	}

	@Override
	public T peekFirst() {
		if ( isEmpty() ) {
			return null;
		}

		return _front.getValue();
	}


	@Override
	public T peekLast() {
		if ( isEmpty() ) {
			return null;
		}

		return _end.getValue();
	}

	@Override
	public boolean add(T x) {
		addLast(x);
		return true;
	}

	@Override
	public void addFirst(T x) {
		if ( isEmpty() ) {
			_front = _end = new DLLNode<>(x, null, null);
			return;
		}

		_front = new DLLNode<>(x, null, _front);
		_front.getNext().setPrev(_front);
	}

	@Override
	public void addLast(T x) {
		if ( isEmpty() ) {
			_front = _end = new DLLNode<>(x, null, null);
			return;
		}

		_end = new DLLNode<>(x, _end, null);
		_end.getPrev().setNext(_end);
	}

	@Override
	public T remove() {
		return removeFirst();
	}

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

	@Override
	public T poll() {
		try {
			return removeFirst();
		} catch ( NoSuchElementException e ) {
			return null;
		}
	}
}

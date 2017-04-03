import java.util.Iterator;

public interface Deque<T> extends Queue<T> {
	public void addFirst(T x);
	public void addLast(T x);

	public T removeFirst();
	public T removeLast();

	public T peekFirst();
	public T peekLast();

	// public Iterator<T> iterator();
	public int size();
	public boolean isEmpty();
}


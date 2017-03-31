import java.util.Queue;
import java.util.Iterator;

public interface Deque<T> extends Queue<T> {
	public void addFirst();
	public void addLast();

	public T removeFirst();
	public T removeLast();

	public T peekFirst();
	public T peekLast();

	public Iterator<T> iterator();
	public int size();
	public boolean isEmpty();
}


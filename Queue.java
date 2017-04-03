public interface Queue<T> {
	public boolean add(T e);
	public T peek();
	public T poll();
	public T remove();
}


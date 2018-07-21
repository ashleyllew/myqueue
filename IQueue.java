public interface IQueue {
	void enqueue(Object element) throws QueueFullException;
	Object dequeue() throws EmptyQueueException;
	Object front() throws EmptyQueueException;
	int size();
	boolean isEmpty();
	void clear();
}
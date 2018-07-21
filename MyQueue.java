
public class MyQueue implements IQueue {

	public Object[] elements;
	public int front;
	public int currentSize;

	public MyQueue (int max_size) {
		elements = new Object [max_size];
		front = 0;
		currentSize = 0;
	}
	
	@Override
	public void enqueue(Object element) throws QueueFullException {
		if (currentSize < elements.length) {
			elements[(front + currentSize++) % elements.length] = element;
		}
		else {
			throw new QueueFullException("This queue is full, cannot enqueue any more elements.");
		}
	}

	@Override
	public Object dequeue() throws EmptyQueueException {
		if (!isEmpty()) {
			currentSize--;
			return elements[front++ % elements.length];
		}
		else {
			throw new EmptyQueueException("This queue is empty, cannot remove from empty queue.");
		}
	}

	@Override
	public Object front() throws EmptyQueueException {
		if (!isEmpty()) {
			return elements[front];			
		}
		else {
			throw new EmptyQueueException("This queue is empty, cannot get top element from empty queue.");
		}
	}

	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public boolean isEmpty() {
		if (currentSize == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void clear() {
		int j = currentSize;
		for (int i = front; i < j; i++) {
			elements[i] = null;
			currentSize--;
		}
	}
	
}

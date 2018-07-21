import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestingMyQueue {

	@Test
	public void initialQueueSize() {
		MyQueue queue = new MyQueue(10);
		assertEquals(queue.currentSize, 0);
	}
	
	@Test
	public void addOneElement() throws QueueFullException {
		MyQueue queue = new MyQueue(10);
		Object element = new Object();
		queue.enqueue(element);
		assertEquals(queue.currentSize, 1);
	}
	
	@Test
	public void enqueueDequeue() throws EmptyQueueException, QueueFullException {
		MyQueue queue = new MyQueue(10);
		Object element = new Object();
		queue.enqueue(element);
		queue.dequeue();
		assertEquals(queue.currentSize, 0);
	}
	
	@Test(expected = EmptyQueueException.class)
	public void dequeueEmptyList() throws EmptyQueueException {
		MyQueue queue = new MyQueue(10);
		queue.dequeue();
	}
	
	@Test
	public void enqueueTwoElements() throws QueueFullException {
		MyQueue queue = new MyQueue(10);
		Object element = new Object();
		Object element2 = new Object();
		queue.enqueue(element);
		queue.enqueue(element2);
		assertEquals(queue.currentSize, 2);
	}
	
	@Test
	public void clearQueue() throws QueueFullException {
		MyQueue queue = new MyQueue(10);
		Object element = new Object();
		Object element2 = new Object();
		queue.enqueue(element);
		queue.enqueue(element2);
		assertEquals(queue.currentSize, 2);
		queue.clear();
		assertEquals(queue.currentSize, 0);
	}

	@Test
	public void checkIsEmpty() {
		MyQueue queue = new MyQueue(10);
		assertEquals(queue.isEmpty(), true);
	}
	
	@Test
	public void getFrontElement() throws QueueFullException, EmptyQueueException {
		MyQueue queue = new MyQueue(10);
		Object element = new Object();
		queue.enqueue(element);
		Object front = queue.front();
		assertEquals(front, element);
	}
	
	@Test (expected = EmptyQueueException.class)
	public void getFrontElementEmptyQueue() throws EmptyQueueException {
		MyQueue queue = new MyQueue(10);
		queue.front();
	}


}

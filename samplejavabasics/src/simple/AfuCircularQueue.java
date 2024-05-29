package simple;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AfuCircularQueue {

	public static void main(String[] args) throws Exception {
		
		/*
		 * Normal Queue may take O(N), for adding new element at end 
		 * after deleting first element if it's full
		 * 
		 * if 10 elements are their and size is full, after deleting first, 
		 * we need move next elements to forward
		 * this is O(N) operation
		 * 
		 * instead, we can use circular Queue
		 * it'll just add it at first and point it out as last element
		 * like indexes of this queue will differ by adding/deleting
		 * 
		 * let's say 10 elements are there and size is 10
		 * first =  1, last = 10
		 * dequeue will delete 1
		 * enqueue will add 11 at first position
		 * 
		 * but circular queue will consider, 1 as 0th index and 0 as 9th index
		 * in this way, first = 2, last = 11
		 */
		CircularQueue<Integer> array = new CircularQueue<>(Integer.class);
		System.out.println(array);
		
		array.enqueue(1);
		System.out.println(array);
		
		for(int i=2; i<10; i++)
			array.enqueue(i);
		System.out.println(array);
		
		array.dequeue();
		System.out.println(array);
		
		array.dequeue();
		System.out.println(array);
		
		array.enqueue(88);
		System.out.println(array);
		
		array.enqueue(657);
		System.out.println(array);
		
		array.enqueue(658);
		System.out.println(array);
	}
}

class CircularQueue<T> {

	private static final int MAX_SIZE = 10;
	private T[] array;
	private int frontIndex = -1;
	private int rearIndex = -1;
	
	@SuppressWarnings("unchecked")
	public CircularQueue(Class<T> clazz) {
		array = (T[]) Array.newInstance(clazz, MAX_SIZE);
	}
	
	public boolean isEmpty() {
		return frontIndex == -1 && rearIndex == -1;
	}
	
	// if rearIndex's next = frontIndex, then it's full
	public boolean isFull() {
		int nextIndex = (rearIndex + 1) % array.length;
		return nextIndex == frontIndex;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append(Arrays.toString(array));
		sb.append("\nFront: " + frontIndex + " Rear: " + rearIndex);
		return sb.toString();
	}

	public void enqueue(T data) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException("Queue is full, cannot add elements");
		}
		rearIndex = (rearIndex + 1) % array.length; // i++, after 10, 10++ will be 0(if space is available)
		array[rearIndex] = data; // setting data
		
		// If the queue was previously empty both the front
		// and the rear index point to the same element
		if (frontIndex == -1) {
			frontIndex = rearIndex; // first time operation only, adding to 0th index
		}
	}

	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException("Queue is empty, elements cannot be dequeued");
		}
		T data = array[frontIndex];
		if (frontIndex == rearIndex) { // means only 1 element is there
			array[frontIndex] = null;
			frontIndex = -1;
			rearIndex = -1;
		} else {
			array[frontIndex] = null;
			frontIndex = (frontIndex + 1) % array.length; // i++, after 10, 10++ will be 0(if space is available)
		}		
		return data;
	}

	public T peek() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException("Queue is empty, elements cannot be dequeued");
		}
		return array[frontIndex];
	}
}

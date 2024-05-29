package simple;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AftQueueUsingArray {

	public static void main(String[] args) throws QueueOverflowException, QueueUnderflowException {
		
		QueueUsingArray<Integer> array = new QueueUsingArray<>(Integer.class);
		System.out.println(array);
		
		array.enqueue(1);
		System.out.println(array);
		
		for(int i=2; i<10; i++)
			array.enqueue(i);
		System.out.println(array);
		
		array.dequeue();
		System.out.println(array);
		
		array.enqueue(88);
		System.out.println(array);
		
		array.enqueue(657);
		System.out.println(array);
	}
}

class QueueUsingArray<T> {

	private static final int MAX_SIZE = 10;
	private T[] array;
	// These below 2 are most important to keep track
	private int frontIndex = -1;
	private int rearIndex = -1;
	
	@SuppressWarnings("unchecked")
	public QueueUsingArray(Class<T> clazz) {
		array = (T[]) Array.newInstance(clazz, MAX_SIZE);
	}
	
	public boolean isEmpty() {
		return frontIndex == -1 && rearIndex == -1;
	}
	
	public boolean isFull() {
		return frontIndex == 0 && rearIndex == MAX_SIZE - 1;
	}

	public int size() {
		if (isEmpty()) {
			return 0;
		}
		return rearIndex - frontIndex + 1;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();	
		sb.append(Arrays.toString(array));
		sb.append("\nFront: " + frontIndex + " Rear: " + rearIndex);
		sb.append("\n");
		return sb.toString();
	}

	public void enqueue(T data) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException("Queue is full, cannot add elements");
		}
		if (isEmpty()) {
			array[0] = data; // adding to first index
			frontIndex = 0;
			rearIndex = 0;
			return;
		}
		
		// If there is space at the end of the array, just enqueue at the end
		// If there's a space at beginning, don't add at beginning, follow below block
		if (rearIndex < MAX_SIZE -1) {
			array[++rearIndex] = data;
			return;
		}
		
		/*
		 * At this point rearIndex == MAX_SIZE - 1,
		 * but still have some space at , 
		 * maybe due to dequeue(deleting first few elements)
		 * in this case, we need to set all back elements to set forward, 
		 * like a[0] == a[1], a[1] == a[2], etc 
		 * so that we can add new element at end, if there's no space at end
		 */ 
		int copyIndex = 0;
		for (int i = frontIndex; i <= rearIndex ; i++) {
			array[copyIndex] = array[i]; // a[0] == a[1]
			copyIndex++; // 0++, in the for loop - 1++ will happen
		}
		// copy index will be pointing at rear empty space
		array[copyIndex] = data;
		// front index will be pointing at first occupied space
		frontIndex = 0;
		rearIndex = copyIndex; // setting rear empty space to rear index
	}

	
	public T dequeue() throws QueueUnderflowException {
		
		if (isEmpty()) {
			throw new QueueUnderflowException("Queue is empty, elements cannot be dequeued");
		}
		
		T data = array[frontIndex];
		if (frontIndex == rearIndex) {
			frontIndex = -1;
			rearIndex = -1;
		} else {
			/*
			 * doesn't really matter below line, 
			 * as front index will point from next element,
			 * considering that is the start
			 */
			array[frontIndex] = null; 
			frontIndex++;
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


class QueueOverflowException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public QueueOverflowException(String message) {
		super(message);
	}
}

class QueueUnderflowException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public QueueUnderflowException(String message) {
		super(message);
	}
}

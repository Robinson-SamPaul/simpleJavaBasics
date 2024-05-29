package simple;

import java.util.Arrays;

public class AfrStackUsingArray {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		
		StackUsingArray<Integer> array = new StackUsingArray<>();
		System.out.println(array);
		
		array.push(0);
		System.out.println(array);
		
		for(int i=1; i<10; i++) {
			array.push(i);
		}
		System.out.println(array);
		
		try {
			array.push(10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		int before = array.size();
		array.pop(); // it'll not remove, instead it'll dereference it
		int after = array.size();
		System.out.println(array); // still 9 is there, after popping out
		System.out.println("Before popping = " + before + " After popping = " + after); // but size is 9, rather than 10
		array.push(100); // as size is 9, we can still push 1 more
		System.out.println(array); // instead of throwing SOF exception, it works fine
	}

}

class StackUsingArray<T> {

	private static final int MAX_SIZE = 10; // array needs to have certain size, linked list way is better

	// private T[] array; // can't create array with GenericType "new T[]", will throw CTE
	private Object[] array;
	private int topIndex = -1;
	
	public StackUsingArray() {
		// array = (T[]) new Object[MAX_SIZE]; // this can be done, instead of "new T[]"
		array = new Object[MAX_SIZE];
	}
	
	public boolean isEmpty() {
		return topIndex == -1;
	}
	
	public boolean isFull() {
		return topIndex == MAX_SIZE - 1;
	}

	public int size() {
		return topIndex + 1;
	}
	
	@Override
	public String toString() {
		
		return Arrays.toString(array);
	}

	public void push(T element) throws StackOverflowException {

		if (topIndex == MAX_SIZE - 1) {
			throw new StackOverflowException("Stack full, cannot add element: " + element);
		}
		
		array[++topIndex] = element;
	}

	// The pop method removes and returns the top(last) element of the stack
	public T pop() throws StackUnderflowException {

		if (topIndex == -1) {
			throw new StackUnderflowException("Stack empty, cannot pop element");
		}
		
		@SuppressWarnings("unchecked")
		T topElement = (T) array[topIndex];
		
		topIndex--;
		
		return topElement;
	}

	// The peek method returns the top(last) element of the stack without removing it.
	public T peek() throws StackUnderflowException {

		if (topIndex == -1) {
			throw new StackUnderflowException("Stack empty, cannot peek");
		}
		
		@SuppressWarnings("unchecked")
		T topElement = (T) array[topIndex];
		
		return topElement;
	}
	
}


class StackOverflowException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public StackOverflowException(String message) {
		super(message);
	}

}

class StackUnderflowException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public StackUnderflowException(String message) {
		super(message);
	}

}

package simple;

import java.lang.reflect.Array;
import java.util.Arrays;

abstract class Heap<T extends Comparable<T>> {

	private static int MAX_SIZE = 10;
	private T[] array;	
	private int count = 0;

	/*
	 * Using Array.newInstance(clazz, MAX_SIZE) is the preferred method because 
	 * it ensures that the array is of the correct type and aligns with Java's best practices 
	 * for dealing with generic arrays.
	 */
    @SuppressWarnings("unchecked")
	public Heap(Class<T> clazz) {    	
    	array = (T[]) Array.newInstance(clazz, MAX_SIZE);
    	//array = (T[]) new Object[MAX_SIZE];
    }
    
    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == array.length;
    }

    public T getElementAtIndex(int index) {
        return array[index];
    }
    
    public int getLeftChildIndex(int parentIndex) {    	
    	if (parentIndex < 0) {    		
    		return -1;
    	}    	
    	int leftChildIndex = 2 * parentIndex + 1;
    	//parentIndex = (rightChildIndex-1)/2; // moving LHS to RHS
    	if (leftChildIndex >= count) {
    		return -1;
    	}    	
    	return leftChildIndex;
    }

    public int getRightChildIndex(int parentIndex) {    	
    	if (parentIndex < 0) {    		
    		return -1;
    	}
    	int rightChildIndex = 2 * parentIndex + 2;
    	//parentIndex = (rightChildIndex-2)/2; // moving LHS to RHS
    	if (rightChildIndex >= count) {
    		return -1;
    	}    	
    	return rightChildIndex;
    }

    public int getParentIndex(int childIndex) {    	
    	if (childIndex <= 0 || childIndex >= count) {    		
    		return -1;
    	}    	
    	return (childIndex - 1) / 2;  	
    }

    protected void swap(int index1, int index2) {        
    	T tempValue = array[index1];
        array[index1] = array[index2];
        array[index2] = tempValue;
    }

    protected abstract void siftDown(int index);

    protected abstract void siftUp(int index);

    public T getHighestPriority() throws HeapEmptyException {
        if (count == 0) {
            throw new HeapEmptyException("Empty heap!");
        }
        return array[0];
    }

    public void insert(T value) throws HeapFullException {
        if (count >= array.length) {
            throw new HeapFullException("Full heap!");
        }
        array[count] = value;
        count++;
        System.out.println("Inserting: " + value);        
        siftUp(count - 1);
    }

    public T removeHighestPriority() throws HeapEmptyException {
        T first = getHighestPriority();
        System.out.println("Before romving : " + this);
        System.out.println("removing: " + first);  
        array[0] = array[count - 1]; // removing first element
        array[count - 1] = null; // swapping last element to first
        count--;
        System.out.println("After romving : " + this);
        siftDown(0); // and ordering after that
        return first;
    }

    @Override
    public String toString() {
    	return Arrays.toString(array);
    }
}

class HeapEmptyException extends Exception {
	private static final long serialVersionUID = 1L;
	public HeapEmptyException(String message) {
		super(message);
	}	
}

class HeapFullException extends Exception {
	private static final long serialVersionUID = 1L;
	public HeapFullException(String message) {
		super(message);
	}	
}

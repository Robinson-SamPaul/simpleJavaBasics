package simple;

import java.util.Arrays;

/*
 * It's basically binary tree where elements are stored in array instead of nodes
 */
public class AiaHeapSort {

	/*
	 * First need to heapify
	 * Then first element should be swapped with last
	 * Then again need to heapify the array except last element
	 * And first element should be swapped with last second element
	 * Then again need to heapify the array except last 2 elements
	 * And so on...
	 * 
	 * Not a stable and not an adaptive algorithm
	 */
	public static void main(String[] args) {
		int[] array = { 4, 6, 9, 2, 10, 56, 12, 5, 1, 17, 14 };
		heapsort(array);
	}

	private static int getParentIndex(int index, int endIndex) {
		if (index < 0 || index > endIndex) {
			return -1;
		}
		return (index - 1) / 2;
	}

	private static int getLeftChildIndex(int index, int endIndex) {
		int leftChildIndex = 2 * index + 1;
		if (leftChildIndex > endIndex) {
			return -1;
		}
		return leftChildIndex;
	}

	private static int getRightChildIndex(int index, int endIndex) {
		int rightChildIndex = 2 * index + 2;
		if (rightChildIndex > endIndex) {
			return -1;
		}
		return rightChildIndex;
	}

	private static void swap(int[] array, int index1, int index2) {
		int tempValue = array[index1];
		array[index1] = array[index2];
		array[index2] = tempValue;
	}

	private static void percolateDown(int[] array, int index, int endIndex) {
		int leftChildIndex = getLeftChildIndex(index, endIndex);
		int rightChildIndex = getRightChildIndex(index, endIndex);
		int largerIndex = -1;
		if (leftChildIndex != -1 && rightChildIndex != -1) {
			largerIndex = array[leftChildIndex] > array[rightChildIndex] ? leftChildIndex : rightChildIndex;

		} else if (leftChildIndex != -1) {
			largerIndex = leftChildIndex;
		} else if (rightChildIndex != -1) {
			largerIndex = rightChildIndex;
		}
		// NOTE: If the left and right child do not exist stop sifting down.
		if (largerIndex == -1) {
			System.out.println("Stop percolating down\n");
			return;
		}
		System.out.println("Parent: " + array[index] + " at index " + index);
		System.out.println("Left child: " + array[leftChildIndex]);
		System.out.println("Right child: " + (rightChildIndex == -1 ? "NA" : array[rightChildIndex]));
		System.out.println("Larger child: " + array[largerIndex]);
		if (array[largerIndex] > array[index]) {			
			System.out.println("Before swapping " + Arrays.toString(Arrays.copyOfRange(array, 0, endIndex)));          
			swap(array, largerIndex, index);
        	System.out.println("Swapping " + array[largerIndex] + " and " + array[index]);
			System.out.println("After swapping " + Arrays.toString(Arrays.copyOfRange(array, 0, endIndex))); 
			percolateDown(array, largerIndex, endIndex);
		} else {
			System.out.println("No percolating down\n");
		}
	}

	public static void heapify(int[] array, int endIndex) {
		int index = getParentIndex(endIndex, endIndex); // getting the parent of last indexed value
		while (index >= 0) {
			percolateDown(array, index, endIndex); // similar to siftDown
			index--; // decrementing the parent index of last value to go from bottom to top
		}
	}

	public static void heapsort(int[] array) {
		int arr1[] = Arrays.copyOf(array, array.length);
		System.out.println("*************Heapify started*************\n");
		heapify(array, array.length - 1);
		System.out.println("**************Heapify ended**************\n");
		System.out.println("*************Sorting started*************\n");
		int arr2[] = Arrays.copyOf(array, array.length);
		int endIndex = array.length - 1;
		while (endIndex > 0) {
			System.out.println("*-> Move " + array[0] + " to the end");
			System.out.println("Before swapping " + Arrays.toString(Arrays.copyOfRange(array, 0, endIndex)));           
			swap(array, 0, endIndex);
        	System.out.println("Swapping " + array[0] + " and " + array[endIndex]);
        	System.out.println("After swapping " + Arrays.toString(Arrays.copyOfRange(array, 0, endIndex)));
			endIndex--;
			percolateDown(array, 0, endIndex);
		}
		System.out.println("**************Sorting ended**************\n");
		int arr3[] = Arrays.copyOf(array, array.length);
		
		
		
		System.out.println("\n\n\n");
		System.out.println("Actual array :" + Arrays.toString(arr1));
		System.out.println("Heaped array :" + Arrays.toString(arr2));
		System.out.println("Sorted array :" + Arrays.toString(arr3));
	}
}

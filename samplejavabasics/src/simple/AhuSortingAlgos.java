package simple;

import java.util.Arrays;

public class AhuSortingAlgos {

	public static void main(String[] args) {
		 selectionSortTrial();
		 bubbleSortTrial();
		 bubbleSortEarlyStopTrial();
		 insertSortTrial();
		 insertSortEarlyStopTrial();
		 shellSortTrial();
		 shellSortEarlyStopTrial();
		 mergeSortTrial();
		 mergeSortEarlyStopTrial();
		 quickSortTrial();
		 quickSortEarlyStopTrial();
	}

	private static void quickSortTrial() {
		int unsortedList[] = getArr();
		System.out.println(Arrays.toString(unsortedList));
		quickSort(unsortedList);
	}

	private static void quickSortEarlyStopTrial() {
		int unsortedList[] = getSortArr();
		System.out.println(Arrays.toString(unsortedList));
		quickSort(unsortedList);
	}

	private static void mergeSortTrial() {
		int unsortedList[] = getArr();
		System.out.println(Arrays.toString(unsortedList));
		mergeSort(unsortedList);
	}

	private static void mergeSortEarlyStopTrial() {
		int unsortedList[] = getSortArr();
		System.out.println(Arrays.toString(unsortedList));
		mergeSort(unsortedList);
	}

	private static void shellSortTrial() {
		int unsortedList[] = getArr();
		System.out.println(Arrays.toString(unsortedList));
		shellSort(unsortedList);
	}

	private static void shellSortEarlyStopTrial() {
		int unsortedList[] = getSortArr();
		System.out.println(Arrays.toString(unsortedList));
		shellSort(unsortedList);
	}

	private static void insertSortTrial() {
		int unsortedList[] = getArr();
		System.out.println(Arrays.toString(unsortedList));
		insertionSort(unsortedList);
	}

	private static void insertSortEarlyStopTrial() {
		int unsortedList[] = getSortArr();
		System.out.println(Arrays.toString(unsortedList));
		insertionSort(unsortedList);
	}

	private static void bubbleSortTrial() {
		int unsortedList[] = getArr();
		System.out.println(Arrays.toString(unsortedList));
		bubbleSort(unsortedList);
	}

	private static void bubbleSortEarlyStopTrial() {
		int unsortedList[] = getSortArr();
		System.out.println(Arrays.toString(unsortedList));
		bubbleSortWithEarlyStop(unsortedList);
	}

	private static void selectionSortTrial() {
		int unsortedList[] = getArr();
		System.out.println(Arrays.toString(unsortedList));
		selectionSort(unsortedList);
	}

	private static int[] getArr() {
		return new int[] { 40, 50, 60, 20, 10, 70, 100, 30, 80, 90 };
	}

	private static int[] getSortArr() {
		return new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
	}

	public static void swap(int[] list, int iIndex, int jIndex) {
		int temp = list[iIndex];
		list[iIndex] = list[jIndex];
		list[jIndex] = temp;
	}

	/*
	 * Basically left to right sort 
	 * 
	 * Time Complexity 
	 * 		Best Case: O(n²) 
	 * 		Average Case: O(n²) 
	 * 		Worst Case: O(n²) 
	 * 		Swapping: O(n²) 
	 * 		Comparing: O(n²) 
	 * Space Complexity: O(1)(In-place sorting algorithm) 
	 * 
	 * Not an Adaptive sorting algorithm (even though sorted already, still runs) 
	 * Not a stable algorithm (won't preserve order, like equal values will be swapped) 
	 * 
	 * Selection Sort can be modified to be stable, though it’s not naturally stable in its basic form. 
	 * The key to making it stable is to avoid swapping elements in a way that disrupts their relative order.
	 */
	public static void selectionSort(int[] listToSort) {
		int comparingCount = 0;
		int swappingCount = 0;
		for (int i = 0; i < listToSort.length; i++) { // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
			System.out.println("\ni = " + i);
			for (int j = i + 1; j < listToSort.length; j++) { // 1, 2, 3, 4, 5, 6, 7, 8, 9
				comparingCount++;
				if (listToSort[i] > listToSort[j]) {
					swap(listToSort, i, j);
					System.out.print(++swappingCount + " Swapping: " + i + " and " + j + " ");
					// even if it's equal, it's getting swapped
					System.out.println(Arrays.toString(listToSort));
				}
			}
		}
		System.out.format("\nComparing : %d, Swapping %d", comparingCount, swappingCount);
	}

	/*
	 * Basically right to left sort, e.g: it first sorts large element to last
	 */
	public static void bubbleSort(int[] listToSort) {
		int comparingCount = 0;
		int swappingCount = 0;
		for (int i = listToSort.length - 1; i > 0; i--) { // 9, 8, 7, 6, 5, 4, 3, 2, 1, 0
			System.out.println("\ni = " + i);
			for (int j = 0; j < i; j++) { // 0, 1, 2, 3, 4, 5, 6, 7, 8
				comparingCount++;
				if (listToSort[j] > listToSort[j + 1]) {
					swap(listToSort, j, j + 1);
					System.out.print(++swappingCount + " Swapping: " + j + " and " + (j + 1) + " ");
					System.out.println(Arrays.toString(listToSort));
				}
			}
		}
		System.out.format("\nComparing : %d, Swapping %d", comparingCount, swappingCount);
	}

	/*
	 * Time Complexity 
	 * 		Best Case: O(n) // already sorted 
	 * 		Average Case: O(n²) 
	 * 		Worst Case: O(n²) 
	 * 		Swapping: O(n²) 
	 * 		Comparing: O(n²) 
	 * Space Complexity: O(1)(In-place sorting algorithm) 
	 * 
	 * An Adaptive sorting algorithm 
	 * A stable sorting algorithm
	 */
	public static void bubbleSortWithEarlyStop(int[] listToSort) {
		int comparingCount = 0;
		int swappingCount = 0;
		for (int i = listToSort.length - 1; i > 0; i--) {
			boolean swapped = false;
			System.out.println("\ni = " + i);
			for (int j = 0; j < i; j++) {
				comparingCount++;
				if (listToSort[j] > listToSort[j + 1]) {
					swap(listToSort, j, j + 1);
					swapped = true;
					System.out.print(++swappingCount + " Swapping: " + j + " and " + (j + 1) + " ");
					System.out.println(Arrays.toString(listToSort));
				}
			}
			if (!swapped) {
				break;
			}
		}
		System.out.format("\nComparing : %d, Swapping %d", comparingCount, swappingCount);
	}

	/*
	 * Time Complexity 
	 * 		Best Case: O(n) // already sorted 
	 * 		Average Case: O(n²) 
	 * 		Worst Case: O(n²) 
	 * 		Swapping: O(n²) 
	 * 		Comparing: O(n²) 
	 * Space Complexity: 
	 * 		O(1)(In-place sorting algorithm) 
	 * 
	 * An Adaptive sorting algorithm 
	 * A stable sorting algorithm
	 */
	public static void insertionSort(int[] listToSort) {
		int comparingCount = 0;
		int swappingCount = 0;
		for (int i = 0; i < listToSort.length - 1; i++) { // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
			System.out.println("\ni = " + i);
			for (int j = i + 1; j > 0; j--) { // 1 // 2, 1 // 3, 2, 1 // etc
				comparingCount++;
				if (listToSort[j] < listToSort[j - 1]) {
					swap(listToSort, j, j - 1);
					System.out.print(++swappingCount + " Swapping: " + j + " and " + (j - 1) + " ");
					System.out.println(Arrays.toString(listToSort));
				} else {
					break;
				}
			}
		}
		System.out.format("\nComparing : %d, Swapping %d", comparingCount, swappingCount);
	}

	/*
	 * Time Complexity 
	 * 		Best Case: O(n log²n) 
	 * 		Average Case: O(n^(3/2)) - O(n^(5/4))
	 * 		Worst Case: O(n²) 
	 * 		Swapping: O(n²) 
	 * 		Comparing: O(n²) 
	 * Space Complexity:
	 *		O(1)(In-place sorting algorithm) 
	 * 
	 * Not an Adaptive sorting algorithm 
	 * Not a stable sorting algorithm
	 */
	public static void shellSort(int[] listToSort) {
		int increment = listToSort.length / 2;
		while (increment >= 1) {
			insertionHelperSortForShellSort(listToSort, increment);
			increment = increment / 2;
		}
	}

	public static void insertionHelperSortForShellSort(int[] listToSort, int increment) {
		for (int i = 0; i + increment < listToSort.length; i++) {
			System.out.println("\ni = " + i + " increment = " + increment);
			for (int j = i + increment; j - increment >= 0; j = j - increment) {
				if (listToSort[j] < listToSort[j - increment]) {
					swap(listToSort, j, j - increment);
					System.out.print("Swapping: " + j + " and " + (j - increment) + " ");
					System.out.println(Arrays.toString(listToSort));
				} else {
					break;
				}
			}
		}
	}
	
	/*
	 * Time Complexity 
	 * 		Best Case: O(n log n) 
	 * 		Average Case: O(n log n) 
	 * 		Worst Case: O(n log n)  
	 * 		Swapping: O(n log n) 
	 * 		Comparing: O(n log n)
	 * Space Complexity:
	 *		O(n) 
	 * 
	 * Not an Adaptive sorting algorithm 
	 * A stable sorting algorithm
	 */
	public static void mergeSort(int[] listToSort) {
        if (listToSort.length == 1) {
            return;
        }

        int midIndex = listToSort.length / 2 + listToSort.length % 2;
        int[] listFirstHalf = new int[midIndex];
        int[] listSecondHalf = new int[listToSort.length - midIndex];
        
        split(listToSort, listFirstHalf, listSecondHalf);
        
        System.out.print("\n Split: " + Arrays.toString(listFirstHalf) + "     " + Arrays.toString(listSecondHalf));

        mergeSort(listFirstHalf);
        mergeSort(listSecondHalf);
        merge(listToSort, listFirstHalf, listSecondHalf);

        System.out.print("\nMerged: " + Arrays.toString(listToSort));
    }

	public static void split(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
		int secondHalfStartIndex = listFirstHalf.length;
		for (int index = 0; index < listToSort.length; index++) {
			if (index < secondHalfStartIndex) {
				listFirstHalf[index] = listToSort[index];
			} else {
				listSecondHalf[index - secondHalfStartIndex] = listToSort[index];
			}
		}
	}

	public static void merge(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
		int mergeIndex = 0;
		int firstHalfIndex = 0;
		int secondHalfIndex = 0;
		
		while (firstHalfIndex < listFirstHalf.length && secondHalfIndex < listSecondHalf.length) {
			
			if (listFirstHalf[firstHalfIndex] < listSecondHalf[secondHalfIndex]) {
				listToSort[mergeIndex] = listFirstHalf[firstHalfIndex];
				firstHalfIndex++;
			} else if (secondHalfIndex < listSecondHalf.length) {
				listToSort[mergeIndex] = listSecondHalf[secondHalfIndex];
				secondHalfIndex++;
			}
			mergeIndex++;
		}
		
		if (firstHalfIndex < listFirstHalf.length) {
			while (mergeIndex < listToSort.length) {
				listToSort[mergeIndex++] = listFirstHalf[firstHalfIndex++];
			}
		}
		if (secondHalfIndex < listSecondHalf.length) {
			while (mergeIndex < listToSort.length) {
				listToSort[mergeIndex++] = listSecondHalf[secondHalfIndex++];
			}
		}
	}
	
	public static int partition(int[] listToSort, int lowIndex, int highIndex) {
        int pivot = listToSort[lowIndex];        
        int l = lowIndex;
        int h = highIndex;
        
        System.out.println("\nPivot = " + pivot + "\nStartIndex = " + l + "\nEndIndex = " + h);

        while (l < h) {
            
        	System.out.format("\nFirst comparing %d(%d) and %d\n", l, listToSort[l], pivot);
            while (listToSort[l] <= pivot && l < h) {
                l++;
            }

        	System.out.format("Second comparing %d(%d) and %d\n", h, listToSort[h], pivot);
            while (listToSort[h] > pivot) {
                h--;
            }
            
            if (l < h) {
                System.out.println("\nBefore swap : " + Arrays.toString(listToSort));
                swap(listToSort, l, h);
                System.out.print("Swapping: " + l + "(" + listToSort[l] + ") and " + h + "(" + listToSort[h] + ") ");
                System.out.println("\nAfter swap : " + Arrays.toString(listToSort));
            }
        }

        if (lowIndex != h) {
            swap(listToSort, lowIndex, h);

            System.out.print("Swapping: " + lowIndex + "(" + listToSort[lowIndex] + ") and " + h + "(" + listToSort[h] + ") ");
            System.out.println(Arrays.toString(listToSort));
        }

        System.out.println("\nPartitioned: " + Arrays.toString(listToSort) + 
                " around pivot: " + pivot);

        return h;
    }

    public static void quickSortRecursive(int[] listToSort, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(listToSort, low, high);
        
        quickSortRecursive(listToSort, low, pivotIndex - 1);
        quickSortRecursive(listToSort, pivotIndex + 1, high);
    }

    public static void quickSort(int[] listToSort) {
        quickSortRecursive(listToSort, 0, listToSort.length-1);
    }
}

package simple;

import java.util.Arrays;

public class Main2 {
	
    public static void swap(String[] list, int iIndex, int jIndex) {
        
        String temp = list[iIndex];

        list[iIndex] = list[jIndex];
        list[jIndex] = temp;
    }

    public static int partition(String[] listToSort, int low, int high) {
        
        String pivot = listToSort[low];
        
        int l = low;
        int h = high;
        
        System.out.println("\nPivot = " + pivot);

        while (l < h) {
            
            while (listToSort[l].compareTo(pivot) <= 0 && l < h) {
                l++;
            }

            while (listToSort[h].compareTo(pivot) > 0) {
                h--;
            }
            
            if (l < h) {
                swap(listToSort, l, h);

                System.out.print("Swapping: " + l + " and " + h + " ");
                System.out.println(Arrays.toString(listToSort));
            }
        }

        if (low != h) {
            swap(listToSort, low, h);

            System.out.print("Swapping: " + low + " and " + h + " ");
            System.out.println(Arrays.toString(listToSort));
        }

        System.out.println("\nPartitioned: " + Arrays.toString(listToSort) + 
                " around pivot: " + pivot);

        return h;
    }

    public static void quickSort(String[] listToSort, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(listToSort, low, high);
        
        quickSort(listToSort, low, pivotIndex - 1);
        quickSort(listToSort, pivotIndex + 1, high);
    }

    public static void main(String[] args) {
        
        String unsortedList[] = new String[] {"Fiona", "Dora", 
                "Alex", "Jeff", 
                "Elise", "Irene", 
                "Gerald", "Ben", 
                "Harry", "Carl"};

        System.out.println(Arrays.toString(unsortedList));
    
        quickSort(unsortedList, 0, unsortedList.length - 1);

        System.out.println("\n" + Arrays.toString(unsortedList));
    }

}

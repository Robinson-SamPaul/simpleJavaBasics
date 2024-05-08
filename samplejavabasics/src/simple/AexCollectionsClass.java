package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AexCollectionsClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
    	list.add("Sam");
    	list.add("Shiva");
    	list.add("Adam");
    	list.add("Bam");
    	list.add("Fhiva");
    	list.add("Edam");
    	
    	System.out.println("Original " + list);
    	
    	Collections.sort(list); // it'll affect original
    	System.out.println("Coll sort " + list);
    	
    	Collections.reverse(list);
    	System.out.println("coll rev " + list);
    	
    	list.sort(null);
    	System.out.println("list sort " + list);
    	
    	Collections.shuffle(list);
    	System.out.println("Coll shfl " + list);
    	
    	list.sort(Comparator.naturalOrder());
    	System.out.println("ntrl ordr " + list);
    	System.out.println();

		List<String> lessSize = Arrays.asList("1", "2", "3", "4", "5");
		List<String> sameSize = Arrays.asList("1", "2", "3", "4", "5", "6");
		List<String> moreSize = Arrays.asList("1", "2", "3", "4", "5", "6", "7");

		try {
			Collections.copy(lessSize, list);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		Collections.copy(sameSize, list);
		Collections.copy(moreSize, list);

		System.out.println("after copy " + list);
		System.out.println("less size " + lessSize);
		System.out.println("same size " + sameSize);
		System.out.println("more size " + moreSize);
		System.out.println();

		/*
		 * It has a time complexity of O(n) in the worst case, 
		 * where n is the size of the list. 
		 * This is because it iterates through the list linearly to find the element
		 */
		System.out.println(list.indexOf("Sam"));
		/*
		 * It has a time complexity of O(log n) in the worst case, 
		 * where n is the size of the list. 
		 * This is because it uses a binary search algorithm, 
		 * which is efficient for sorted collections
		 */
		System.out.println(Collections.binarySearch(list, "Sam"));
	}

}

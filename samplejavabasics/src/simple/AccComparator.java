package simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AccComparator {

	/*
	 * All sorting classes must implement comparable, or else we'll get ClassCastException.
	 * Without comparable, we can't sort it, we can override it with comparator if we don't like inital logic.
	 * 
	 * val > 0 means swap
	 * 
	 * Comparable
		Interface Type		Inside the class (natural ordering)
		Method to Implement	int compareTo(T o)
		Sorting Logic		Defined inside the class you're comparing
		Use Case			When an object has a natural/default sorting
		Single Ordering		You can only define one sort logic per class
	 */
	/*
	 * Comparator
	 	Interface Type		External to the class
		Method to Implement	int compare(T o1, T o2)
		Sorting Logic		Defined in a separate class or lambda
		Use Case			When you want multiple sorting strategies
		Multiple Orderings	You can create as many Comparators as needed
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ls = new ArrayList<>();
		ls.add(4);
		ls.add(1);
		ls.add(3);
		ls.add(2);
		
		Collections.sort(ls);
		System.out.println(ls);
		
//		Comparator<Integer> cr = new Comparator<Integer>() { // for anonymous inner class, generics is must in constructor
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				
//				if(o1 < o2) {
//					return 1;
//				}
//				return -1;
//			}
//		
//		};	
		
		Comparator<Integer> cr = (o1, o2) -> (o1 < o2) ? 1 : -1;	
		Collections.sort(ls, cr);
		System.out.println(ls);

		Collections.sort(ls, (o1, o2) -> (o1 < o2) ? 1 : -1);
		System.out.println(ls);
		
		Collections.sort(ls, Comparator.reverseOrder());
		System.out.println(ls);
		
		System.out.println(AcrComparatorParam.class);
		System.out.println(AcjStreamSorted.class);
	}

}

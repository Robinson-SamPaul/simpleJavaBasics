package simple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class AeiListIterator {

	public static void main(String[] args) {

		List<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		integers.add(4);
		integers.add(5);
		
		System.out.println(integers);
		
		Iterator<Integer> iterator1 = integers.iterator();
		
		System.out.println("\nFirst time");
		while (iterator1.hasNext()) {
			System.out.print(iterator1.next() + "  ");
		}
		
		System.out.println("\n\nSecond time");
		while (iterator1.hasNext()) {
			System.out.print(iterator1.next());  // It prints nothing, as the iterating is done, in previous iteration
		}
		System.out.println("[]");
		
		/* To iterate in reverse */
		ListIterator<Integer> iterator2 = integers.listIterator(integers.size());
		
		System.out.println("\nThird time");
		while (iterator2.hasNext()) {
			System.out.print(iterator2.next());  // It prints nothing, got to go backwards
		}
		System.out.println("[]");
		
		System.out.println("\nFourth time");
		while (iterator2.hasPrevious()) {
			System.out.print(iterator2.previous() + "  ");  
		}
		System.out.println();
		
		LinkedList<Integer> integerList = new LinkedList<>();
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		integerList.add(4);
		integerList.add(5);
		
		/*
		 * Only LinkedList class supports this
		 * Even though we're trying to iterate reverse
		 * we should use hasNext and next
		 * can't use previous methods
		 */
		Iterator<Integer> iterator3 = integerList.descendingIterator();
		
		System.out.println("\nFifth time");
		while (iterator3.hasNext()) {
			System.out.print(iterator3.next() + "  ");
		}
	}
}

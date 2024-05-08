package simple;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AekDifferentLists {

	public static void main(String[] args) {

		List<String> arrayList = new ArrayList<>();
		List<String> linkedList = new LinkedList<>();
		
		Instant start, end;

		/*
		 * To add/remove at end, ArrayList is good u may think,
		 * still linked list gives -> addFirst(), addLast(), removeFirst(), removeLast()
		 * which is faster than Array List 
		 * so, LinkedList is better
		 * 
		 * Accessing = ArrayList (even for accessing, Linked List has getFirst(), getLast() which is faster)
		 * Manipulation = LinkedList
		 */
		start = Instant.now();
		add50000Values(arrayList); // O(n) operation (linear time complexity) 
		end = Instant.now();
		System.err.println("Array List manipluation = " + Duration.between(start, end));
		
		start = Instant.now();
		add50000Values(linkedList);  // O(1) operation (constant time complexity).
		end = Instant.now();
		System.err.println("Linked List manipluation = " + Duration.between(start, end));
		
		start = Instant.now();
		access50000Values(arrayList); // O(1) operation (constant time complexity).
		end = Instant.now();
		System.err.println("Array List accessing = " + Duration.between(start, end));
		
		start = Instant.now();
		access50000Values(linkedList); // O(n) operation (linear time complexity)
		end = Instant.now();
		System.err.println("Linked List accessing = " + Duration.between(start, end));

	}
	
	private static void add50000Values(List<String> integers) {
		
		for (int i = 0; i < 100000; i++) {
			integers.add("Sam");
			integers.add("Paul");
			integers.add("Rob");
			integers.add("John");
			integers.add("Jane");
		}
	}
	
	private static void access50000Values(List<String> integers) {
		
		for (int i = 0; i < 100000; i++) {
			integers.get(i);
		}
	}
}

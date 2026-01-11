package simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList; 

public class AezDifferentLists {

	public static void main(String[] args) {

		/*
		 * Implements the List interface and uses a dynamic array for storage. 
		 * Allows fast random access to elements. 
		 * Resizes dynamically as elements are added or removed. 
		 * Suitable for scenarios where random access and iteration are common
		 * but insertions and deletions at arbitrary(random) positions are less frequent.
		 */
		List<Integer> integers1 = new ArrayList<>();
		integers1.add(4);
		
		/*
		 * Also implements the List interface but uses a doubly linked list for storage.
		 * Provides fast insertion and deletion at both ends of the list. 
		 * Slower random access compared to ArrayList due to sequential traversal. 
		 * Suitable for scenarios where frequent insertions and deletions are needed, 
		 * especially at the beginning or end of the list.
		 */
		List<Integer> integers2 = new LinkedList<>();
		integers2.add(4);
		
		/*
		 * Similar to ArrayList but is synchronized (thread-safe). 
		 * Provides synchronized methods for accessing and modifying elements. 
		 * Less commonly used due to the overhead of synchronization, unless thread safety is a requirement.
		 */
		List<Integer> integers3 = new Vector<>();
		System.out.println(integers3.size());
		
		Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                integers3.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                integers3.add(i);
            }
        });

        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		System.out.println(integers3.size());

		/*
		 * Using a superclass reference to access subclass-specific methods depends 
		 * on the type of reference and the methods involved. 
		 * In Java, when you use a superclass reference to refer to a subclass object, 
		 * you can only access methods and fields that are part of the superclass 
		 * or are inherited by the superclass. 
		 * You can't directly access methods or fields that are specific to
		 * the subclass and not present in the superclass.
		 * 
		 * For example, if you have a superclass Animal and a subclass Dog 
		 * that adds a
		 *  method bark(), you can't call bark() using an Animal reference because 
		 *  bark() is not defined in the Animal class or any of its super classes.
		 */
//		List<Integer> integers4 = new Stack<>();
//		integers4.push();
		
		/*
		 * Extends Vector and implements a stack (Last-In-First-Out, LIFO) data structure. 
		 * Provides stack-specific operations like push and pop. 
		 * Can be used for implementing algorithms like expression evaluation, backtracking, etc.
		 */
		Stack<Integer> integers4 = new Stack<>();
		integers4.push(3);
		integers4.add(5); // can call super class method with sub class ref, but not vice versa
		integers4.pop();
		
		/*AblPriorityQueue.java*/
		Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());  // Prints: 1, 2, 3
        }
		
		/*
		 * Implements the List interface and internally uses a copy-on-write array.
		 * Designed for concurrent access and is thread-safe.
		 * Ensures thread safety by creating a new copy of the array on modification, 
		 * allowing for safe traversal without synchronization.
		 * 
		 * While CopyOnWriteArrayList provides thread safety, 
		 * it does not use traditional synchronization mechanisms like 
		 * synchronized blocks or locks to achieve this.
		 * Instead, it relies on the copy-on-write strategy, 
		 * where modifications are made on a separate copy of the array, 
		 * ensuring that readers see a consistent view of the list without 
		 * being affected by ongoing write operations.
		 */ 
		List<Integer> integers5 = new CopyOnWriteArrayList<>();
		integers5.add(2);
		integers5.add(4);
		integers5.add(3);
		System.out.println(integers5);
		integers5.forEach(n -> integers5.add(n+10));
		System.out.println(integers5);
		
		/*
		 * Provides an immutable (read-only) list that cannot be modified after creation.
		 * Ensures thread safety in concurrent environments without synchronization.
		 * Offers predictable and stable behavior for shared data structures.
		 */
		List<Integer> immutableList1 = List.copyOf(integers1);
		try {
			immutableList1.add(3);
		} catch (Exception e) {
			System.out.println(e);
		}
		List<Integer> immutableList2 = Collections.unmodifiableList(integers1);
		try {
			immutableList2.add(3);
		} catch (Exception e) {
			System.out.println(e);
		}
		
//		com.google.common.collect.ImmutableList obj; might need POM/external jar to work with this
	}

}

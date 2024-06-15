package simple;

import java.util.PriorityQueue;

public class AblPriorityQueue {

	public static void main(String[] args) {
		/*
		 * Queue: 
		 * 		Maintains the order of insertion (FIFO).
		 * 		Use when the order of processing elements is based on their insertion order.
		 * 		Generally has constant time (O(1)) for insertion and removal operations.
		 * 		Some implementations (e.g., LinkedList) may allow null elements.
		 * PriorityQueue: 
		 * 		Orders elements based on their natural order or a specified comparator (priority-based).
		 * 		Use when the order of processing elements is based on their priority.
		 * 		Typically has logarithmic time (O(log n)) for insertion and removal operations due to the need to maintain order.
		 * 		Does not permit null elements.
		 */
		PriorityQueue<Integer> val = new PriorityQueue<>();
		val.add(1);
		val.add(10);
		val.add(100);
		System.out.println(val);
		System.out.println(val.peek()); // returns head value
		System.out.println(val);
		System.out.println(val.poll()); // return and remove
		System.out.println(val);
	}

}

package simple;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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
		 * 		Use when the  order of processing elements is based on their priority. 
		 * 		Typically has  logarithmic time (O(log n)) for insertion and removal operations due to the need to maintain order. 
		 * 		Does not permit null elements.
		 */
		PriorityQueue<Integer> val = new PriorityQueue<>();
		val.add(1);
		val.add(10);
		val.add(100);
		try {
			val.add(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(val);
		System.out.println(val.peek()); // returns head value
		System.out.println(val);
		System.out.println(val.poll()); // return and remove
		System.out.println(val);
		
		queue();
		
		priorityQueue();
	}

	// A PriorityQueue is a special type of queue where elements are ordered based on their natural order or a custom comparator.
	private static void priorityQueue() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(30);
		pq.add(10);
		pq.add(20);

		System.out.println(pq.poll()); // 10 (smallest comes out first)
		System.out.println(pq.poll()); // 20
	}

	private static void queue() {
		Queue<String> queue = new LinkedList<>();
		queue.add("A");
		queue.add("B");
		queue.add("C");

		System.out.println(queue.poll()); // A
		System.out.println(queue.poll()); // B
	}

}

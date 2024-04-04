package simple;

import java.util.PriorityQueue;

public class AblPriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

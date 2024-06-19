package simple;

import java.util.ArrayDeque;
import java.util.Deque;

public class AbmDequeue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> val = new ArrayDeque<>(); // Double-ended Queue, can perform addFirst, addLast, removeFirst, removeLast, peekFirst, and peekLast.
		val.add(46);
		val.addLast(56);
		val.addFirst(76);
		System.out.println(val);
		val.removeFirst();
		System.out.println(val);
		val.removeLast();
		System.out.println(val);
	}

}

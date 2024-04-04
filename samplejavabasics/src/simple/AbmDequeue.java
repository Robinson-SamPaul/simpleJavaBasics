package simple;

import java.util.ArrayDeque;
import java.util.Deque;

public class AbmDequeue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> val = new ArrayDeque<>();
		val.add(46);
		val.add(56);
		val.add(76);
		System.out.println(val);
		val.removeFirst();
		System.out.println(val);
		val.removeLast();
		System.out.println(val);
	}

}

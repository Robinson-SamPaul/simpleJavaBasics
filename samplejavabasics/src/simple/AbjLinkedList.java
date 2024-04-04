package simple;

import java.util.LinkedList;

public class AbjLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList storing & accessing is faster, LinkedList manipulation(adding/removing) is faster
		LinkedList<Integer> val = new LinkedList<>(); // unordered
		val.add(6);
		val.add(7);
		val.add(67);
		val.remove(0);
		for(int i : val) {
			System.out.println(i);
		}
	}

}

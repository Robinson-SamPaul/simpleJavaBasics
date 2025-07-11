package simple;

import java.util.Vector;

public class AbiVector {

	public static void main(String[] args) {
//		Vector - unsorted, ordered, duplicate, synchronized, increase 100% of current if exceeds the size.
		Vector<Integer> val = new Vector<>();
		val.add(6);
		val.add(7);
		val.add(7);
		val.add(67);
		System.out.println(val);
		val.remove(0);
		System.out.println(val.capacity()); // default size is 10 {, 20, 40, etc} and it'll extend by 100% of cur size
		for(int i : val) {
			System.out.println(i);
		}
		System.out.println(AelVector.class);
	}

}

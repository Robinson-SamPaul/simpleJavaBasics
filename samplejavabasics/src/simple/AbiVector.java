package simple;

import java.util.Vector;

public class AbiVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Vector - unsorted, ordered, duplicate, synchronised, increase 100% of current if exceeds the size.
		Vector<Integer> val = new Vector<>();
		val.add(6);
		val.add(7);
		val.add(7);
		val.add(67);
		System.out.println(val);
		val.remove(0);
		System.out.println(val.capacity()); // default size is 10 {, 20, 30, etc} and it'll extend
		for(int i : val) {
			System.out.println(i);
		}
	}

}

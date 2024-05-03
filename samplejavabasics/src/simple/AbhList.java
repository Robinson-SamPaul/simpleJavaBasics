
package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
//import java.util.Collection;
import java.util.List;

public class AbhList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList - unsorted, ordered, duplicate, not synchronized, increase 50% of current if exceeds the size(if size is 10, and u add 11th value, it'll become 10+(10/2) = 15).
//		Collection<Integer> val = new ArrayList<Integer>();
//		val.add(89);
//		val.remove(89);
		List<Integer> val = new ArrayList<>(); // default size is 10 {, 15, 20, etc} and it'll extend
		val.add(6);
		val.add(7);
		val.add(1);
		val.add(88);
		val.add(88);
		
//		List to array
		Integer[] valArr = val.toArray(new Integer[val.size()]);
		
		System.out.println("List = " + val);
		System.out.println("Array = " + Arrays.toString(valArr));
		
		val.add(0, 89);
		for(int i : val) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		val.remove(2);
		System.out.println(val.get(1) + " " + val.size());
		
		for(int i : val) { // Integer -> int auto-unboxing
			System.out.print(i + " ");
		}
		System.out.println();
		
		Collections.sort(val);
		System.out.println(val);
		Collections.reverse(val);
		System.out.println(val);
		
		Iterator<Integer> i = val.iterator();
//		System.out.println(i);
		while(i.hasNext()) {
			System.out.print(i.next() + " ");
		}
		
		System.out.println();
		List<Integer> integers = new ArrayList<>() 
		{ // anonymous inner class
			private static final long serialVersionUID = 4122606379714971121L; // needed as ArrayList implements Serializable
			{ // instantiation initializer
				add(4);
				add(5);
				add(6);
			}
		};
		System.out.println(integers);
	}

}

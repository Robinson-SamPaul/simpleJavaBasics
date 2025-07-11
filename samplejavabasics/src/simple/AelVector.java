package simple;

import java.util.Arrays;
import java.util.Vector;

public class AelVector {

	public static void main(String[] args) {
		
		System.out.println(AbiVector.class);

		Vector<String> strings = new Vector<>();
		
		System.out.println(strings.size());
		System.out.println(strings.capacity()); // capacity goes 10,20, 40, 80
		
		strings.addAll(Arrays.asList(
				"Sam", "Paul", "Rob", 
				"Sam", "Paul", "Rob", 
				"Sam", "Paul", "Rob", 
				"Sam", "Paul", "Rob"));
		
		System.out.println(strings.size());
		System.out.println(strings.capacity());
		
		strings.addAll(Arrays.asList(
				"Sam", "Paul", "Rob", 
				"Sam", "Paul", "Rob", 
				"Sam", "Paul", "Rob", 
				"Sam", "Paul", "Rob"));
		
		System.out.println(strings.size());
		System.out.println(strings.capacity());
	}
}

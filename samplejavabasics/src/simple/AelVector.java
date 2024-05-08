package simple;

import java.util.Arrays;
import java.util.Vector;

public class AelVector {

	public static void main(String[] args) {

		Vector<String> strings = new Vector<>();
		
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

package simple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AcfStreamApi {

	/*
	 * A Stream in Java (introduced in Java 8) is a sequence of data elements that supports functional-style operations to process data.
	 * Think of it like a pipeline where data flows and gets processed in steps.
	 * A Stream does not store data; it pulls from a source (like a list or array), processes it using methods, and produces a result.
	 */
	public static void main(String[] args) {

		List<Integer> ls = Arrays.asList(2,3,4,5,6,7);
		
		Stream<Integer>  st = ls.stream(); // stream won't affect original values and it's object only used once

		st.forEach(n -> System.out.println(n));
//		st.forEach(n -> System.out.println(n)); // stream is already used
	}

}

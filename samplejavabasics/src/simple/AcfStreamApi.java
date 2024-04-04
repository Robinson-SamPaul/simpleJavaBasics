package simple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AcfStreamApi {

	public static void main(String[] args) {

		List<Integer> ls = Arrays.asList(2,3,4,5,6,7);
		
		Stream<Integer>  st = ls.stream(); // stream won't affect original values and it's object only used once

		st.forEach(n -> System.out.println(n));
//		st.forEach(n -> System.out.println(n)); // stream is already used
	}

}

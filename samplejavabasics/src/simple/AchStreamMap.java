package simple;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class AchStreamMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> ls = Arrays.asList(2,3,4,5,6,7);
		Stream<Integer> s1 = ls.stream();
		
		Function<Integer, Integer> fn = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer t) {
				// TODO Auto-generated method stub
				return t*2;
			}
		};
		System.out.println(fn.apply(3));
		Stream<Integer> s2 = s1.map(fn);
//		Stream<Integer> s2 = s1.map(n -> n*2);
		s2.forEach(n -> System.out.print(n + " "));

	}

}

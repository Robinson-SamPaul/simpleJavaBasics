package simple;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AcgStreamFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> ls = Arrays.asList(2,3,4,5,6,7);
		Stream<Integer> s1 = ls.stream();
		
		Predicate<Integer> p = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				return t%2==0;
			}
		};
		System.out.println(p.test(10));
		Stream<Integer> s2 = s1.filter(p);
		
//		Stream<Integer> s2 = s1.filter(n -> n%2==0); // s1 is used, can't use again
		s2.forEach(n -> System.out.print(n));
 	}

}

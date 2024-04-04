package simple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class AcjStreamSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> ls = Arrays.asList(2,3,5,4,6,7);
		Stream<Integer> s1 = ls
				.parallelStream() // helps to run on multiple threads
				.filter(n -> n>0)
				.sorted(); // gives sorted values, while sorting parallelstream doesn't make any sense

		Stream<Integer> s2 = ls.stream().sorted(Comparator.reverseOrder());
		
		ls.stream().sorted((a, b) -> a-b).forEach(n -> System.out.print(n)); // a-b will return -/+. + swap & - won't
		System.out.println();
		s1.forEach(n -> System.out.print(n));
		System.out.println();
		s2.forEach(n -> System.out.print(n));
		// comparator.comparing must to try		
	}

}

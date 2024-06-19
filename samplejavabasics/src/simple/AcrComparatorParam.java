package simple;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class AcrComparatorParam {

	public static void main(String[] args) {
		System.out.println(AccComparator.class);
		
		Comparator<Integer> comparator = (o1, o2) -> {
				if(o1.equals(o2)) return 0;
				return o2-o1; // To make descending order, by default = o1 - o2
			};
		Set<Integer> integers = new TreeSet<>(comparator); // comparator only for tree map/set
		integers.add(5);
		integers.add(2);
		integers.add(4);
		integers.add(6);
		System.out.println(integers);
	}
}

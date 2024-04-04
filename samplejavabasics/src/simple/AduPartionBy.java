package simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AduPartionBy {
	
	public static void main(String[] args) {
		
		List<Integer> integers = new ArrayList<>();
		integers.add(0);
		integers.add(2);
		integers.add(5);
		integers.add(6);
		integers.add(8);
		
		Map<Boolean, List<Integer>> map = integers.stream()
				.collect(Collectors.partitioningBy(num -> num > 5));
		System.out.println(map);

		List<Integer> lessThan5 = map.get(false);
		System.out.println(lessThan5);
		List<Integer> moreThan5 = map.get(true);
		System.out.println(moreThan5);
	}
}
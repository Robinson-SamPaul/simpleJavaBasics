package simple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AdzCollect {
	
	public static void main(String[] args) {
		List<Integer>numbers = Arrays.asList(12,19,6,65,98);
	    List<Integer>evenNumbers1 = numbers.stream().filter(i->i%2==0).toList(); // will return unmodifiable list
	    List<Integer>evenNumbers2 = numbers.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println(evenNumbers1);
		try {
			evenNumbers1.add(77);
		} catch (Exception e) {
			System.out.println(e);
			System.getProperties();
		}
		System.out.println(evenNumbers1);
		evenNumbers2.add(77);
		System.out.println(evenNumbers2);
	}
}

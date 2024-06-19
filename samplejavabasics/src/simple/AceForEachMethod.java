package simple;

import java.util.Arrays;
import java.util.List;
//import java.util.function.Consumer;

public class AceForEachMethod {

	public static void main(String[] args) {

		List<Integer> ls = Arrays.asList(2,3,4,5,6,7);
		
//		Consumer<Integer> c = new Consumer<Integer>() {
//			
//			@Override
//			public void accept(Integer t) {
//				
//				System.out.print(t);
//			}
//		};
//		c.accept(10);
		
//		ls.forEach(c);
		
		ls.forEach(n -> System.out.println(n));
	}
}
/*
Comparator: Passed to sort methods.
Consumer: Passed to forEach methods.
Predicate: Passed to methods like filter and removeIf.
Function: Passed to methods like map and computeIfAbsent.
Supplier: Passed to methods like orElseGet and generate.
BiFunction: Passed to methods like merge.
*/
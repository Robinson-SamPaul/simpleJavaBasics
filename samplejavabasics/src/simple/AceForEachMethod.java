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
Comparator: Passed to sort methods. compare()
Consumer: Passed to forEach methods. accept()
Predicate: Passed to methods like filter and removeIf. test()
Function: Passed to methods like map and computeIfAbsent. apply()
Supplier: Passed to methods like orElseGet and generate. get()
BiFunction: Passed to methods like merge.
BinaryOperator: Passed to method like reduce. apply()
*/
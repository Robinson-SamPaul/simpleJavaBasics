package simple;

import java.util.Arrays;
import java.util.List;
//import java.util.function.Supplier;


public class AclStreamOrElse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		List<Integer> ls = Arrays.asList(2,3,4,5,6,7);
		List<Integer> ls = Arrays.asList();

//		Supplier<Integer> s = new Supplier<Integer>() {
//
//			@Override
//			public Integer get() {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		};

		System.out.println(ls.stream().findFirst());
//		System.out.println(ls.stream().findFirst().orElse(s.get()));
//		System.out.println(ls.stream().findFirst().orElseGet(s));
		System.out.println(ls.stream().findFirst().orElse(0));
	}

}

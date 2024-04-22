package simple;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class AciStreamReduce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> ls = Arrays.asList(2,3,4,5,6,7);
		BinaryOperator<Integer> bo = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return t+u;
			}
		};
		System.out.println(bo.apply(2, 4));
		
//		Integer total = ls.stream().reduce(0, bo);
		Integer total = ls.stream().reduce(0, (c, e) -> c+e); // stream can be used like this. c = carry, e = element, 0 = initial value
		System.out.println(total);

//		Integer maxNumber = ls.stream().reduce(Integer.MIN_VALUE, Integer::max);
		Integer maxNumber = ls.stream().reduce(Integer.MIN_VALUE, (val, num) -> Integer.max(val, num));
		System.out.println(maxNumber);

		int arr[] = {1, 96, 3, 4, 5};
		int bigVal = Arrays.stream(arr).reduce(0, (a, b) -> a > b ? a : b);
		System.out.println(bigVal);
	}

}

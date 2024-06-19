package simple;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AdcArrayReflection {

	public static void main(String[] args) throws Exception {
		int[] intArr = (int[]) Array.newInstance(int.class, 3);
		Array.set(intArr, 0, 1);
		Array.set(intArr, 1, 2);
		Array.set(intArr, 2, 3);
		System.out.println(intArr.getClass());
		System.out.println(Arrays.toString(intArr));
		Class<?> clazz = Class.forName("[I");
		System.out.println(clazz);
		int[][] intMultiArr = (int[][]) Array.newInstance(clazz, 3);
		int[] realIntArr = {4, 5, 6};
		Array.set(intMultiArr, 0, realIntArr);
		Array.set(intMultiArr, 1, realIntArr);
		Array.set(intMultiArr, 2, realIntArr);
		System.out.println(intMultiArr.getClass());
		System.out.println(Arrays.deepToString(intMultiArr));
	}
}
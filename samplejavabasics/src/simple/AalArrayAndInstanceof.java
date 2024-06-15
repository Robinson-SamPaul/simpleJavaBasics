package simple;

import java.util.Arrays;

public class AalArrayAndInstanceof {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new String("ghh");
		System.out.println(s instanceof String);
		
		int a[] = {0, 1, 2, 3, 4},i;
		int b[] = new int[5];
		for(i = 0; i < a.length; i++) {
			b[i] = i + 5;
		}
		for(i = 0; i < 5; i++) {
			System.out.println(String.format(("%x %x"),a[i],b[i]));
		}
		
		int arr1[] = new int[3];
		System.out.println("int array");
		System.out.println(Arrays.toString(arr1));
		System.out.println(arr1.toString());
		System.out.println(arr1.getClass());
		System.out.println(arr1.length);
				
		Integer arr2[] = new Integer[3];
		System.out.println("Integer array");
		System.out.println(Arrays.toString(arr2));
		System.out.println(arr2.toString());
		System.out.println(arr2.getClass());
		System.out.println(arr2.length);
	}

}

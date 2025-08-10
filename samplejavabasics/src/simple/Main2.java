package simple;

import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		if(null == System.out.printf("Cats")) {
			System.out.println("Cat");
		} else {
			System.out.println("Dog");
		}
		char[] str ={'A','B','C'} ;
        System.out.println(str);
        System.out.println(str.toString());
        System.out.println(String.valueOf(str)); // method overloading for charArr and otherArrs
        System.out.println(new String(str));
		int[] arr ={1,2,3} ;
        System.out.println(String.valueOf(arr));
        System.out.println(arr.toString());
        
        System.out.println("In my current role at CGI, I have been actively involved in implementing REST APIs and adding new fe".length());
        
        List.of(1, 2, 3)
        .stream()
        .peek(i -> System.out.println("Peek: " + i))  // Intermediate
        .map(i -> i * 2)
        .forEach(i -> System.out.println("ForEach: " + i)); // Terminal

	}
}

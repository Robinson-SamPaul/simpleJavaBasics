package simple;

import java.util.Arrays;
import java.util.List;

public class AcnMethodRefernce implements MetRef {

	public String show() {
		return "Hello World!";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System obj = new System(); // System class have private constructor
		List<Integer> ls = Arrays.asList(1,2,3,4,5);
		ls.forEach(System.out::print); // method reference can't be used as a statement, can be used like a variable (referncing a method)
		System.out.println();
		
		AcnMethodRefernce mr = new AcnMethodRefernce();
		MetRef m = mr::show; // instead of implementing lambda function for functional interface, mr can be used to refer the method which is already implemented
		String str = m.show();
		System.out.println(str);
 	}

}

@FunctionalInterface
interface MetRef {
	String show();
}
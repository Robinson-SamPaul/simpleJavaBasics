package simple;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class AebMethodReference {
	
	public static void main(String[] args) {
		
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		integers.forEach(v -> System.out.print(v));
		System.out.println();
		integers.forEach(System.out :: print);
		System.out.println("\n");
		
//		Anonymous inner class
		MethRefInt methRefInt1 = new MethRefInt() {
			@Override
			public void printFromInterface(String str) {
				System.out.println(str.length() > 5 ? "Big" : "Small");
			}
		};
		methRefInt1.printFromInterface("Sam");
		
//		Lambda expression
		MethRefInt methRefInt2 = str -> System.out.println(str.length() > 5 ? "Big" : "Small");
		methRefInt2.printFromInterface("Sampaul");
		
		MethRefInt methRefInt3 = MethodRef::print2;
		methRefInt3.printFromInterface("Sam");
		
		MethRefInt methRefInt4 = new MethodRef()::print1; // The method reference is being used in a context that expects void, so the return value of print1() is simply ignored.
		methRefInt4.printFromInterface("Sam");
		System.out.println();

		ConstRefCls obj = new ConstRefCls();
		ConstRefInt constRefInt1 = () -> obj;
		ConstRefCls obj2 = constRefInt1.method();
		System.out.println(obj.hashCode() + "=" + obj2.hashCode());
		ConstRefInt constRefInt2 = ConstRefCls::new; // constructor reference must match or cast-able to the return type
		constRefInt2.method();
		ConstRefInt constRefInt3 = () -> new ConstRefCls(7); // parameterized constructor
		constRefInt3.method();
		ConstRefInt constRefInt4 = ConstRefCls::new; // constructor reference
//		constRefInt4.method(4); // To call param constructor, FI must have param method
		System.out.println(constRefInt1 + "\n" + constRefInt2 + "\n" + constRefInt3 + "\n" + constRefInt4);
		
		MethodRefArr arrayCreator1 = (length) -> new int[length];
		MethodRefArr arrayCreator2 = int[]::new;
        System.out.println(arrayCreator1 + "\n" + arrayCreator2);
        
        /*
         * Even though toUpperCase() is a non-static method, 
         * we can use String::toUpperCase 
         * because Function<T,R> provides the instance (String) as the argument.
         * 
         * Reference to a non-static method; instance passed as 1st arg implicitly
         */
        Function<String, String> f = String::toUpperCase;
        System.out.println(f.apply("hello")); // Output: HELLO
        
        Function<MethodRef, String> fObj = MethodRef::methRef;
        System.out.println(fObj.apply(new MethodRef()));
	}
}

class MethodRef {
	
	// for Method Reference => method param should be same. Method name & return type doesn't matter only if its void
	public int print1(String str) { 
		System.out.println("Hello " + str);
		return 0;
	}
	
	public static void print2(String str) {
		System.out.println("Hey " + str);
	}
	
	public String methRef() {
		return this.toString();
	}
}

interface MethRefInt {
	void printFromInterface(String str);
}

interface ConstRefInt {
	ConstRefCls method();
	
	/*
	 * To work with this below commented method, 
	 * Need to uncomment constRefInt4 method call, and comment rest
 	 * What happens is it'll create instance, but it won't be called 
 	 * When it'll call? if we call FI method 
	 * If it has 1 param, it'll call 1 param constructor,
	 * no param? then call non Param constructor
	 */
//		ConstRefCls method(int i); 
}

class ConstRefCls {
	public ConstRefCls() {
		System.out.println("NP constructor");
	}
	public ConstRefCls(int i) {
		System.out.println(i + "-P construcor");
	}
}

interface MethodRefArr {
    int[] createArray(int length);
}
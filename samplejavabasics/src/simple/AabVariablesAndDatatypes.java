package simple;

public class AabVariablesAndDatatypes {

	/*
	 * The var keyword in Java is specifically designed for local variable type inference, 
	 * meaning it can only be used to declare local variables within 
	 * methods, constructors, initialization blocks, or for loop indexes. 
	 * It cannot be used for instance variables (fields), method parameters, or return types.
	 */
	// var value = 9; // var as instance variable is not allowed
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1byte = 8bits
		boolean a = true;	//1 byte
		byte b = -128;		//1 byte
		char c = '\u0000';	//2 byte 
		short d = -32768;	//2 byte
		int e = -213648;	//4 byte
		long f = -922388;	//8 byte
		float g = 5.6f;		//4 byte
		double h = 56.7;	//8 byte
		//int const = 9; // This happens because const is a reserved keyword in Java, even though it is not actively used as part of the language.
		System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g + " " + h);
		varKeword();
	}
	
	// LVTI - Local Variable Type Inference
	private static void varKeword() { // introduced in JDK10
		String var = "8";
		System.out.println(var); // var can be used as variable, which means it's not a reserved keyword
		/*
		 * var is not a data type but rather a way to infer the type of a variable 
		 * at compile-time based on the value assigned to it. 
		 * The size of the variable in memory is determined by the actual type 
		 * that var resolves to, not by var itself.
		 */
		var a = 7; // during compilation, JVM will know it's int, so, it's still statically typed language and not dynamically typed
		//a.toString(); // it is like primitive data types, no Object types
		System.out.println(a);
		/*
		 * Java is a statically typed language, 
		 * meaning that the type of a variable is known at compile-time. 
		 * This ensures type safety and allows the compiler to catch type-related errors early.
		 * 
		 * The variable must be initialized at the time of declaration. 
		 * This is because var is not a type itself 
		 * but a way to let the compiler infer the type based on the value assigned to it. 
		 * Without an initial value, the compiler has no way to determine what type the variable should be.
		 */
		// var b; 
		/*enum var { // var can be variableName, but not typeName = className, enumName, etc
			
		}*/
	}
}
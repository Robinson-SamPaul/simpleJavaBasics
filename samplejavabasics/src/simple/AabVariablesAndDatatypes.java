package simple;

import java.util.List;

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
//		00000000 00000000 00000000 00001001  → 9 (4 bytes) each byte with 8 bits 
		//1byte = 8bits -> 2⁸ values = 256 = -128 to 127
		boolean a = true;	//1 byte	true or false only
		byte b = -128;		//1 byte	–128 to 127
		char c = '\u0000';	//2 byte 	0 to 65,535 (Unsigned, represents Uni-code characters)
		short d = -32768;	//2 byte	–32,768 to 32,767
		int e = -213648;	//4 byte	–2,147,483,648 to 2,147,483,647
		long f = -922388;	//8 byte	–9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
		float g = 5.6f;		//4 byte	Approximately ±3.40282347 × 10³⁸ (6–7 decimal digits of precision)
		double h = 56.7;	//8 byte	Approximately ±1.79769313486231570 × 10³⁰⁸ (15 decimal digits precision)
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
		var a = 5; // during compilation, JVM will know it's int, so, it's still statically typed language and not dynamically typed
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
		 * 
		 * var can be infered at compile time. but interface can't, it'll be inferred at runtime only (runtime polymorphism)
		 * 
		 * After the type is inferred, it is locked in for that variable. You cannot assign a value of a different type later.
		 */
		// var b; 
		/*enum var { // var can be variableName, but not typeName = className, enumName, etc
			
		}*/
		
        var b = 5L;          // long
        var c = 5.5f;        // float
        var d = 5.5;         // double
        var e = 'A';         // char
        var f = true;        // boolean
        var g = (byte) 5;    // byte
        var h = (short) 5;   // short
        var i = new Object();
        // This is perfectly valid in Java
        // The var keyword tells the compiler:
        // 		"Infer the type of the variable from the expression on the right-hand side."
        i.toString();
        var j = List.of(1, 2, 3);
        j.stream().forEach(System.out::print);

        System.out.println(((Object)a).getClass().getSimpleName()); // Integer
        System.out.println(((Object)b).getClass().getSimpleName()); // Long
        System.out.println(((Object)c).getClass().getSimpleName()); // Float
        System.out.println(((Object)d).getClass().getSimpleName()); // Double
        System.out.println(((Object)e).getClass().getSimpleName()); // Character
        System.out.println(((Object)f).getClass().getSimpleName()); // Boolean
        System.out.println(((Object)g).getClass().getSimpleName()); // Byte
        System.out.println(((Object)h).getClass().getSimpleName()); // Short
	}
}
package simple;

import java.util.Arrays;
import java.util.Objects;

public class AdyMemoryManagement {
	
	public static void main(String[] args) {
		
		stringMemory();
		objectMemory();
		primitiveMemory();
		arrayMemeory();
	}

	private static void arrayMemeory() {
		int directArr1[] = {1, 2, 3, 4, 5};
		int directArr2[] = {1, 2, 3, 4, 5};
		int addArr[] = new int[5];
		for(int i : directArr1) {
			addArr[i-1] = i;
		}
		System.out.println();
		System.out.println(Arrays.toString(directArr1));
		System.out.println(directArr1.hashCode());
		System.out.println(Arrays.toString(addArr));
		System.out.println(addArr.hashCode());
		System.out.println();
		System.out.println(addArr == directArr1);
		System.out.println(addArr.equals(directArr1));
		System.out.println(directArr2 == directArr1);
		System.out.println(directArr2.equals(directArr1));
	}

	@SuppressWarnings("removal")
	private static void primitiveMemory() {
		int a = 10;
		int b = 10;
		Integer c = 10;
		Integer d = 10;
		Integer e = new Integer(10);
		Integer f = new Integer(10);
		
		System.out.println();
		System.out.println(c.hashCode());
		System.out.println(d.hashCode());
		System.out.println(e.hashCode());
		System.out.println(f.hashCode());
		System.out.println();
		
		System.out.println(a == b);
		System.out.println(c == d);
		System.out.println(c.equals(d));
		System.out.println(e == f);
		System.out.println(e.equals(f));

		Integer trial1 = 4;
		Integer trial2 = 4;
		System.out.println();
		System.out.println(trial1.hashCode());
		System.out.println(trial2.hashCode());
		System.out.println(trial1 == trial2);
		trial1++;
		System.out.println(trial1.hashCode());
		System.out.println(trial1 == trial2);
	}

	private static void stringMemory() {
		String emptyLiteral = "";
		String nullLietral = null;
		String testLiteral = "test";
		String emptyString1 = new String();
		String emptyString2 = new String("");
//		String nullString = new String(null); //CTError
		String testString1 = new String("test");
		String testString2 = new String("test");

		System.out.print(emptyLiteral + " = ");
		System.out.println(emptyLiteral.hashCode());
		System.out.print(nullLietral + " = \n");
//		System.out.println(nullLietral.hashCode()); //RTError
		System.out.print(testLiteral + " = ");
		System.out.println(testLiteral.hashCode());
		System.out.print(emptyString1 + " = ");
		System.out.println(emptyString1.hashCode());
		System.out.print(emptyString2 + " = ");
		System.out.println(emptyString2.hashCode());
		System.out.print(testString1 + "1 = ");
		System.out.println(testString1.hashCode());
		System.out.print(testString2 + "2 = ");
		System.out.println(testString2.hashCode());
		
		String str1 = new String("hello");
		String str2 = new String("hello");
		String str3 = "hello";
		String str4 = "hello";

		// == will compare memory address
		// equals will compare value
		System.out.println();
		System.out.println("Are instance1 and instance2 equal? " + (str1 == str2));
		System.out.println("Are instance1 and instance2 equal? " + str1.equals(str2));
		System.out.println();
		System.out.println("Are value1 and value2 equal? " + (str3 == str4));
		System.out.println("Are value1 and value2 equal? " + str3.equals(str4));
		System.out.println();
		System.out.println("Are instance1 and value1 equal? " + (str1 == str3));
		System.out.println("Are instance1 and value1 equal? " + str1.equals(str3));
		
//		String nullVal = null;
//		System.out.println(nullVal.hashCode()); //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.hashCode()" because "nullVal" is null
	}
	
	private static void objectMemory() {

		Memory1 withHash1 = new Memory1(1, "Shiva");
		Memory1 withHash2 = new Memory1(1, "Shiva");
		Memory2 withoutHash1 = new Memory2(1, "Shiva");
		Memory2 withoutHash2 = new Memory2(1, "Shiva");
		Memory1 withHash3 = new Memory1();
		Memory1 withHash4 = new Memory1();
		
		System.out.println();
		System.out.println("Are withHash1 and withHash2 equal? " + (withHash1 == withHash2));
		System.out.println("Are withHash1 and withHash2 equal? " + withHash1.equals(withHash2));
		System.out.println();
		System.out.println("Are withoutHash1 and withoutHash2 equal? " + (withoutHash1 == withoutHash2));
		System.out.println("Are withoutHash1 and withoutHash2 equal? " + withoutHash1.equals(withoutHash2));
		System.out.println();
		System.out.println("Are withHash3 and withHash4 equal? " + (withHash3 == withHash4));
		System.out.println("Are withHash3 and withHash4 equal? " + withHash3.equals(withHash4));
	}
}

class Memory1 {
	int id;
	String name;
	
	public Memory1(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Memory1() {}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Memory1 other = (Memory1) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "\n\t\t{id=" + id + ", name=" + name + "}";
	}
}

class Memory2 {
	int id;
	String name;
	
	public Memory2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "\n\t\t{id=" + id + ", name=" + name + "}";
	}
}
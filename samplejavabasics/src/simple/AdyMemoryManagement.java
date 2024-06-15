package simple;

import java.util.Arrays;
import java.util.Objects;

public class AdyMemoryManagement {
	
	public static void main(String[] args) {
		
		/*
		 * The memory for static variables is allocated in a special area of the JVM memory 
		 * called the "method area" (or "class area"). T
		 * his is distinct from the heap where instance variables are stored.
		 */
		
		/*
		 * A stack stores frames, also called “stack frames.” 
		 * A stack frame is created every time a new method is called
		 * New stack is created when new thread is invoked
		 * In the thread stack, thread cache will be there
		 * where each cache may have different values by visibility if v don't use volatile
		 * 
		 * stack follows LIFO, unused stacks will be deleted, main stack frame will be deleted last (LIFO)
		 * stack overflow error(stack full), stores as key-value pairs
		 * 
		 * heap unused things will be deleted by garbage collector
		 * System.gc() - even though v declare,
		 * can't guarantee, it'll be run
		 * fully depends on JVM
		 */
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
		System.out.println(Arrays.toString(directArr2));
		System.out.println(directArr2.hashCode());
		System.out.println(Arrays.toString(addArr));
		System.out.println(addArr.hashCode());
		System.out.println();
		System.out.println(addArr == directArr1);
		System.out.println(addArr.equals(directArr1));
		System.out.println(directArr2 == directArr1);
		System.out.println(directArr2.equals(directArr1));
		System.out.println(Arrays.equals(directArr1, directArr2)); // compares inner values of array
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
		
		/*
		 * System.identityHashCode() this will return strObj's address, 
		 * not strPoolCnst address
		 * 
		 * string literal will create value in stack
		 * which point to SPC
		 * string object will create object in heap
		 * which points to heap
		 * which point to SPC
		 */		
		System.err.println(str1.hashCode() + " " + System.identityHashCode(str1));
		System.err.println(str2.hashCode() + " " + System.identityHashCode(str2));
		System.err.println(str3.hashCode() + " " + System.identityHashCode(str3));
		System.err.println(str4.hashCode() + " " + System.identityHashCode(str4));

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
//		equals() from Object class and == operator will behave exactly the same, If v don't override hash and equals
		System.out.println("Are withoutHash1 and withoutHash2 equal? " + withoutHash1.equals(withoutHash2));
		System.out.println();
		System.out.println("Are withHash3 and withHash4 equal? " + (withHash3 == withHash4));
		System.out.println("Are withHash3 and withHash4 equal? " + withHash3.equals(withHash4));
		
		/*
		 * Just for our understanding, OK?
		 * Don't take this like very technical. 
		 * So, hashcode will return some ID of address 
		 * If we use contract of hashcode and equals 
		 * that is, if we override the both methods 
		 * Then we won't get different ID of same objects 
		 * To get unique address of each object we should be using
		 * "System.identityHashCode()"
		 */

		Memory1 withHash5 = withHash1;
		System.out.println(withHash1 + "\t" + withHash1.hashCode() + "\t" + System.identityHashCode(withHash1));
		System.out.println(withHash2 + "\t" + withHash2.hashCode() + "\t" + System.identityHashCode(withHash2));
		System.out.println(withoutHash1 + "\t" + withoutHash1.hashCode() + "\t" + System.identityHashCode(withoutHash1));
		System.out.println(withoutHash2 + "\t" + withoutHash2.hashCode() + "\t" + System.identityHashCode(withoutHash2));
		System.out.println(withHash5 + "\t" + withHash5.hashCode() + "\t" + System.identityHashCode(withHash5));
		withHash1.name = "Prajwal";
		withHash2.name = "Prajwal";
		System.out.println(withHash1 + "\t" + withHash1.hashCode() + "\t" + System.identityHashCode(withHash1));
		System.out.println(withHash2 + "\t" + withHash2.hashCode() + "\t" + System.identityHashCode(withHash2));
		System.out.println(withoutHash1 + "\t" + withoutHash1.hashCode() + "\t" + System.identityHashCode(withoutHash1));
		System.out.println(withoutHash2 + "\t" + withoutHash2.hashCode() + "\t" + System.identityHashCode(withoutHash2));
		System.out.println(withHash5 + "\t" + withHash5.hashCode() + "\t" + System.identityHashCode(withHash5));
		
		/*
		 * Output
		 * 
		 * Basically A and C have same address
		 * All three have same values
		 * Just because all has same values
		 * Doesn't mean changing 1 will affect another
		 * Except if it is in same address (A&C)
		 * 
		 * {id=1, name=Shiva}	    79856159	1651191114  A1 has unique hash and ID
		 * {id=1, name=Shiva}	    79856159	1586600255  B1 has same hash and different ID
		 * {id=1, name=Shiva}	    474675244	474675244	A2 has hash and ID as same, as no contract
		 * {id=1, name=Shiva}	    932583850	932583850	B2 has hash and ID as same, as no contract
		 * {id=1, name=Shiva}	    79856159	1651191114  C1 has same as A1
		 *  												name is being changed
		 * {id=1, name=Prajwal}		1342431511	1651191114	A1 hash is changed, but ID remains same
		 * {id=1, name=Prajwal}		1342431511	1586600255  B1 hash is also changed, but ID remains same
		 * {id=1, name=Shiva}	    474675244	474675244	A2 has hash and ID as same, as no contract
		 * {id=1, name=Shiva}	    932583850	932583850	B2 has hash and ID as same, as no contract
		 * {id=1, name=Prajwal}		1342431511	1651191114	C1 does same like A1

		 */
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

/*

Young Generation:
	The young generation in Java's memory management consists of two parts: 
	Eden space and survivor spaces (usually two survivor spaces, S0 and S1).
	When Java objects are first created, they are allocated in the Eden space, 
	which is a part of the young generation.
	As objects survive garbage collection cycles, they may be promoted to the survivor spaces.
New Generation:
	The term "new generation" is less commonly used than "young generation," 
	but it generally refers to the same space in Java's memory model.
	Like the young generation, the new generation includes Eden space and survivor spaces, 
	serving the same purpose of managing short-lived objects.
Non heap:
	used for meta-spaces, and stores static fields and metghods

Objects in Java's memory management move to the Survivor spaces 
during the garbage collection process in the Young Generation. 
Here's an overview of when objects are moved to the Survivor phase:

Initial Allocation:
	When objects are first created in Java, they are typically allocated in the Young Generation, 
	specifically in the Eden space.
Eden Space Collection:
	During garbage collection in the Young Generation (Minor Garbage Collection or Young Generation Garbage Collection), 
	the garbage collector identifies and removes unreachable objects from the Eden space.
	Surviving objects from the Eden space are moved to one of the Survivor spaces. 
	The Survivor spaces are usually denoted as Survivor space 1 (S1) and Survivor space 2 (S2).
Survivor Space Management:
	Initially, objects from the Eden space are moved to either Survivor space 1 or Survivor space 2, 
	depending on which Survivor space was used during the previous garbage collection cycle.
	Surviving objects in one Survivor space are aged during subsequent garbage collection cycles. 
	Each time an object survives a garbage collection cycle, its age (number of collections survived) increases.
Aging and Promotion:
	As objects in the Survivor spaces age (survive multiple garbage collection cycles), 
	they become candidates for promotion to the Old Generation.
	The JVM uses a mechanism called generational promotion to determine when objects in the Survivor spaces 
	should be promoted to the Old Generation.
	Generational promotion is based on the idea that long-lived objects tend to 
	survive multiple garbage collection cycles in the Young Generation.
Promotion to Old Generation:
	Objects in the Survivor spaces that are deemed long-lived 
	(after surviving a certain number of garbage collection cycles) are promoted or tenured to the Old Generation.
	Promotion to the Old Generation occurs during a garbage collection cycle in the Young Generation 
	when objects are identified as candidates for promotion based on their age.

class A {						
int val = 10;
void add(int a, int b) {
	Sout(a+b);
}
}

clas Main {
psvm {
	int val = 5;
	A a = new A();
	a.add(1, 2);
	A b = new A();
}
}

Main stack
val = 5
a = 101
b = 102

add stack
a = 1
b = 2

Heap
101(a)
val = 10
add()

102(b)
val =10

*/
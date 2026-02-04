package simple;

public class AicSealedClass {

	// New updates in JDK17
	public static void main(String[] args) {
		/*
		 * Abstract class must be extended
		 * Final class can't be extended
		 * 
		 * Meanwhile sealed class allows only permitted classes can be extended, not others
		 * 3 types of class can be extends sealed class
		 * 		Another Sealed class (permitted) -> again this class too allow only permitted class to extends
		 * 		Final class (permitted) ->  won't allow any class to extend
		 * 		Non-Sealed class (permitted) -> Will allow
		 */
		int sealed = 9;
		//int non-sealed = 9; // syntax error
		//int final = 9; // reserved keyword
		int permits = 9;
		//int abstract = 9; // reserved keyword
		//int extends = 9; // reserved keyword
		//int implements = 9; // reserved keyword
		System.out.println(sealed + permits);
	}
}

/*
sealed class don't allow normal class to inherit it,
but non-sealed class allow normal class.
if we extend non-sealed class from sealed class and
extend normal class from non-selaed class,
technically sealed class got extended by normal class - Imma Hacker 😎

Sealing restricts only direct subclasses. 
Allowing a non-sealed subclass is an explicit design choice that delegates further inheritance. 
This is intentional, not a loophole, and supports API evolution and pattern matching.
 */
sealed class SealedClass permits SubSeal1, SubSeal2, SubSeal3 {} // Main class
/*1*/final class SubSeal1 extends SealedClass {} // Sub final class
/*2*/sealed class SubSeal2 extends SealedClass permits SubSubSeal1 {} // Sub sealed class
		final class SubSubSeal1 extends SubSeal2 {} // Sub->sub sealed class
/*3*/non-sealed class SubSeal3 extends SealedClass {} // Sub non-sealed class
		class SubSubSeal2 extends SubSeal3 {} // Sub->sub non-sealed class, will allow any class to extend
		// non-sealed class SubSeal3 {} // can't use it alone
		// sealed class SealedClass2 {} // can't use it alone
		
//Let's try for Interface
sealed interface SealedInterface permits Intrfs1, Intrfs2, Class1, Class2, Class3 {}
/*1*/sealed interface Intrfs1 extends SealedInterface permits SubIntrfs1 {}
		//final interface SubIntrfs1 extends Intrfs1{}
		non-sealed interface SubIntrfs1 extends Intrfs1{}
		
/*2*/non-sealed interface Intrfs2 extends SealedInterface {}

/*3*/sealed class Class1 implements SealedInterface permits ClassSub1 {}
		final class ClassSub1 extends Class1 {}
		
/*4*/non-sealed class Class2 implements SealedInterface {}		

/*5*/final class Class3 implements SealedInterface {}

package simple;

public class AazAbstraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Abstracts a = new Abstracts() {
			
			@Override
			void show() {
				// TODO Auto-generated method stub
				System.out.println("Anonymous inner class");
			}
		};
		a.display();
		a.show();
		Abs a2 = new Abs();
		a2.display();
		a2.show();
	}

}

abstract class Abstracts {
	abstract void show();
	void display() {
		System.out.println("Non-Abstract Method");
	}
}

class Abs extends Abstracts {
	void show() {
		System.out.println("Anonymous local class");
	}
}
/*
Instantiation:
	Abstract class: Cannot be instantiated directly. 
		Super obj = new Super() is not possible, even if u have constructor
		must be Super obj = new Sub(); "inside Sub() {super()}"
	Interface: Cannot be instantiated at all. Except Anonymous class (Anonymous Inner class)
Multiple Inheritance:
	Abstract class: A class can extend only one abstract class.
	Interface: A class can implement multiple interfaces.
Methods:
	Abstract class: Can have both abstract and concrete methods.
	Interface: Can have only abstract methods (until Java 8), but can have default and static methods as well.
Fields:
	Abstract class: Can have instance variables with any access modifier.
	Interface: Can have only public, static, and final fields.
Constructors:
	Abstract class: Can have constructors.
	Interface: Cannot have constructors.
	
Abstract classes do NOT allow multiple inheritance.
Interfaces allow multiple inheritance but PREVENT the diamond problem by forcing explicit resolution (compile time error).
*/
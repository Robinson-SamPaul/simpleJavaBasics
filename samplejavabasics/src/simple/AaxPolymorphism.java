package simple;

public class AaxPolymorphism {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodOverloading mold = new MethodOverloading();
		mold.show();
		mold.show("Sam"); // overloading
		MethodOverriding movr = new MethodOverriding();
		movr.show(); // overriding
		MethodOverloading mvrld = new MethodOverriding();
		mvrld.show(); // overriding
		mvrld.display(); // method hiding
	}
}

class MethodOverloading {
	void show() {
		System.out.println("Hi there");
	}
	void show(String s) {
		System.out.println("Hi " + s);
	}
	static void display() {
		System.out.println("Bye");
	}
}

class MethodOverriding extends MethodOverloading{
	void show() {
		System.out.println("Hello there");
	}
	static void display() {
		System.out.println("Tata");
	}
}

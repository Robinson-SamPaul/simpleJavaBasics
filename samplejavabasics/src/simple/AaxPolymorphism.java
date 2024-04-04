package simple;

public class AaxPolymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodOverloading mold = new MethodOverloading();
		mold.show();
		mold.show("Sam"); // overloading
		MethodOverriding movr = new MethodOverriding();
		movr.show(); // overriding
		MethodOverloading mvrld = new MethodOverriding();
		mvrld.show(); // overriding

	}

}

class MethodOverloading {
	void show() {
		System.out.println("Hi there");
	}
	void show(String s) {
		System.out.println("Hi " + s);
	}
}

class MethodOverriding extends MethodOverloading{
	void show() {
		System.out.println("Hello there");
	}
}

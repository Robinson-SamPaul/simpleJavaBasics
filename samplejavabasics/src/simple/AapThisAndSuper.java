package simple;

public class AapThisAndSuper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Second s = new Second("Sun");
		s.show();
//		First f = new Second("Fun");
	}

}

class First {
	String str1;
	First() {
		System.out.println("Super Non-parameterized Constructor");
	}
	First(String str1) {
		this();
		this.str1 = str1;
		System.out.println("Super Parameterized Constructor " + str1);
	}
	void display() {
		System.out.println("Super method");
	}
}
class Second extends First {
	Second() {
//		super(); // by default it'll call the super non parameterized constructor
		System.out.println("Sub Non-parameterized constructor");
	}
	Second(String str2) {
//		super(); // by default it'll call the super non parameterized constructor
		super(str2);
//		super.str1 = str2;
		System.out.println("Sub Parameterized Constructor " + str2);
	}
	void display() {
		System.out.println("Sub method");
	}
	void show() {
		this.display(); // by default it'll call the current class method
		super.display();
	}
}
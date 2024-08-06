package simple;

public class AcoInterfaceMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfaceMethods a = () -> System.out.print("Hello");
		a.show(); // by default it's abstract and public
		a.display(); // using default keyword we can define methods
		InterfaceMethods.scene(); // similar to default methods can call with interface name
		
		System.out.println();
		InterfaceFields fields = b -> {
			System.out.println("Param value " + b);
			System.out.println("Interface field " + InterfaceFields.a);
		};
		fields.display(7);
		fields.show1();
		InterfaceFields.show2();
	}
}

interface InterfaceMethods {
	
	void show();
	
	default void display() {
		System.out.print(" World");
	}
	
	static void scene() {
		System.out.print("!");
	}
//	static void equals(Object o) { // interface methods can't override Object class methods
//		System.out.println(o.toString());
//	}
}

interface InterfaceFields {
	int a = 9;
	void display(int a);
	default void show1() {
		System.out.println("Default method " + a);
	}
	static void show2() {
		System.out.println("Default method " + a);
	}
}
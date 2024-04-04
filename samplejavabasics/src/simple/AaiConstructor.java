package simple;

public class AaiConstructor {
	
	AaiConstructor() {
		// TODO Auto-generated constructor stub
		System.out.println("Constructor");
	}
	AaiConstructor(int i) {
		System.out.println("Parameterized Constructor");
	}
	
	void show() {
		System.out.println("method");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AaiConstructor obj1 = new AaiConstructor();
		obj1.show();
		AaiConstructor obj2 = new AaiConstructor(7);
		obj2.show();

	}

}

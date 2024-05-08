package simple;

public class AcbClassLoader {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Class.forName("simple.Loader");
	}

}

class Loader {
	static { // static block
		System.out.println("static block is called only once when class loads");
	}
	{ // instance block
		System.out.println("Instance block is called even before when constructor getting called everytime");
	}
	Loader() {
		System.out.println("Constructor");
	}
	/*
	 * Both constructor and instance block will be called 
	 * every time when we create instance
	 * 
	 * instance block will be called first, and then constructor
	 * in case if u r accessing class variable in instance block
	 * before constructor is called
	 * which will initialize that field
	 * then default value will be executed = null/0
	 */
}

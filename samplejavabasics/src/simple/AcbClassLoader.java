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
		System.out.println("Instance block is called only once when class loads");
	}
	Loader() {
		System.out.println("Constructor");
	}
	/*
	 * Both constructor and instance block will be called 
	 * every time when we create instance
	 */
}

package simple;

public class AcbClassLoader {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("simple.Loader");
	}

}

class Loader {
	static {
		System.out.println("static block is called only once when class loads");
	}
	Loader() {
		System.out.println("Constructor");
	}
}

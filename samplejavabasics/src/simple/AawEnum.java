package simple;

enum Mobile {
	// enum constants should be upper-case, but I did like this
	RedMi(15000), RealMe(), Samsung(21000); // when these are defined, constructor will be called internally.
	
	private int price;
	
	int getPrice() {
		return price;
	}
	
	// This constructor sets the default price to 8000. It is used when no price is provided (e.g., RealMi).
	Mobile() {
		System.out.println("Non param constructor");
		this.price = 8000;
	}
	
	// This constructor sets the price to the value provided when the enum constant is initialized (e.g., RedMi(15000)).
	Mobile(int price) {
		System.out.println("Param constructor");
		this.price = price;
	}
	
	static void print() {
		System.out.println(
				Mobile.RedMi + " = " + Mobile.RedMi.getPrice() + ", " + 
				Mobile.RealMe + " = " + Mobile.RealMe.getPrice() + ", " + 
				Mobile.Samsung + " = " + Mobile.Samsung.getPrice());
	}
}

public class AawEnum {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(Mobile.class);
		/*
		 * The issue is that enum constants are initialized when the class is loaded,
		 * and logging inside the constructors might not work as expected 
		 * due to the static initialization of the enum constants. 
		 * To ensure the loggers print messages, you need to access the enum constants in the main method. 
		 * This will trigger the initialization of the enum constants, thereby calling the constructors.
		 */
//		Class.forName("simple.Mobile"); // now both constructor is getting called, for the first time when the class loads all constructor will be called
		
		System.out.println("----------");
		System.out.println(Mobile.values());
		System.out.println(Mobile.RealMe);
		System.out.println("----------");
		Mobile m = Mobile.RealMe;
		System.out.println(m);
		System.out.println(Mobile.RealMe.getPrice());
		System.out.println("----------");
		Mobile v[] = Mobile.values();
		for(Mobile vs : v) {
			System.out.println(vs + " = $" + vs.getPrice() + " " + vs.ordinal());
		}
		Mobile.print();
		// Mobile mobile = new Mobile(); // can't do this
	}

}

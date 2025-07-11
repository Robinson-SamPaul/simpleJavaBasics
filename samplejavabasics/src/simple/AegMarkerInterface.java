package simple;

public class AegMarkerInterface {

	/*
	 * A marker interface is an interface without any methods or fields. 
	 * It’s used to "mark" or tag a class so that the 
	 * JVM or framework can recognize that the class has a special property.
	 */
	public static void main(String[] args) {
		
		Me me = new Me();
		Other other = new Other();
		if (me instanceof MarkerInterface) {
			me.show();
		} else {
			System.err.println("No permission for " + me.getClass());
		}
		if (other instanceof MarkerInterface) {
			other.show();
		} else {
			System.err.println("No permission for " + other.getClass());
		}

	}

}

interface MarkerInterface {}

class Me implements MarkerInterface {
	
	void show() {
		System.out.println("Secret revealed for " + this.getClass());
	}
}

class Other {
	
	void show() {
		System.out.println("Secret revealed for " + this.getClass());
	}
}

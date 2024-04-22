package simple;

public class AegMarkerInterface {

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

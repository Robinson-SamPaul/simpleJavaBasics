package simple;

public class AbtInnerClass {
	
	public static void main(String[] args) {
		
		OuterClass nc = new OuterClass();
		OuterClass.InnerClass ic = nc.new InnerClass();
		ic.display();
		OuterClass.StaticInnerClass sic = new OuterClass.StaticInnerClass();
		sic.show();
	}
	
}

class OuterClass {

	public class InnerClass { // inner classes can be public in one file
		
		public void display() {
			System.out.println("Inner class");
		}
	}
	public static class StaticInnerClass {
		
		public void show() {
			System.out.println("Static Inner class");
		}
	}
}



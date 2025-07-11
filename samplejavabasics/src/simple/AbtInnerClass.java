package simple;

import simple.OuterClass.InnerClassForImport;
import simple.OuterClass.StaticInnerClassForImport;

public class AbtInnerClass {
	
	/*
	 * An inner class is a class defined inside another class.
	 * Logical grouping: 
	 * 		If a class is only useful to one other class, it's logical to keep them together.
	 * Encapsulation: 
	 * 		It helps hide the inner class from other classes.
	 * Easier for inner class to access outer class members (even private ones).
	 */
	public static void main(String[] args) {
		
		OuterClass nc = new OuterClass();
		
		OuterClass.InnerClass ic = nc.new InnerClass();
		ic.display();
		
		OuterClass.StaticInnerClass sic = new OuterClass.StaticInnerClass();
		sic.show();
		
		InnerClassForImport ici = nc.new InnerClassForImport();
		ici.display();
		
		StaticInnerClassForImport sici = new StaticInnerClassForImport();
		sici.show();
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

	public class InnerClassForImport { // inner classes can be public in one file
		
		public void display() {
			System.out.println("Inner class by import");
		}
	}
	public static class StaticInnerClassForImport {
		
		public void show() {
			System.out.println("Static Inner class by import");
		}
	}
	private static class PrivateStaticInnerClass {
		
		public void view() {
			System.out.println("Static Inner class by import");
		}
	}
	private class PrivateInnerClass {
		
		public void view() {
			System.out.println("Static Inner class by import");
		}
	}
	public void callView() {
		new OuterClass().new PrivateInnerClass().view();
		new OuterClass.PrivateStaticInnerClass().view();
	}
}



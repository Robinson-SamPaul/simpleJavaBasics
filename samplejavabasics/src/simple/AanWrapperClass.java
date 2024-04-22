package simple;

public class AanWrapperClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5;
		@SuppressWarnings("removal")
		Integer b = new Integer(a); // boxing
		int c = b.intValue(); // unboxing
		Integer d = c; // autoboxing
		int e = d; // autounboxing
		System.out.println(e);
		
		int primitiveVal = Integer.parseInt("12");
		Integer wrapperVal = Integer.valueOf("12");
		System.err.println(primitiveVal == wrapperVal);
	}

}

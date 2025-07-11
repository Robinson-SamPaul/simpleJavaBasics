package simple;

public class AanWrapperClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5;
		@SuppressWarnings("removal")
		Integer b = new Integer(a); // boxing
		b = Integer.valueOf(a); // boxing
		int c = b.intValue(); // un-boxing
		Integer d = c; // auto-boxing
		int e = d; // auto-unboxing
		System.out.println(e);
		
		int primitiveVal = Integer.parseInt("12");
		Integer wrapperVal = Integer.valueOf("12");
		System.err.println(primitiveVal == wrapperVal);
	}

}

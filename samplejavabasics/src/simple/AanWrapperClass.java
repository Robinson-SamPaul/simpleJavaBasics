package simple;

public class AanWrapperClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a = 5;
//		Integer b = new Integer(a); // boxing
		Integer b = 5; // warning remover
		int c = b.intValue(); // unboxing
		Integer d = c; // autoboxing
		int e = d; // autounboxing
		System.out.println(e);
	}

}

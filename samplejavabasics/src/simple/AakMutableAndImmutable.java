package simple;

public class AakMutableAndImmutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer a = new Integer(3);		
//		Integer b = new Integer(3);
		int c = 4;
		int d = 4;
		Integer e = 5;
		Integer f = 5;
		
//		System.out.print(System.identityHashCode(a) + "\n" + System.identityHashCode(b));
		System.out.println("\n" + System.identityHashCode(c) + "\n" + System.identityHashCode(d) + "\n" + System.identityHashCode(e) + "\n" + System.identityHashCode(f));

	}

}

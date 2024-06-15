package simple;

public class AacOperatorsAndConcate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = 1 + 2 * 3 / 4; // BODMAS
		int i = 1;
		int b = i++ + ++i;
		boolean c = 5 >= 6;
		boolean d = true && false;
		@SuppressWarnings("unused")
		char e = 5 >= 6 ? '8' : '5';
		int f = 2 & 3;
		int g = 2<<2;
		System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g);
		System.out.println(e);		
	}
}

package simple;

public class AckSystemDot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 7;
		String s = "!";
		char c = 'd';
		float f = 0.7f;
		System.out.format("Hello Worl%c%s %d + %f\n", c, s, i, f); // decimal - f, normal - d
		System.out.println(String.format("Hello Worl%c%s %d + %f", c, s, i, f)); 
	}

}

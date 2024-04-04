package simple;

public class AalArrayAndInstanceof {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new String("ghh");
		System.out.println(s instanceof String);
		
		int a[] = {0, 1, 2, 3, 4},i;
		int b[] = new int[5];
		for(i = 0; i < a.length; i++) {
			b[i] = i + 5;
		}
		for(i = 0; i < 5; i++) {
			System.out.println(String.format(("%x %x"),a[i],b[i]));
		}
	}

}

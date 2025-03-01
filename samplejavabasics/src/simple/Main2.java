package simple;

public class Main2 {

	public static void main(String[] args) {
		int a = 4, b = 5;
		System.out.println(a + " " + b);
		a=a+b-(b=a);
		System.out.println(a + " " + b); 
		if(null == System.out.printf("Cats")) {
			System.out.println("Cat");
		} else {
			System.out.println("Dog");
		}
	}
}

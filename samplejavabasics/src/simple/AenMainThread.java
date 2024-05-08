package simple;

public class AenMainThread {

	public static void main(String[] args) {

		System.out.println("Start");
		MainNonThread.display();
		System.out.println("End"); // executed after very long time
	}

}

class MainNonThread {
	
	protected static void display() {
	
		for (int i=0; i<5; i++) {
			sleep(2000);
			System.out.println("Hello world");
		}
	}
	
	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

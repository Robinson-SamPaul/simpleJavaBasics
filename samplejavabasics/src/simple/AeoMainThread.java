package simple;

public class AeoMainThread {

	public static void main(String[] args) {

		System.out.println("Start");
		MainThread thread = new MainThread();
		thread.start();
		System.out.println("End"); // executed after very long time
	}

}

class MainThread extends Thread {
	
	public void run() {
	
		for (int i=0; i<5; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Hello world");
		}
	}
}

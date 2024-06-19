package simple;

public class AepStartVsRun {

	public static void main(String[] args) {

		startLoopy();
		
		checkAlive();
		
		threadLoopy(); // good way
		
		threadAndRunLoopy();

		onlyRunLoopy();
	}
	
	private static void startLoopy() {
		System.out.println("----------Start");
		StartOrRun thread1 = new StartOrRun();
		for (int i=0; i<10; i++) {
			try {
				thread1.start(); // thread can be start only once, 2nd time exception
			} catch (Exception e) {
				System.out.println(e);
				break;
			}
		}
		System.out.println("----------End\n");
	}
	
	private static void checkAlive() {
		System.out.println("----------Start");
		StartOrRun thread2 = new StartOrRun();
		for (int i=0; i<10; i++) {
			if (thread2.isAlive()) { // thread not even started, so no alive
				thread2.start();			
			}
		}
		System.out.println("----------End\n");
	}
	
	private static void threadLoopy() {
		System.out.println("----------Start");
		for (int i=0; i<10; i++) {
			StartOrRun thread3 = new StartOrRun();
			thread3.start();
		}
		System.out.println("----------End\n");
	}
	
	private static void threadAndRunLoopy() {
		System.out.println("----------Start");
		for (int i=0; i<10; i++) {
			StartOrRun thread4 = new StartOrRun();
			thread4.run();
		}
		System.out.println("----------End\n");
	}
	
	private static void onlyRunLoopy() {
		StartOrRun thread5 = new StartOrRun();
		System.out.println("----------Start");
		for (int i=0; i<10; i++) {
			thread5.run();
		}
		System.out.println("----------End\n");
	}
}

class StartOrRun extends Thread {
	
	public void run() {
		System.out.println("Hello" + StartOrRun.currentThread().getId());
		System.out.println("World" + StartOrRun.currentThread().getId());
		System.out.println("Bye" + StartOrRun.currentThread().getId());
	}
}

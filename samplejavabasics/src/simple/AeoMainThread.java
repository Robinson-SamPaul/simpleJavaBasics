package simple;

public class AeoMainThread {

	public static void main(String[] args) {

		System.out.println("Thread Start");
		MainThread thread = new MainThread();
		thread.start();
		System.out.println("Thread End");

		System.out.println("Runnable Start");
		MainRunnable runnable = new MainRunnable();
		// runnable.start();
		runnable.run(); // Thread class have start method, not runnable interface
		System.out.println("Runnable End"); // this way is not asynchronous
		
		System.out.println("RunThread Start");
		MainRunnable runnableWithThread = new MainRunnable();
		Thread runThread = new Thread(runnableWithThread);
		runThread.start();
		System.out.println("RunThread End"); // this way is asynchronous
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

class MainRunnable implements Runnable {
	
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

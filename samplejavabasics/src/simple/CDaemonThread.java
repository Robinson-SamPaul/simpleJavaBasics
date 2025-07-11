package simple;

/*
 * A daemon thread is a background thread that runs in the background and 
 * automatically dies when all normal (non-daemon) threads finish.
 */
public class CDaemonThread {
	public static void main(String[] args) {
		daemonThread();
		threadGroup();
		interruptedThread();
	}

	private static void interruptedThread() {
		Thread thread = new Thread(() -> {
			try {
				System.out.println("Thread is going to sleep");
				Thread.sleep(5000); // Sleep for 5 seconds
				System.out.println("Thread woke up");
			} catch (InterruptedException e) {
				System.out.println("Thread was interrupted during sleep");
				e.printStackTrace();
				System.out.println(Thread.currentThread().isInterrupted());
				Thread.currentThread().interrupt(); // Preserve interrupt status
				System.out.println(Thread.currentThread().isInterrupted());
			}
		});

		thread.start();

		// Interrupt the thread after a short delay
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		thread.interrupt();
	}

	private static void daemonThread() {
		Thread daemonThread = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000);
					System.out.println("Daemon thread is running...");
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		/*
		 * Daemon threads are special types of threads that run in the background and do
		 * not prevent the JVM from exiting when all user threads have finished
		 * execution. They are typically used for background tasks like monitoring or
		 * housekeeping.
		 */
		daemonThread.setDaemon(true);
		// if it is true, then when the main (current) thread finishes, running thread
		// also will be done, whether it's completed or not
		daemonThread.start();

		System.out.println("Main thread exiting...");
	}

	private static void threadGroup() {
		/*
		 * A thread group is a way to manage and organize multiple threads. It allows
		 * for operations on a group of threads as a single unit, such as setting
		 * priorities or interrupting all threads in the group.
		 */
		ThreadGroup group = new ThreadGroup("MyThreadGroup");

		Thread thread1 = new Thread(group, () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Thread 1 running");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		Thread thread2 = new Thread(group, () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Thread 2 running");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		thread1.start();
		thread2.start();

		// Wait for threads to finish
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		System.out.println("All threads in the group have finished");
	}
}
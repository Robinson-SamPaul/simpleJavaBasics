package simple;

public class AeqJoinMethod {

	public static void main(String[] args) {

		System.out.println(AbyRunnable.class);
		
		StartOrRun thread3 = null;
		System.out.println("----------Start");
		for (int i=0; i<10; i++) {
			thread3 = new StartOrRun();
			thread3.start();
		}
		try {
			/*
			 * thread.join(5000);
			 * You're telling the current thread (e.g., main) to wait 
			 * up to 5000 ms for the thread to finish its execution.
			 * If thread finishes before 5 seconds → the current thread resumes immediately.
			 * If thread doesn't finish within 5 seconds → the current thread resumes after waiting 5 seconds.
			 */
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("----------End\n"); // join will make this line be executed at end
	}
}

package simple;

public class AeqJoinMethod {

	public static void main(String[] args) {
		
		StartOrRun thread3 = null;
		System.out.println("----------Start");
		for (int i=0; i<10; i++) {
			thread3 = new StartOrRun();
			thread3.start();
		}
		try {
			thread3.join(); // join will make this thread to join main thread
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("----------End\n"); // join will make this line be executed at end
		
		/* Refer for interface */
		AbyRunnable runnableInterface = new AbyRunnable();
		System.out.println(runnableInterface);
	}
}

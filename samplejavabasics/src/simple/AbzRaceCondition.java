package simple;

public class AbzRaceCondition {

	/*
	 * A race condition is a concurrency bug that occurs when multiple threads access and modify shared data at the same time, 
	 * and the final result depends on the timing (race) of thread execution rather than the program’s logic.
	 */
	public static void main(String[] args) throws InterruptedException {

		Counter c = new Counter();

		Runnable obj1 = () -> {

			for(int i=0; i<100000; i++) {

				c.increment();
			}
		};
		
		Runnable obj2 = () -> {

			for(int i=0; i<100000; i++) {

				c.increment();
			}
		};

		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);

		t1.start();
		t2.start();
		
		t1.join(); // it'll finish this t1 obj's method and start main method.
		t2.join();
		
		System.out.println(c.count);
	}
}

class Counter {
	
	int count;
	
//	public void increment() {
	public synchronized void increment() { // only one thread can execute this method at a time.
		
		++count;
	}
}

// if join isn't used, there's a chance main will be executed before other methods.
// if synchronized isn't used, there's a chance 2+ methods will be executed at a time which spoils mutation.
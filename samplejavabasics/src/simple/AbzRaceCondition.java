package simple;

public class AbzRaceCondition {

	public static void main(String[] args) throws InterruptedException {

		Counter c = new Counter();

		Runnable obj1 = () -> {

			for(int i=0; i<1000; i++) {

				c.increment();
			}
		};
		
		Runnable obj2 = () -> {

			for(int i=0; i<1000; i++) {

				c.increment();
			}
		};

		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);

		t1.start();
		t2.start();
		
		t1.join(); // it'll finish this t1 obj's method and start main method.
		t2.join();
		
		System.out.println(Counter.count);
	}
}

class Counter {
	
	static int count;
	
//	public void increment() {
	public synchronized void increment() { // only one thread can execute at a time.
		
		++count;
	}
}

// if join isn't used, there's a chance main will be executed before other methods.
// if synchronized isn't used, there's a chance 2+ methods will be executed at a time which spoils mutation.
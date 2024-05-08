package simple;

public class AeuVolatileSynchronized {
    
	private volatile int counter = 0; // Volatile counter variable

    public synchronized void increment() {
        counter++; // Increment the counter within a synchronized method
    }

    public int getCounter() {
        return counter; // Getter method for the counter
    }

    public static void main(String[] args) {
    	
    	AeuVolatileSynchronized counterExample = new AeuVolatileSynchronized(); // Shared counter object

        // Creating multiple threads to increment the counter concurrently
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counterExample.increment(); // Increment the counter using synchronized method
                }
            });
            threads[i].start(); // Start each thread
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join(); // Wait for thread to finish
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Print the final value of the counter
        System.out.println("Final counter value with volatile and synchronized: " + counterExample.getCounter());
    }
}


package simple;

import java.util.concurrent.atomic.AtomicInteger;

public class AevAtomicVariable {
	
	/* 
	 * shared mutable object during threads
	 * thread safe 
	 */

    public static void main(String[] args) {
    	
    	AtomicInteger counter = new AtomicInteger(0);

        // Creating multiple threads to increment the counter concurrently
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.incrementAndGet(); // Increment the counter using atomic operation
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
        System.out.println("Final counter value with AtomicInteger: " + counter);
    }
}

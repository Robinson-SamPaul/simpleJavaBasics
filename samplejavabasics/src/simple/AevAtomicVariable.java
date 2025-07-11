package simple;

import java.util.concurrent.atomic.AtomicInteger;

public class AevAtomicVariable {
	
	/* 
	 * shared mutable object during threads
	 * thread safe 
	 */
	
	/*
	Atomicity: 
		Provides atomic operations (e.g., increment, compare-and-set) without the need for explicit synchronization.
	Performance: 
		Typically more performant than using synchronized for simple atomic operations 
		because they use low-level hardware support for atomicity.
	Visibility: 
		Guarantees visibility and atomicity of updates, so you don't need additional volatile or synchronized keywords.
	 */

	static int intValue = 0;
	/*
	 * The JVM acquires a monitor lock on the object (or class, if static).
	 * Only one thread can enter this block at a time.
	 * It guarantees mutual exclusion, but:
	 * 		Context switching
	 * 		Lock acquisition and release
	 * 		Thread contention
	 */
	static volatile int volValue = 0;
    public static void main(String[] args) {
    	
    	/*
    	 * Internally uses:
    	 * 	Compare-And-Swap (CAS):
    	 * 		if currentValue == expectedValue, then set newValue
    	 * 		All done in a single atomic CPU instruction (like LOCK CMPXCHG on x86)
    	 * 	Benefits:
    	 * 		No threads are blocked
    	 * 		No context switching
    	 * 		Much faster under high contention
    	 * 		Still guarantees atomicity
    	 */
    	AtomicInteger counter = new AtomicInteger(0);

        // Creating multiple threads to increment the counter concurrently
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.incrementAndGet(); // Increment the counter using atomic operation
                    intValue++;
                    increment();
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
        System.out.println("Final counter value without AtomicInteger: " + intValue);
        System.out.println("Final counter value with Volatile & synchronised Integer: " + volValue);
    }
    
    public synchronized static void increment() {
    	volValue++;
    }
}

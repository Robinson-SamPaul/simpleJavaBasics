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
		
	CAS concept - “Update the value only if it has not changed since I last saw it.”
		When we create multiple threads, it will the read the value and store it in 'expected value'
		Once threads start the processing, it will compare the expected value with main memory value.
		If both are same, then it proceeds with the process.
		Or else, it will know some other thread is doing some thing,
		So, it will simply retry until comparison passes (not waiting, but retrying continuously, this process is called starvation)
		This internally uses 'volatile' hence the expected value will be updated and main memory too,
		As 'volatile' provides visibility guarantee.
		
	Example
		AtomicInteger starts with value 3		
		Thread A reads the value using get() and stores 3 as its expected value
		CAS compares expected (3) with current value (3) → success		
		Thread A updates the value to 4
		Because the atomic field is volatile, the updated value 4 is immediately visible to other threads		
		Thread B attempts CAS with an old expected value (3) → fails
		Thread B re-reads the current value (4), which becomes its new expected value
		Thread B retries CAS using the new expected value
		During retries, Thread B is running, not waiting
		If retries continue for a long time due to contention, this situation is called starvation

	Atomic variables give atomicity without blocking
	Synchronized gives atomicity by blocking
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

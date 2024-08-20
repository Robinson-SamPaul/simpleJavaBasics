package simple;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EexplicitLocks {

	/*
	 * ReentrantLock class from the java.util.concurrent.locks package provides a more flexible locking mechanism 
	 * than the built-in synchronized blocks. It supports advanced locking capabilities, including try-locking and reentrant behavior.
	 */
    private final Lock lock = new ReentrantLock();

    /*
     * synchronized:
		Simpler and easier to use for straightforward synchronization needs.
		Automatically manages locking and unlocking.
		Does not provide advanced features like try-lock or explicit condition variables.
	ReentrantLock:		
		Provides more control and flexibility for complex synchronization scenarios.
		Allows non-blocking attempts to acquire a lock and supports timeouts.
		Includes support for condition variables to facilitate more sophisticated thread coordination.
     */
    public void performTask() {
        boolean isLocked = false;
        try {
            // lock.tryLock(); attempts to acquire the lock. 
        	// It returns true if the lock was acquired successfully, otherwise false.
            isLocked = lock.tryLock(); // Try to acquire the lock, non-blocking
            /*Above code will lock the EexplicitLocks's instance*/
            if (isLocked) {
                // Critical section
                System.out.println(Thread.currentThread().getName() + " acquired the lock.");
                // Perform some work
            } else {
                // Lock not acquired
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock.");
            }
        } finally {
        	System.out.println("checking if it's locked or not : " + isLocked);
            if (isLocked) {
                // Release the lock if it was acquired
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " released the lock.");
            }
        }
    }

    public static void main(String[] args) {
        EexplicitLocks example = new EexplicitLocks();

        Runnable task = example::performTask;

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");

        t1.start();
        t2.start();
    }
}


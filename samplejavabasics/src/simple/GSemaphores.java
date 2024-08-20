package simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Semaphore;

public class GSemaphores implements Runnable {

	ArrayList<Integer> sr;
	Semaphore sem;
	String threadName;

	public GSemaphores(ArrayList<Integer> sr, Semaphore sem) {
		this.sr = sr;
		this.sem = sem;
	}

	@Override
	public void run() {
		try {
			threadName = Thread.currentThread().getName();
			System.out.println(threadName + " is waiting for the semaphore...");
			sem.acquire();
			//sem.acquire(2); // we can also specify permit count here
			System.out.println(threadName + " has ACQUIRED the semaphore! ");
			Thread.sleep((long) (Math.random() * 1000) * 5);
			sem.release();
			System.out.println(threadName + " has RELEASED the semaphore. ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> sharedRes = new ArrayList<>();
		/*Semaphore Initialization: Creates a Semaphore with 2 permits. 
		This means up to 2 threads can access the critical section simultaneously.*/
		Semaphore sem = new Semaphore(2); // public Semaphore(int permits) {
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new GSemaphores(sharedRes, sem), "Task-" + i);
			t.start();
		}
		// Read it later
		Collections.synchronizedCollection(null);
		Collections.synchronizedMap(null);
		Collections.synchronizedSet(null);
		Collections.synchronizedList(null);
	}
}

/*
 Collections.synchronizedList(new ArrayList<String>())
	This approach creates a synchronized (thread-safe) wrapper around an ArrayList using Collections.synchronizedList(). 
	The ArrayList itself is not thread-safe, but the wrapper ensures thread-safe access to the list.
 CopyOnWriteArrayList<String>
	CopyOnWriteArrayList is part of the java.util.concurrent package and provides a thread-safe implementation of List 
	where all mutative operations (e.g., add, remove) result in a new copy of the underlying array.
	
	hashtable is thread safe? check later
	ArrayList: 
		Not thread-safe, efficient for single-threaded contexts.
	Vector: 
		Thread-safe but less performant due to synchronization overhead.
	Collections.synchronizedList: 
		Provides thread safety to an existing list but requires manual synchronization for iteration.
	CopyOnWriteArrayList: 
		Thread-safe, handles concurrent modifications gracefully with higher write overhead, 
		suitable for scenarios with frequent reads and infrequent writes.
 */ 

package simple;

public class AetWaitNotify {
    
	/*
	 * wait()
		Pauses the thread and releases the lock (monitor)
		Must be called inside a synchronized block on the object you're waiting on
		Can be woken up by notify() or notifyAll()
		Used in inter-thread communication
	 * sleep()
		Pauses the thread for a specific time (e.g., 1000 ms)
		Does not release any lock
		Can be used anywhere, no synchronized needed
		Often used to simulate delay or polling
	 * monitor
	 	A monitor is a locking mechanism attached to every object 
	 	[its like a key to unlock the locking, one key for one object, 
	 	if the object is not locked, then key is not needed to access the object]
	 	
	 	If code is inside synchronized(lock), a thread must acquire the lock’s monitor to execute that code.
		If code is not synchronized, a thread can access the object freely without using the monitor.
		
		wait() and notify() must be called inside a synchronized block 
		because they operate on the object’s monitor, 
		and the JVM requires the calling thread to own that monitor to perform these operations safely and correctly.
	 */
	public static void main(String[] args) {

		StringBuilder message = new StringBuilder(); // Shared message object

        // Creating a thread to produce a message
        Thread producerThread = new Thread(() -> {
            synchronized (message) {
                System.out.println("Producer thread is producing a message...");
                message.append("Hello from Producer!");
                try {
                    Thread.sleep(1000); // Simulate some processing time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                message.notify(); // Notify waiting consumer thread
            }
        });

        // Creating a thread to consume the message
        Thread consumerThread = new Thread(() -> {
            synchronized (message) {
                try {
                    System.out.println("Consumer thread is waiting for a message...");
                    message.wait(); // Wait for producer to notify
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Consumer thread received message: " + message);
            }
        });

        consumerThread.start(); // Start consumer thread
        try {
            Thread.sleep(1000); // Simulate some processing time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        producerThread.start(); // Start producer thread
    }
}

/*
 * Story:
		Kid A enters				Thread1 runs
		Kid A takes the key			It acquires the monitor
		Toy box is now locked		It locks the object
		Kid A checks box			Checks condition
		Toy missing						``
		Kid A says: “I will wait”	
		Kid A puts the key back		Unlocks the object
		Kid A goes to waiting area	Thread1 goes waiting state
		
		Kid B enters				Thread2 runs
		Kid B takes the key			It acquires the monitor
		Toy box is now locked		It locks the object
		Kid B puts toy				Corrects condition
		Kid B says: “Notified A”	Notify the Thread1
		Kid B puts the key back		Unlocks the object
		
		Kid A enters				Thread1 runs
		Kid A takes the key			It acquires the monitor
		Toy box is now locked		It locks the object
		Kid A checks box			Checks condition
		Toy is there				Thread1 completed
 */ 

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

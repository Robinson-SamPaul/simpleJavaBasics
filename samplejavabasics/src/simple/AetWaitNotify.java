package simple;

public class AetWaitNotify {
    
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

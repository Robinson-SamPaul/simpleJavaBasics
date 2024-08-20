package simple;

import java.util.LinkedList;
import java.util.Queue;

public class FProdConsThreads {
	
	/* NEED TO CHECK THESE LATER, AS NO TIME NOW
	 * 
	 * Reentrant Lock
	 * try lock
	 * read lock
	 * write lock
	 * Stamped Lock
	 * ArrayBlockingQueue
	 */

	public static void main(String[] args) {
		SharedQueue sharedQueue = new SharedQueue(new LinkedList<String>(), 2);

		Producer producer = new Producer(sharedQueue);
		Consumer consumer = new Consumer(sharedQueue, "ConsumerOne", 10);

		Thread p = new Thread(producer, "Producer Thread");
		Thread c = new Thread(consumer, "Consumer Thread");

		p.start();
		c.start();
	}
}

class Producer implements Runnable {
	SharedQueue sharedQueue;

	public Producer(SharedQueue sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	String[] items = { "ItemOne", "ItemTwo", "ItemThree", 
			"ItemFour", "ItemFive", "ItemSix", "ItemSeven", 
			"ItemEight","ItemNine", "ItemTen" };

	public void produce(String item) throws InterruptedException {
		synchronized (sharedQueue) {
			if (sharedQueue.queue.size() >= sharedQueue.capacity) {
				System.out.println("Queue is full. Producer is waiting...");
				sharedQueue.wait();
				System.out.println("Producer has woken up");
			}
		}

		synchronized (sharedQueue) {
			sharedQueue.queue.add(item);
			System.out.println("Produced : " + item);
			sharedQueue.notify();
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < items.length; i++) {
			try {
				Thread.sleep((long) (Math.random() * 1000) * 5);
				produce(items[i]);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("The producer has run its course");
	}
}

class Consumer implements Runnable {

	SharedQueue sharedQueue;
	String consumerName;
	int consumerCapacity;

	public Consumer(SharedQueue sharedQueue, String name, int capacity) {
		this.sharedQueue = sharedQueue;
		this.consumerName = name;
		this.consumerCapacity = capacity;
	}

	public void consume() throws InterruptedException {
		synchronized (sharedQueue) {
			if (sharedQueue.queue.size() == 0) {
				System.out.println("Queue is empty. " + consumerName + " is waiting...");
				sharedQueue.wait();
				System.out.println(consumerName + " has woken up");
			}
		}

		synchronized (sharedQueue) {
			String item = sharedQueue.queue.remove();
			System.out.println(consumerName + " has consumed " + item);
			sharedQueue.notify();
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < consumerCapacity; i++) {
			try {
				Thread.sleep((long) (Math.random() * 1000) * 5);
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(consumerName + " has run its course");
	}
}

class SharedQueue {
	Queue<String> queue;
	int capacity;

	public SharedQueue(Queue<String> queue, int capacity) {
		this.queue = queue;
		this.capacity = capacity;
	}
}
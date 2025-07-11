package simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HAExecutorService {
    public static void main(String[] args) {
    	/*
    	 * Executors.newFixedThreadPool(2)	
    	 * 		Manages a pool of threads 
    	 * 		How many threads can run in parallel	
    	 * 
    	 * new Semaphore(2)
    	 * 		Controls access to resources	
    	 * 		How many threads can access a critical section
    	 */
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Define two Runnable tasks
        Runnable task1 = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is running Task 1");
        };

        Runnable task2 = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is running Task 2");
        };

        // Submit tasks to the executor
        executor.submit(task1);
        executor.submit(task2);

        // Shutdown the executor after tasks are submitted
        executor.shutdown();
    }
}

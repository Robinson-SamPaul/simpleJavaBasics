package simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HDAwaitTerminationExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " started");
            try {
                Thread.sleep(4000); // Simulate long task
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted");
            }
            System.out.println(name + " finished");
        };

        executor.submit(task);
        executor.submit(task); // valid

        executor.shutdown(); // No more tasks accepted

        try {
            System.out.println("Waiting for termination...");
            boolean finished = executor.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("All tasks done? " + finished);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread ends");
    }
}

/*
shutdown()		Gracefully shuts down the executor — lets submitted tasks finish
shutdownNow()	Forcefully shuts down — interrupts running tasks and returns waiting ones
 */ 

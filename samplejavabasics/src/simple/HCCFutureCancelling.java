package simple;

import java.util.concurrent.*;

public class HCCFutureCancelling {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Void> longTask = () -> {
            try {
                System.out.println("Started long task...");
                for (int i = 1; i <= 5; i++) {
                    Thread.sleep(1000); // Simulate long work
                    System.out.println("Processing step " + i);
                }
                System.out.println("Task completed.");
            } catch (InterruptedException e) {
                System.out.println("Task was interrupted!");
            }
            return null;
        };

        Future<Void> future = executor.submit(longTask);

        Thread.sleep(2500); // Let task run for 2.5 seconds
        System.out.println("Trying to cancel the task...");
        boolean cancelled = future.cancel(true); // true = interrupt if running
        System.out.println("Cancelled: " + cancelled);

        executor.shutdown();
    }
}

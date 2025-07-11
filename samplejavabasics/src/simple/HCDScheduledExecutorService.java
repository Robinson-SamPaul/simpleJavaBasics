package simple;

import java.util.concurrent.*;

public class HCDScheduledExecutorService {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Callable<String> task = () -> {
            System.out.println("Task is running at: " + System.currentTimeMillis());
            return "Downloaded content";
        };

        System.out.println("Scheduling task to run 5 seconds later...");
        ScheduledFuture<String> result = scheduler.schedule(task, 5, TimeUnit.SECONDS);

        // Blocks until task completes and fetches result
        String output = result.get();
        System.out.println("Task completed with result: " + output);

        scheduler.shutdown();
    }
}

/*
scheduler.scheduleAtFixedRate(task, 3, 5, TimeUnit.SECONDS); // fixed rate
scheduler.scheduleWithFixedDelay(task, 3, 5, TimeUnit.SECONDS); // fixed delay

With scheduleAtFixedRate:
	Task runs every 5 seconds, no matter how long it takes.
With scheduleWithFixedDelay:
	Task runs 5 seconds after it finishes, avoids overlap.
*/
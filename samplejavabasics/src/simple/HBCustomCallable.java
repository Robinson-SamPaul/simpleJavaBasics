package simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class HBCustomCallable implements Callable<Integer> {

    private final int taskId;

    public HBCustomCallable(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public Integer call() throws Exception {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " is working on Task-" + taskId);

        int value = new Random().nextInt(100);
        Thread.sleep(500); // simulate delay
        System.out.println(threadName + " completed Task-" + taskId + " and produced value: " + value);
        return value;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int numTasks = 10;
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futureList = new ArrayList<>();

        for (int i = 0; i < numTasks; i++) {
            Callable<Integer> task = new HBCustomCallable(i);
            Future<Integer> future = executor.submit(task);
            futureList.add(future);
        }

        System.out.println("All tasks submitted.");

        List<Integer> results = new ArrayList<>();
        for (Future<Integer> future : futureList) {
            results.add(future.get()); // blocks until result is ready
        }
        System.out.println("Results collected from all tasks: " + results);
        executor.shutdown();
    }
}

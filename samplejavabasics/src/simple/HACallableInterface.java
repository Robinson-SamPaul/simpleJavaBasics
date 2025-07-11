package simple;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HACallableInterface {
    public static void main(String[] args) throws Exception {
        // Create a thread pool with one thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> callable = new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "Sam";
			}
		};
		String a = callable.call(); // this is like thread.run()
		System.out.println(a);
		
        // Create a Callable task (returns a value)
        Callable<String> task = () -> {
            String threadName = Thread.currentThread().getName();
            Thread.sleep(1000); // simulate delay
            return threadName + " says Hello from Callable!";
        };

        Future<String> future = executor.submit(task); // this is like thread.start()

        // Do other work (optional)
        System.out.println("Main thread doing other work...");

        // Get the result from the Callable (blocks until ready)
        String result = future.get();  // like join() but for return value
        System.out.println("Result from Callable: " + result);

        // Shutdown the executor
        executor.shutdown();
    }
}

/*
Runnable task = () -> System.out.println("Running task");
Thread t = new Thread(task);
t.start();

	You create a thread manually.
	The thread executes the run() method.
	No return value.
	Cannot throw checked exceptions.
	You manage the thread life cycle yourself.
	
Callable<String> task = () -> "Task result";
ExecutorService executor = Executors.newSingleThreadExecutor();
Future<String> future = executor.submit(task);
String result = future.get(); // blocks until done

	You submit a task to a thread pool (not creating a thread manually).
	The pool runs the call() method of the Callable.
	Returns a result via Future.
	Can throw checked exceptions without handling it.
	ExecutorService manages the threads for you.
*/
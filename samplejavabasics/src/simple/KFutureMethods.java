package simple;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KFutureMethods {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            return "CompletableFuture";
        });
		System.out.println("Future Object : " + future1);
		System.out.println("Future Object : " + future1.get());
		System.out.println("Future Object : " + future1.toCompletableFuture().get());
		System.out.println();
		
		CompletionStage<String> future2 = CompletableFuture.supplyAsync(() -> {
            return "CompletionStage";
        });
		System.out.println("Future Object : " + future2);
		System.out.println("Future Object : " + ((CompletableFuture<String>) future2).get());
		System.out.println("Future Object : " + future2.toCompletableFuture().get());
		System.out.println();
		
		/*
		 * supplyAsyncCompletableFuture.supplyAsync(Supplier<U> supplier)
		 * Runs a task asynchronously and returns a CompletableFuture that holds the result.
		 */
		supplyAsync(); // running async and return value
		/*
		 * runAsync
		 * Runs a task asynchronously that doesn't return a result.
		 */
		runAsync(); // running async, won't return anything
		/*
		 * thenApply
		 * Transforms the result of the CompletableFuture when it completes. 
		 * The transformation is done using a Function.
		 */
		System.out.println("refer " + JCompletionStage.class); // return after consume and processing
		/*
		 * thenAccept
		 * Consumes the result of the CompletableFuture when it completes. 
		 * It uses a Consumer to process the result.
		 */
		System.out.println("refer " + JCompletionStage.class); // won't return after consume and processing
		System.out.println();
		/*
		 * thenCompose
		 * Chains another CompletableFuture dependent on the result of the first one. 
		 * It uses a Function to return a new CompletionStage.
		 */
		thenCompose(); // compose a new future object inside a future object
		/*
		 * thenCombine
		 * Combines the result of the current CompletableFuture with another CompletionStage using a BiFunction.
		 */
		thenCombine(); // return after consume and processing 2+ future object
		/*
		 * thenAcceptBoth
		 * Consumes the results of both this CompletableFuture and another CompletionStage using a BiConsumer.
		 */
		thenAcceptBoth(); // won't return after consume and processing 2+ future object
		/*
		 * thenRun
		 * Runs a Runnable after the CompletableFuture completes. 
		 * This is useful for running some code without needing the result.
		 */
		thenRun(); // handle or follow up
		/*
		 * handle
		 * Processes the result or handles the exception if the computation completes exceptionally.
		 */
		handle(); // handle the result or exception
	}

	private static void handle() {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            int random = (int) (Math.random() * 10);
            if (random < 5) {
                return "Success: The number is " + random;
            } else {
                throw new RuntimeException("Failed: The number was too high");
            }
        });

        CompletableFuture<String> handledFuture = future.handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Exception occurred: " + ex.getMessage());
                return "Fallback value";
            } else {
                System.out.println("Result received: " + result);
                return result;
            }
        });
        
        handledFuture.join();
	}

	private static void runAsync() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // Task to be executed asynchronously
            System.out.println("Task is running asynchronously...");
            sleep(2000); // Simulate some delay
            System.out.println("Task has finished!");
        });

        System.out.println("Main thread is done.");
        System.out.println(future.get());
	}

	private static void thenAcceptBoth() {
		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return 10;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            sleep(1500);
            return 20;
        });

        CompletableFuture<Void> combinedFuture = future1.thenAcceptBoth(future2, (result1, result2) -> {
        	System.out.println("The result from future1 is: " + result1);
            System.out.println("The result from future2 is: " + result2);
            System.out.println("The sum of both results is: " + (result1 + result2));
        });
        
        combinedFuture.join();
	}

	private static void thenCombine() throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return 10;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            sleep(1500);
            return 20;
        });

        CompletableFuture<Integer> combinedFuture = future1.thenCombine(future2, (result1, result2) -> {
            return result1 + result2;
        });

        // Process the final combined result
        System.out.println("Combined value " + combinedFuture.get());		
	}

	private static void thenRun() {
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            System.out.println("Task completed!");
            return null;
        });

        // Use thenRun to perform an action after the CompletableFuture is completed
        future.thenRun(() -> {
            // Action to perform after the task is complete
            System.out.println("Performing follow-up action...");
        });

        future.join();		
	}

	private static void thenCompose() {
        CompletableFuture<Integer> numberFuture = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return 5;
        });

        CompletableFuture<Integer> squareFuture = numberFuture.thenCompose(number -> 
            CompletableFuture.supplyAsync(() -> number * number)
        );

        squareFuture.thenAccept(square -> {
            System.out.println("The square of the number is: " + square);
        });

        squareFuture.join();		
	}

	private static void supplyAsync() {
		ExecutorService executor = Executors.newFixedThreadPool(3);

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            return "Data from source 1";
        }, executor);

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            sleep(3000);
            return "Data from source 2";
        }, executor);

        CompletableFuture<Void> allOf = CompletableFuture.allOf(future1, future2);

        allOf.thenRun(() -> {
            try {
                // Retrieve the results from the futures
                String result1 = future1.get();
                String result2 = future2.get();
                
                // Process the results
                System.out.println("Results:");
                System.out.println("Source 1: " + result1);
                System.out.println("Source 2: " + result2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
		
	}

	private static void sleep(long i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

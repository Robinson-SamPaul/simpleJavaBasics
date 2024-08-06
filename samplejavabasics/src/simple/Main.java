package simple;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

public class Main {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Create a CompletableFuture that runs a task asynchronously
		/*
		 * The CompletableFuture class in Java provides a flexible way to handle
		 * asynchronous programming. It is part of the java.util.concurrent package
		 * introduced in Java 8
		 */
		CompletableFuture<String> future = asyncMethod();
		
		System.out.println("Future : " + future);
		System.out.println("CompletableFuture : " + future.toCompletableFuture());
		System.out.println("Get : " + future.toCompletableFuture().get());
		System.out.println("Get : " + future.toCompletableFuture().get()); // can call many times
		System.out.println();

		/*
		 * thenAccept is used when you have an asynchronous computation that produces a
		 * result (T), and you want to consume that result without returning anything.
		 * It takes a Consumer as an argument, which consumes the result of the
		 * computation when it completes.
		 */
		future.thenAccept(result -> {
			System.out.println(result + "Sam");
		});

		System.out.println("Future : " + future);
		System.out.println("CompletableFuture : " + future.toCompletableFuture());
		System.out.println("Get : " + future.toCompletableFuture().get());
		System.out.println();
		
		/*
		 * thenApply is used when you have an asynchronous computation that produces a
		 * result (T), and you want to transform that result into another value (U). It
		 * takes a Function as an argument, which processes the result of the
		 * computation and returns a new value.
		 */
		CompletableFuture<Integer> length = future.thenApply(result -> {
		    return result.length(); // Transforming the result into its length
		});

		System.out.println("Future : " + length);
		System.out.println("CompletableFuture : " + length.toCompletableFuture());
		System.out.println("Get : " + length.toCompletableFuture().get());
		System.out.println();

		/*
		 * CompletionStage provides an interface for handling asynchronous computations and composing tasks. 
		 * CompletableFuture extends CompletionStage with methods
		 * for explicitly completing or canceling computations and managing their state. 
		 * Use CompletionStage for task composition and CompletableFuture for
		 * more control over task management and completion handling.
		 */
		System.out.println(CompletionStage.class);
		System.out.println(CompletableFuture.class);
		
		/*
		CompletionStage Interface:
			Represents a stage of a computation with methods to compose tasks and handle results asynchronously.
			Does not have methods for explicitly completing the stage or manipulating its state directly.
		CompletableFuture Class:
			Implements CompletionStage and provides additional methods for 
			explicitly completing, cancelling, or manipulating the future's state.
			Supports a richer set of methods for managing asynchronous computations and their results.
		*/
	}
	
	private static CompletableFuture<String> asyncMethod() {
		return CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Value = ";
		});
	}
}

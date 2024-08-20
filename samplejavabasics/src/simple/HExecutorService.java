package simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class HExecutorService implements Runnable {

	String[] urlsList;
	CountDownLatch latch;
	
	public HExecutorService(String[] urlsList, CountDownLatch latch) {
		this.urlsList = urlsList;
		this.latch = latch;
	}

	public HExecutorService(String[] urlsList) {
		this.urlsList = urlsList;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		try {
			for (String urlString : urlsList) {
				if (Thread.currentThread().isInterrupted()) {
					System.out.println("Sam");
					throw new InterruptedException(Thread.currentThread().getName() + " interrupted");
				}
				URL url = new URL(urlString);
				String filename = urlString.substring(urlString.lastIndexOf("/") + 1).trim() + ".html";
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				BufferedWriter writer = new BufferedWriter(new FileWriter("htmlfiles/" + filename));
				String line;
				while ((line = reader.readLine()) != null) {
					writer.write(line);
				}
				System.out.println(threadName + " has downloaded " + filename);
				writer.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//latch.countDown(); // added this for, countDownLatch() this method, it'll fail for scheduledExecutorServiceWithRunnable(), so comment it out only for that
	}

	public static void main(String args[]) throws InterruptedException {
		String[] urls = new String[] { 
				"https://www.skillsoft.com/blog", 
				"https://www.skillsoft.com/partners",
				"https://www.skillsoft.com/about", 
				"https://www.skillsoft.com/resources",
				"https://www.skillsoft.com/about/awards", 
				"https://www.skillsoft.com/leadership-team",
				"https://www.skillsoft.com/elearning-events", 
				"https://www.skillsoft.com/about/culture",
				"https://www.skillsoft.com/about/global-career-opportunities", 
				"https://www.skillsoft.com/case-studies",
				"https://www.skillsoft.com/news", 
				//"https://www.skillsoft.com/customer-stories?topic=&region=&industry=sports", // won't work as file name can't have symbols
				"https://www.skillsoft.com/skillsoft-support-success-and-services" };

		singleThreadDownloader(urls);
		twoThreadDownloader(urls);
		nonStoppingExecutor(urls);
		awaitTermination(urls); // even this won't stop
		countDownLatch(urls);
		threadIs12CountDownIs4(urls);
		shutdownGracefully(urls);
		futureObject(urls);
		callableInterface(urls); 
		callableWithoutExecutor(urls);
		scheduledExecutorService(urls);
		scheduledExecutorServiceWithRunnable(urls); // fixed delay vs fixed rate
	}
	
	
	private static void scheduledExecutorServiceWithRunnable(String[] urls) throws InterruptedException {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
		
		Runnable downloaderOne = new HExecutorService(Arrays.copyOfRange(urls, 0, 6));
		Runnable downloaderTwo = new HExecutorService(Arrays.copyOfRange(urls,6, urls.length));
		
		/*
		 * scheduleWithFixedDelay schedules the tasks with a fixed delay between the end of one execution and the start of the next.
		 * first time wait for 10 seconds, next time waits for 60 second for each next fOne
		 * downloaderOne starts after an initial delay of 10 seconds and then repeats every 60 seconds.
		 * downloaderTwo starts after an initial delay of 15 seconds and then repeats every 60 seconds.
		 */
		ScheduledFuture<?> fOne = executorService.scheduleWithFixedDelay(downloaderOne, 10, 60, TimeUnit.SECONDS);
		ScheduledFuture<?> fTwo = executorService.scheduleWithFixedDelay(downloaderTwo, 15, 60, TimeUnit.SECONDS);
		
		/*
		 * scheduleAtFixedRate schedules tasks to run at fixed intervals. 
		 * This is different from scheduleWithFixedDelay, which schedules tasks with a delay between the end of one execution 
		 * and the start of the next.
		 */
		/*
		 * scheduleAtFixedRate:
		 * 	Initial Delay: 5 seconds
		 * 	Period: 15 seconds
		 * 		If the task starts at 5 seconds, the next execution will start at 20 seconds, 35 seconds, etc., 
		 * 		regardless of whether the task is still running or has finished. 
		 * 		This means that if the task runs for 10 seconds, the next execution will overlap with the current execution.
		 * 
		 * scheduleWithFixedDelay:
		 *  Initial Delay: 5 second
		 *  Delay: 15 seconds
		 *  	If the task starts at 5 seconds and takes 10 seconds to complete, 
		 *  the next execution will start 15 seconds after the task finishes, so at 30 seconds. 
		 *  There will be no overlap, and each execution starts after the delay following the previous task's completion.
		 */
		//ScheduledFuture fOne = executorService.scheduleAtFixedRate(downloaderOne, 10, 60, TimeUnit.SECONDS);
		//ScheduledFuture fTwo = executorService.scheduleAtFixedRate(downloaderTwo, 15, 60, TimeUnit.SECONDS);
		
		System.out.println("The jobs have been scheduled");		
		long startTime = System.currentTimeMillis();
		
		try {
			System.out.println("Exec time for downloaderOne: " + fOne.get());
			System.out.println("Exec time for downloaderTwo: " + fTwo.get());
		} catch(ExecutionException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();		
		System.out.println("Elapsed time since scheduling:" + (endTime-startTime));
		executorService.shutdown();		
	}

	private static void scheduledExecutorService(String[] urls) throws InterruptedException {
		/*
		 * This creates a ScheduledExecutorService with a fixed thread pool of 2 threads. 
		 * This service allows you to schedule tasks for future execution.
		 */
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
		
		Callable<Long> downloaderOne = new HExecutorService2(Arrays.copyOfRange(urls, 0, 6));
		Callable<Long> downloaderTwo = new HExecutorService2(Arrays.copyOfRange(urls,6, urls.length));
		
		/*
		 * schedule is used to schedule tasks with a delay. downloaderOne is scheduled to start after a 30-second delay, 
		 * and downloaderTwo is scheduled to start after a 40-second delay.
		 */
		Future<Long> fOne = executorService.schedule(downloaderOne, 3, TimeUnit.SECONDS);
		Future<Long> fTwo = executorService.schedule(downloaderTwo, 40, TimeUnit.SECONDS);
		//executorService.scheduleAtFixedRate(null, 0, 0, null); // other options also there, try later
		//executorService.scheduleWithFixedDelay(null, 0, 0, null);
		
		System.out.println("The jobs have been scheduled");
		
		long startTime = System.currentTimeMillis();
		
		try {
			System.out.println("Exec time for downloaderOne: " + fOne.get());
			System.out.println("Exec time for downloaderTwo: " + fTwo.get());
		}
		catch(ExecutionException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Elapsed time since scheduling:" + (endTime-startTime));

		executorService.shutdown();
		
	}

	private static void callableWithoutExecutor(String[] urls) {
		Callable<Long> downloaderOne = new HExecutorService2(Arrays.copyOfRange(urls, 0, 6));
		Callable<Long> downloaderTwo = new HExecutorService2(Arrays.copyOfRange(urls,6, urls.length));
		
		/*
		 * Callable will work with Executor only, or else, it'll execute in current thread, which is not multi threading
		 */
		try {
			System.out.println("Exec time for downloaderOne: " + downloaderOne.call());
			System.out.println("Exec time for downloaderTwo: " + downloaderTwo.call());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void callableInterface(String[] urls) throws InterruptedException {

		/* RUNNABLE
		 * Typically used for tasks that don’t need to return a result or that don’t need to throw checked exceptions. 
		 * It’s used with Thread or ExecutorService.
		 * 
		 */
		/* CALLABLE
		 * Used when you need a result from the execution or need to handle checked exceptions. 
		 * It’s used with ExecutorService to get results via Future.
		 */
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		Callable<Long> downloaderOne = new HExecutorService2(Arrays.copyOfRange(urls, 0, 6));
		Callable<Long> downloaderTwo = new HExecutorService2(Arrays.copyOfRange(urls,6, urls.length));
		
		Future<Long> fOne = executorService.submit(downloaderOne);
		Future<Long> fTwo = executorService.submit(downloaderTwo);
		
		try {
			System.out.println("Exec time for downloaderOne: " + fOne.get()); // it's like thread.join()
			System.out.println("Exec time for downloaderTwo: " + fTwo.get());
		}
		catch(ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("Before shutdown");
		executorService.shutdown();
		System.out.println("After shutdown");		
	}

	private static void futureObject(String[] urls) throws InterruptedException {
		Thread downloaderOne = new Thread(new HExecutorService(Arrays.copyOfRange(urls, 0, 6)));
		Thread downloaderTwo = new Thread(new HExecutorService(Arrays.copyOfRange(urls, 6, urls.length)));
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		long startTime = System.currentTimeMillis();
		/*
		 * The threads downloaderOne and downloaderTwo are submitted to the ExecutorService for execution. 
		 * The submit method returns a Future object, which represents the result of the asynchronous computation.
		 */
		Future<?> fOne = executorService.submit(downloaderOne);
		Future<?> fTwo = executorService.submit(downloaderTwo);
		int checkCount = 0;

		while (true) {
			checkCount++;
			if (checkCount > 3) {
				fOne.cancel(true); // it'll stop the future execution
				fTwo.cancel(true);
				System.out.println("The downloaders have been CANCELLED!");
				break;
//				System.exit(0);
			}

			if (fOne.isDone() && fTwo.isDone()) { // it'll check whether future execution is done or not
				System.out.println("The downloaders are DONE!");
				break;
			}

			System.out.println("Check #" + checkCount + ": Downloaders are still on...");
			Thread.sleep(2000);
		}
		
		executorService.shutdown();

		while (!executorService.isTerminated()) {
			System.out.println("Rob");
			Thread.sleep(1000);
		}

		long endTime = System.currentTimeMillis();

		/*
		 * Mostly exception will come, why?
		 * well we're trying to cancel the thread,
		 * but before that time some may enter and still running and not completed
		 * so, that got interrupted by cancel method, that's why.
		 */
		System.out.println("Total time taken: " + (endTime - startTime) / 1000 + "s");
		
	}

	/*
	 * we have 12 different threads submitted
	 * but will be ran in only 4 threads
	 * resulting in 4 different threads
	 * once the countdown reaches 4, 3, 2, 1, 0
	 * current/main thread will be unlocked
	 */
	private static void threadIs12CountDownIs4(String[] urls) throws InterruptedException {
		int maxThreads = 4;
		CountDownLatch latch = new CountDownLatch(maxThreads);
		ExecutorService executorService = Executors.newFixedThreadPool(maxThreads);	
		
		long startTime = System.currentTimeMillis();
		
		for(String url : urls) {
			
			Thread downloader = new Thread(new HExecutorService(new String[] {url}, latch));
			executorService.submit(downloader);
		}
        
        latch.await();
        
        long endTime = System.currentTimeMillis();
    	
    	System.out.println("Total time taken: " + (endTime-startTime)/1000 + "s");
		
	}
	
	private static void shutdownGracefully(String[] urls) throws InterruptedException {
		int maxThreads = 4;
		CountDownLatch latch = new CountDownLatch(maxThreads);
		ExecutorService executorService = Executors.newFixedThreadPool(maxThreads);	
		
		long startTime = System.currentTimeMillis();
		
		for(String url : urls) {
			
			Thread downloader = new Thread(new HExecutorService(new String[] {url}, latch));
			executorService.submit(downloader);
		}
        
        latch.await();
        
        /*
         * Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
         */
        executorService.shutdown(); // it'll complete all parallellyy and stop the java application
        
        try {
        	executorService.submit(new HExecutorService(urls, latch));
        } catch (Exception e) {
			System.out.println(e.getClass() + " after shutdown no resubmitting " + e.getMessage());
		}
        
        // This will keep main thread wait until executor completes
        while(!executorService.isTerminated()) { 
        	Thread.sleep(1000);
        }
        
        /*
         * Attempts to stop all actively executing tasks and halts the processing of waiting tasks. 
         * It also returns a list of the tasks that were waiting to be executed.
         */
        //executorService.shutdownNow(); // it'll stop even if it isn't completed
        
        long endTime = System.currentTimeMillis();
    	
    	System.out.println("Total time taken: " + (endTime-startTime)/1000 + "s");
		
	}

	private static void countDownLatch(String[] urls) throws InterruptedException {
		int maxThreads = 2;
		/*
		 * CountDownLatch latch = new CountDownLatch(maxThreads);: 
		 * Creates a CountDownLatch with a count equal to maxThreads. 
		 * This latch will be used to make the main thread wait until both threads (we gave 2 in param)
		 * (downloaderOne and downloaderTwo) complete their tasks.
		 */
		CountDownLatch latch = new CountDownLatch(maxThreads); // here we specify the countdown(2 thread completion will countdown to 0. Like 2, 1, 0)
        Thread downloaderOne = new Thread(new HExecutorService(Arrays.copyOfRange(urls, 0, 6), latch));
        Thread downloaderTwo = new Thread(new HExecutorService(Arrays.copyOfRange(urls, 6, urls.length), latch));

        //ExecutorService executorService = Executors.newFixedThreadPool(maxThreads);
        
        // All tasks submitted to this executor are executed sequentially by the single thread.
        // even if we submit multiple threads, only 1 will be executed at a time which will result in a single threaded process
        ExecutorService executorService = Executors.newSingleThreadExecutor(); 
        
        long startTime = System.currentTimeMillis();
        
        executorService.submit(downloaderOne);
        executorService.submit(downloaderTwo);
        
        /*
         * The main thread will block and wait until the count of the CountDownLatch reaches zero. 
         * Each HExecutorService task is expected to call latch.countDown() when it completes, reducing the latch count by 1. 
         * When both tasks complete, the count reaches zero, and await() returns, allowing the main thread to proceed.
         */
        latch.await(); // if the specified count of threads completed, then main thread won't be blocked anymore and below lines will start executing
        // Let's say u have 5 threads submitted in executor and countdown is only 3, when 3 threads completed, 
        // it'll unblock the main thread and below line will be start executing, and rest 2 will be running parallelly
        
        long endTime = System.currentTimeMillis();
    	
    	System.out.println("Total time taken: " + (endTime-startTime)/1000 + "s");
		
	}

	private static void awaitTermination(String[] urls) throws InterruptedException {
		Thread downloaderOne = new Thread(new HExecutorService(
				Arrays.copyOfRange(urls, 0, 6)));
        
        Thread downloaderTwo = new Thread(new HExecutorService(
				Arrays.copyOfRange(urls, 6, urls.length)));
		
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        
        long startTime = System.currentTimeMillis();
        
        executorService.submit(downloaderOne);
        executorService.submit(downloaderTwo);
        /*
         * This method is used to wait for the termination of the ExecutorService. 
         * It blocks until all tasks have completed execution after a shutdown request, or the timeout occurs, whichever happens first.
         * 
         * If the ExecutorService does not terminate within the specified timeout, it returns false. 
         * Otherwise, it returns true if the termination was successful.
         * This is useful to ensure that all tasks have been completed before proceeding or terminating the application.
         */
        System.out.println(executorService.awaitTermination(120, TimeUnit.SECONDS)); // It's like Thread.sleep, it'll make wait the main(current thread)  
        
        long endTime = System.currentTimeMillis();
    	
    	System.out.println("Total time taken: " + (endTime-startTime)/1000 + "s");
		
	}

	/*
	 * Reasons for Threads Still Running
	 * 	Thread Pool Behavior:
	 * 		A thread pool managed by ExecutorService will keep idle threads alive to handle future tasks. 
	 * 		If you don’t explicitly shut down the executor, it will continue to exist and hold onto resources, 
	 * 		potentially waiting for new tasks or performing internal clean-up.
	 * 	Non-Terminating Threads:
	 * 		If any of the tasks submitted to the ExecutorService don’t terminate correctly or are blocked 
	 * 		(e.g., waiting for I/O, synchronization issues, or have infinite loops), 
	 * 		the ExecutorService may appear to be running indefinitely.
	 * 	Shutdown Process:
	 * 		Calling shutdown() initiates an orderly shutdown where the executor stops accepting new tasks 
	 * 		and waits for existing tasks to complete. If you don't call shutdown(), 
	 * 		the executor will continue to wait for any remaining tasks or internal processes to complete.
	 */
	private static void nonStoppingExecutor(String[] urls) {
		Thread downloaderOne = new Thread(new HExecutorService(
				Arrays.copyOfRange(urls, 0, 6)));
        
        Thread downloaderTwo = new Thread(new HExecutorService(
				Arrays.copyOfRange(urls, 6, urls.length)));
		
        /*
         * ExecutorService is a high-level API in Java provided by the java.util.concurrent package 
         * for managing and controlling the execution of asynchronous tasks. 
         * It simplifies the management of thread execution, 
         * helping you handle concurrent tasks more efficiently and flexibly compared to managing threads directly.
         * Eg:
         * 		ExecutorService executorService = Executors.newFixedThreadPool(2);
         * 			executorService.submit(() -> {
         * 			// Task implementation
         * 		});
         * 
         * An ExecutorService is created using a fixed thread pool with 2 threads. 
         * This allows the concurrent execution of tasks, and in this case, 
         * it will handle the two threads created earlier.
         */
        ExecutorService executorService = 
        		/*
        		 * A thread pool is a collection of pre-instantiated, 
        		 * idle threads that are available to perform tasks in a concurrent programming environment. 
        		 * It is a design pattern that helps manage the execution of multiple threads efficiently, 
        		 * avoiding the overhead of creating and destroying threads for each task.
        		 * 
        		 * Fixed Thread Pool:
        		 * 	This method creates a thread pool with a fixed number of threads, in this case, 2. 
        		 * 	This means that the pool will always have exactly 2 threads available to execute tasks.
        		 * Thread Reuse:
        		 * 	The created ExecutorService will reuse the same 2 threads to execute tasks. 
        		 * 	When a task is submitted, one of these 2 threads will pick it up for execution. 
        		 * 	If a thread is idle (not executing any task), it will be used to execute the new tasks.
        		 * Task Queue:
        		 * 	If more tasks are submitted than there are threads available (in this case, more than 2), 
        		 * 	the excess tasks are placed in a queue. 
        		 * 	The threads will pick tasks from this queue as they become available.
        		 * No More Than 2 Threads:
        		 * 	The maximum number of threads in the pool is fixed at 2. 
        		 * 	Even if the task queue grows or the system has the capacity for more threads, 
        		 * 	the pool will not create additional threads beyond this fixed number.
        		 */
        		Executors.newFixedThreadPool(2);
        
        long startTime = System.currentTimeMillis();
        
        /*
         * The threads downloaderOne and downloaderTwo are submitted to the executor service for execution. 
         * The submit method schedules the threads for execution by the thread pool.
         */
        executorService.submit(downloaderOne);
        executorService.submit(downloaderTwo);
        
        long endTime = System.currentTimeMillis();
    	
        // This is getting executed way before download process completes, cuz we didn't give Thread.join();
    	System.out.println("Total time taken: " + (endTime-startTime)/1000 + "s");
		
	}

	private static void singleThreadDownloader(String[] urls) {
		Thread downloader = new Thread(new HExecutorService(Arrays.copyOfRange(urls, 0, urls.length)));

		try {
			long startTime = System.currentTimeMillis();
			downloader.start();

			downloader.join();
			long endTime = System.currentTimeMillis();

			System.out.println("Total time taken: " + (endTime - startTime) / 1000 + "s");
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted");
			e.printStackTrace();
		}		
	}

	private static void twoThreadDownloader(String[] urls) {
		Thread downloaderOne = new Thread(new HExecutorService(Arrays.copyOfRange(urls, 0, 6)));
		Thread downloaderTwo = new Thread(new HExecutorService(Arrays.copyOfRange(urls, 6, urls.length)));

		try {
			long startTime = System.currentTimeMillis();
			downloaderOne.start();
			downloaderTwo.start();

			downloaderOne.join();
			downloaderTwo.join();
			long endTime = System.currentTimeMillis();

			System.out.println("Total time taken: " + (endTime - startTime) / 1000 + "s");
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted");
			e.printStackTrace();
		}
	}

}

class HExecutorService2 implements Callable<Long> {

	String[] urlsList;

	public HExecutorService2(String[] urlsList) {
		this.urlsList = urlsList;
	}

	@Override
	public Long call() {
		long startTime = System.currentTimeMillis();
		String threadName = Thread.currentThread().getName();
		try {
			for (String urlString : urlsList) {
				if (Thread.currentThread().isInterrupted()) {
					System.out.println("Sam");
					throw new InterruptedException(Thread.currentThread().getName() + " interrupted");
				}
				URL url = new URL(urlString);
				String filename = urlString.substring(urlString.lastIndexOf("/") + 1).trim() + ".html";
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				BufferedWriter writer = new BufferedWriter(new FileWriter("htmlfiles/" + filename));
				String line;
				while ((line = reader.readLine()) != null) {
					writer.write(line);
				}
				System.out.println(threadName + " has downloaded " + filename);
				writer.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		return endTime-startTime;
	}
}

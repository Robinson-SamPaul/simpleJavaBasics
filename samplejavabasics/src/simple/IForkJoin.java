package simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

@SuppressWarnings("serial")
public class IForkJoin extends RecursiveAction {

	String[] urlsList;
	private static final int THRESHOLD = 6;

	public IForkJoin(String[] urlsList) {
		this.urlsList = urlsList;
	}

	/*
	 * This is the main method where the task's logic is executed.
	 * If the number of URLs exceeds the THRESHOLD, it splits the task into subtasks and processes them in parallel.
	 * If the number of URLs is below or equal to the THRESHOLD, it directly performs the download.
	 */
	@Override
	protected void compute() {
		if (urlsList.length > THRESHOLD) {
			/*
			 * ForkJoinTask.invokeAll is used to submit a collection of 
			 * ForkJoinTask instances for execution and wait for their completion. 
			 * It’s useful when you want to execute multiple tasks in parallel and 
			 * ensure that all of them complete before proceeding.
			 * 
			 * invokeAll takes a collection of ForkJoinTask instances (such as RecursiveAction or RecursiveTask), 
			 * submits them to the Fork/Join pool, and executes them in parallel.
			 */
			ForkJoinTask.invokeAll(createSubtasks());
		} else {
			download(urlsList);
		}
	}

	private List<IForkJoin> createSubtasks() {

		List<IForkJoin> subtasks = new ArrayList<>();

		String[] firstSet = Arrays.copyOfRange(urlsList, 0, urlsList.length / 2);
		String[] secondSet = Arrays.copyOfRange(urlsList, urlsList.length / 2, urlsList.length);

		subtasks.add(new IForkJoin(firstSet));
		subtasks.add(new IForkJoin(secondSet));

		return subtasks;
	}

	public void download(String[] urlsList) {

		String threadName = Thread.currentThread().getName();

		System.out.println(threadName + " has STARTED!");

		try {

			for (String urlString : urlsList) {

				URL url = new URL(urlString);
				String filename = urlString.substring(urlString.lastIndexOf("/") + 1).trim() + ".html";
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

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

		System.out.println(threadName + " has FINISHED!");
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
				"https://www.skillsoft.com/skillsoft-support-success-and-services" };
		
		IForkJoin task = new IForkJoin(urls);

		ForkJoinPool pool = new ForkJoinPool();
		/*
		 * When you submit a task to the ForkJoinPool using the invoke method, 
		 * the pool takes care of scheduling and executing the task.
		 * 
		 * The ForkJoinPool internally calls the compute() method of the RecursiveAction task. 
		 * This method contains the logic for the task and determines 
		 * whether to perform the computation directly or to split the task into subtasks.
		 */
		pool.invoke(task);

	}

}
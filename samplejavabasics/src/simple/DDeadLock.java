package simple;

public class DDeadLock {

	public static void main(String[] args) throws InterruptedException {

		ResourceOne r1 = new ResourceOne();
		ResourceTwo r2 = new ResourceTwo();
		ResourceOne r3 = new ResourceOne();
		ResourceTwo r4 = new ResourceTwo();

		Thread firstTaskThread = new Thread(new FirstTask(r1, r2), "firstTaskThread");
//		Thread secondTaskThread = new Thread(new SecondTask(r1, r2), "secondTaskThread"); // this will run forever
		Thread secondTaskThread = new Thread(new SecondTask(r3, r4), "secondTaskThread");

		System.out.println("Starting the two threads...");

		firstTaskThread.start();
		secondTaskThread.start();

		firstTaskThread.join();
		secondTaskThread.join();

		System.out.println("The two threads are done");

	}

}

class FirstTask implements Runnable {

	ResourceOne rOne;
	ResourceTwo rTwo;

	public FirstTask(ResourceOne r1, ResourceTwo r2) {
		this.rOne = r1;
		this.rTwo = r2;
	}

	@Override
	public void run() {
		try {
			synchronized (rOne) {
				System.out.println("Lock acquired on ResourceOne by " + Thread.currentThread().getName());
				rOne.myVar++;
				Thread.sleep(1000);
				System.out.println("After sleep 1st"
						+ "\n one" + rOne
						+ "\n Two" + rTwo);

				synchronized (rTwo) {
					System.out.println("Lock acquired on ResourceTwo by " + Thread.currentThread().getName());

					rTwo.myVar--;
					Thread.sleep(1000);
				}

				System.out.println("Lock on ResourceTwo released by " + Thread.currentThread().getName());
			}

			System.out.println("Lock on ResourceOne released by " + Thread.currentThread().getName());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class SecondTask implements Runnable {
	ResourceOne rOne;
	ResourceTwo rTwo;

	public SecondTask(ResourceOne r1, ResourceTwo r2) {
		this.rOne = r1;
		this.rTwo = r2;
	}

	@Override
	public void run() {
		try {

			synchronized (rTwo) {
				System.out.println("Lock acquired on ResourceTwo by " + Thread.currentThread().getName());

				rTwo.myVar++;
				Thread.sleep(1000);
				System.out.println("After sleep 2nd"
						+ "\n one" + rOne
						+ "\n Two" + rTwo);

				synchronized (rOne) {
					System.out.println("Lock acquired on ResourceOne by " + Thread.currentThread().getName());
					rOne.myVar--;
					Thread.sleep(1000);
				}

				System.out.println("Lock on ResourceOne released by " + Thread.currentThread().getName());
			}

			System.out.println("Lock on ResourceTwo released by " + Thread.currentThread().getName());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class ResourceOne {
	public int myVar = 100;
}

class ResourceTwo {
	public int myVar = 100;
}
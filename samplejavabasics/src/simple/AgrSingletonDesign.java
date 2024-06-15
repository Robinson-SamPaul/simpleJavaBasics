package simple;

public class AgrSingletonDesign {

	public static void main(String[] args) {
		Singleton obj1 = Singleton.getInstance();
		System.out.println(obj1.hashCode());
		System.out.println(Thread.currentThread().getName());

		Singleton obj2 = Singleton.getInstance();
		System.out.println(obj2.hashCode());
		
		Runnable thread = () -> { // Runnable is a functional interface and used lambda expression
			for(int i=0; i<100; i++) {
				Singleton obj3 = Singleton.getInstance();
				System.out.println(obj3.hashCode());
				System.out.println(Thread.currentThread().getName());
			}
		};
		thread.run();
		Thread thread2 = new Thread(thread);
		thread2.setName("Custom thread");
		
		/*
		 * thread.run() 
		 * 		Method Call: 
		 * 			When you call run() directly on a Thread object,
		 * 			it's just a normal method call executed in the context of the current thread
		 * 			(the thread that called run()). 
		 * 		No New Thread: 
		 * 			No new thread is created. The run() method is executed in the calling thread. 
		 * 		Thread Name: 
		 * 			The thread name will remain the same as the calling thread's name. 
		 * thread.start() 
		 * 		Thread Creation: 
		 * 			When you call start() on a Thread object, it initiates the creation of a new thread. 
		 * 		Run Method Execution: 
		 * 			The start() method internally calls the run() method, 
		 * 			but it does so in a new thread of execution. 
		 * 		New Thread: 
		 * 			A new thread is created, and the run() method is executed in this new thread.
		 *		 Thread Name: 
		 *			The new thread has its own name, which can be set using thread.setName(). 
		 *			If not set, it typically has a default name like "Thread-0", "Thread-1", etc.
		 */
		thread2.start();
		/* thread2.run(); */		
	}
}

class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
		/*
		 * If A obj has already been initialized, B won't enter this if condition running in same thread 
		 * If it runs in dif thread, B will enter too 
		 * 
		 * First check(without locking)
		 */
        if (instance == null) {
			/*
			 * Class-Level Lock: When you use synchronized (Singleton.class), 
			 * you are obtaining a lock on the class object A.class itself. 
			 * This means that regardless of how many instances of A exist,
			 * only one thread can enter the synchronized block across all instances of Singleton.
			 * 
			 *  Don't ask silly question like what if other class access it?
			 *  "getInstance()" is a static method
			 *  how will u call method?
			 *  By object, if it's a static method, by ClassName
			 *  How will u able to call this method?
			 *  Singleton.getInstance();
			 *  Not OtherClass.getInstance();
			 *  So, only 1 class can call this method.
			 */
            synchronized (Singleton.class) { // AerSynchronised.java
				/*
				 * If 2 thread access this method same time, high chance of both passing the 1st condition 
				 * but it won't pass synch block so, inside we have another condition
				 * infact, we really don't need first condtion, it's just for better performance
				 * let's say A and B comes, A is null and B is not,
				 * and A enters and getting initialised, meanwhile B has to wait to enter block, 
				 * if we have 1st condition, this process can be skipped
				 */
                if (instance == null) { // Second check (with locking)
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}


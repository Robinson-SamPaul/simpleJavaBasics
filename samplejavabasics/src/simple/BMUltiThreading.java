package simple;

public class BMUltiThreading {

	/*
	Multithreading
		Definition: 
			Multithreading involves running multiple threads within a single process. 
			Threads share the same memory space but have their own execution path.
		Resource Sharing: 
			Since threads share the same process memory, they can access shared resources more easily. 
			This makes inter-thread communication more straightforward 
			but can also lead to issues like race conditions if not managed properly.
		Overhead: 
			Threads are lighter weight compared to processes. 
			Creating and managing threads generally requires less overhead since they share resources like memory.
		Usage: 
			Multithreading is suitable for tasks that are part of the same application and require shared memory or resources. 
			Examples include handling multiple requests in a web server or parallelizing tasks within a single application.
	Multiprocessing
		Definition: 
			Multiprocessing involves running multiple processes simultaneously, each with its own memory space. 
			Each process is an independent entity and does not share memory with other processes.
		Resource Sharing: 
			Processes do not share memory. Communication between processes is usually done through inter-process communication (IPC) 
			mechanisms like sockets or files, which can be more complex and slower than thread-based communication.
		Overhead: 
			Processes have a higher overhead compared to threads because each process has its own memory and system resources. 
			Starting and managing processes is generally more resource-intensive.
		Usage: 
			Multiprocessing is suitable for tasks that require isolation from each other or when dealing with CPU-bound tasks 
			that can benefit from running on multiple processors or cores. 
			Examples include running separate applications or services that should not interfere with each other.
	Key Differences
		Memory Sharing: 
			Threads share the same memory space; processes do not.
		Overhead: (overhead refers to the additional resources or costs required to manage a particular task or operation beyond the actual work being performed)
			Threads have less overhead compared to processes.
		Communication: 
			Communication between threads is easier and faster due to shared memory, 
			while communication between processes typically requires IPC mechanisms.
		Isolation: 
			Processes are isolated from each other, making them more robust against crashes in one process affecting others. 
			Threads are not isolated, so an error in one thread can affect others within the same process.
	 */
	
	/*
	Race Condition
		Definition: 
			A race condition occurs when multiple threads access shared resources concurrently and 
			the outcome depends on the timing or order of their execution. 
			This can lead to unpredictable results or inconsistent data if proper synchronization is not used.
		Example: 
			Consider a scenario where two threads are trying to update the same bank account balance. 
			If both threads read the balance simultaneously and then update it, 
			one update might overwrite the other, leading to incorrect results.
	 */
	
	/*
	Semaphores
		Definition: 
			A semaphore is a synchronization primitive that controls access to a shared resource by multiple threads. 
			It maintains a set of permits, and threads must acquire a permit before accessing the resource and release it when they are done.
	 */
	
	/*
	Deadlock
		Definition: 
			A deadlock is a situation where two or more threads are blocked forever, 
			waiting for each other to release resources. 
			It occurs when threads hold resources while trying to acquire additional resources 
			that are held by other threads, leading to a standstill.
		Example:		
			Thread 1 acquires Resource A and needs Resource B.
			Thread 2 acquires Resource B and needs Resource A.
			Both threads are waiting for each other to release the resources, leading to a deadlock.
	Conditions for deadlock:
		Mutual Exclusion
			Definition: Mutual exclusion is a condition where only one thread or process can access a shared resource at a time. 
			It ensures that only one thread or process holds the resource, preventing others from accessing it concurrently.			
			Example: In a Java application, if two threads need to access a critical section of code that modifies a shared resource, 
			a synchronized block or method can be used to enforce mutual exclusion.
		Hold and Wait
			Definition: Hold and wait is a condition where a thread holds at least one resource while waiting to acquire additional resources held by other threads. 
			This situation can contribute to a deadlock if other threads are also waiting for resources held by the first thread.			
			Example: A thread that holds a lock on Resource A and requests a lock on Resource B while other threads hold Resource B and are waiting for Resource A.
		Circular Wait
			Definition: Circular wait is a condition where a set of threads are waiting for resources in a circular chain. 
			Each thread holds a resource and waits for the next resource held by another thread in the chain.
			Example: Thread A waits for a resource held by Thread B, Thread B waits for a resource held by Thread C, and Thread C waits for a resource held by Thread A.
		No Preemption
			Definition: No preemption is a condition where resources cannot be forcibly taken away from threads or processes holding them. 
			Instead, threads or processes must release resources voluntarily.
			Example: If a thread is holding a lock and needs additional resources, it must wait until it can acquire them or release the lock it currently holds. 
			The system does not forcibly take the lock from the thread.
	 */
}

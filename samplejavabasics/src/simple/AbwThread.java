package simple;

public class AbwThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aa a = new Aa();
		Bb b = new Bb();
		
		a.start(); // belongs to Thread class
		b.start();
	}

}

class Aa extends Thread {
	public void run() { // must be in public
		for(int i=0; i<100; i++) {
			System.out.print("A");
		}
	}
}

class Bb extends Thread {
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.print("B");
		}
	}
}

//gives different output different times

/*
Java Thread Life Cycle
	New (Created)
		Thread is created using Thread t = new Thread();
		Not started yet.
		Thread t = new Thread(); // NEW
	Runnable
		Thread is ready to run, but may not be running yet.
		Happens after calling t.start()
		Waiting for CPU time.
		t.start(); // RUNNABLE
	Running
		The thread is picked by the CPU scheduler and is now executing.
		Java doesn’t guarantee exactly when a thread will run after start().
		No direct method to move to Running. JVM handles this.
	Blocked / Waiting / Timed Waiting
		The thread pauses temporarily for different reasons:
			Blocked			- Waiting to acquire a lock held by another thread.
			Waiting			- Waiting indefinitely for another thread to notify it (wait()).
			Timed Waiting	- Sleeping or waiting with a timeout (sleep(), join(timeout), wait(timeout)).
	Terminated (Dead)
		Thread has finished execution or was stopped due to an exception.
*/
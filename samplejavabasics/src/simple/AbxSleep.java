package simple;

public class AbxSleep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A1 obj1 = new A1();
		B1 obj2 = new B1();
		System.out.println(obj2.getPriority()); // by default it's 5, 1-10, 1 is least, 10 is high
		obj2.setPriority(6);
		obj1.setPriority(Thread.MAX_PRIORITY); // maximum effort DP

		obj1.start();
		obj2.start();
	}
}

class A1 extends Thread{
	public void run() { // only works with try?/ catch
		for(int i=0; i<100; i++) {
			System.out.print("A");
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class B1 extends Thread {
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.print("B");
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

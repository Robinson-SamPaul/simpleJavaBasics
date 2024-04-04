package simple;

public class AbyRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		A2 obj1 = new A2();
//		B2 obj2 = new B2();

		Runnable obj1 = () -> { // Runnable is a functional interface and used lambda expression
			for(int i=0; i<100; i++) {
				System.out.print("A");
			}
		};

		Runnable obj2 = () -> {
			for(int i=0; i<100; i++) {
				System.out.print("B");
			}
		};
		
		Thread t1 = new Thread(obj1); // start is from Thread class, so we need Thread objects to call start method
		Thread t2 = new Thread(obj2);
		
		t1.start();
		t2.start();
	}

}

//class A2 implements Runnable { // As java not supports multiple inheritance, subclass can't extend Thread class, so we need Runnable interface
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		for(int i=0; i<100; i++) {
//			System.out.print("A");
//		}
//	}
//	
//}
//
//class B2 implements Runnable {
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		for(int i=0; i<100; i++) {
//			System.out.print("B");
//		}
//	}
//	
//}

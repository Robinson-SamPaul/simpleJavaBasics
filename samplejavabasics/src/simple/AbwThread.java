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
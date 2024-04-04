package simple;

public class AazAbstraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Abstracts a = new Abstracts() {
			
			@Override
			void show() {
				// TODO Auto-generated method stub
				System.out.println("Anonymous inner class");
			}
		};
		a.display();
		a.show();
		Abs a2 = new Abs();
		a2.display();
		a2.show();
	}

}

abstract class Abstracts {
	abstract void show();
	void display() {
		System.out.println("Non-Abstract Method");
	}
}

class Abs extends Abstracts {
	void show() {
		System.out.println("Anonymous local class");
	}
}

package simple;

public class AahMethods {
	
	void display() {
		System.out.println("method displayed");
	}
	
	int show(int a) {
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AahMethods obj = new AahMethods();
		obj.display();
		System.out.println(obj.show(0) + " is shown");
	}

}

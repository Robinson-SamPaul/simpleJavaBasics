package simple;

public class AavStaticAndFinal {

	int a = 10;
	static int b = 100; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pupil p1 = new Pupil(1, "Sam");
		Pupil.college = "Sivet";
		System.out.println(p1);
		System.out.println();
		
		Pupil p2 = new Pupil(2, "Rob");
		Pupil.college = "PSV";
//		p2.fees = 56; // constant
		System.out.println(p1 + "\n" + p2);
		System.out.println();
//		p1.show1(); // obj.call() no need, class.call()
		Pupil.show1();
		p1.show2();

		System.out.println();
		System.out.println(new AavStaticAndFinal().a); // same class non static variable
		System.out.println(AavStaticAndFinal.b); // same class static variable
		System.out.println(b); // same class static variable
		
		display(); // same class static method
    	AavStaticAndFinal.display(); // same class static method
    	new AavStaticAndFinal().show(); // same class non static method
    	
    	System.out.println(new StaticField().a); // different class non static variable
    	System.out.println(StaticField.b); // different class static variable
    	
    	new StaticField().show(); // different class non static method
    	StaticField.display(); // different class static method

		System.out.println(AhdStaticAndInstance.class);
	}
	private static void display() {
    	System.out.println(new AavStaticAndFinal().a);
    	System.out.println(AavStaticAndFinal.b);
    	System.out.println(b);
    }
    private void show() {
    	System.out.println(new AavStaticAndFinal().a);
    	System.out.println(AavStaticAndFinal.b);
    	System.out.println(b);
    }
}

class StaticField {
	int a = 10;
	static int b = 100;
    public static void display() {
    	System.out.println(new StaticField().a);
    	System.out.println(StaticField.b);
    	System.out.println(b);
    }
    public void show() {
    	System.out.println(new StaticField().a);
    	System.out.println(StaticField.b);
    	System.out.println(b);
    }
}

class Pupil {
	
	int rollNo;
	String name;
	
	static String college;
	static { // used to initialize static variables, can be reassigned
		college = "Standsford";
	}
	
	final int fees = 25000;
	
	@Override
	public String toString() {
		return "Pupil [rollNo=" + rollNo + ", name=" + name + ", college=" + college+", fees=" + fees+"]";
	}
	static void show1() {
		System.out.println("static method");
	}
	
	/*
	 * final methods can't be overridden, 
	 * even private methods also can't be overridden,
	 * but final methods can be accessed outside, private can't
	 */
	final void show2() { 
		System.out.println("final method");
	}
	
	public Pupil(int rollNo, String name) {
		super();
		this.rollNo = rollNo;
		this.name = name;
	}	
}

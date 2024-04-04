package simple;

public class AavStaticAndFinal {

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
	final void show2() { // can't be overridden
		System.out.println("final method");
	}
	public Pupil(int rollNo, String name) {
		super();
		this.rollNo = rollNo;
		this.name = name;
	}
	
}
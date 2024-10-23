package simple;

public class AasObjectClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student(1, "Sam");
		System.out.println(s.getRollNo() + " " + s.getName());
		System.out.println(s);
//		System.out.println(s.toString()); // by default it'll call tostring methods
		System.out.println(s.hashCode());
		System.out.println(s.getClass());
		System.out.println(s.getClass().getName());
	}

}

class Student {
	private int rollNo;
	private String name;
	
	public Student(int rollNo, String name) {
		super();
		this.rollNo = rollNo;
		this.name = name;
	}
	
	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		System.out.println("toString() method is called");
		return "Student [rollNo=" + rollNo + ", name=" + name + "]";
	}
}

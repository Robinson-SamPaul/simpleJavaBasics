package simple;

class SchoolStudent {
	String studentName;
	int studentId;
	SchoolSubject subject;
	
	public SchoolStudent(String studentName, int studentId, SchoolSubject subject) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.subject = subject;
	}
	
	public SchoolStudent(String studentName, int studentId) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.subject = new SchoolSubject();
	}
}

class SchoolSubject {
	String subjectName;
}

public class AggComposition {
	public static void main(String[] args) {
		CollegeStudent student1 = new CollegeStudent("Sam", 0);
		// Student can't exist without subject
		System.out.println(student1);
		
		CollegeSubject subject = new CollegeSubject();
		CollegeStudent student2 = new CollegeStudent("Sam", 0, subject);
		System.out.println(student2);
	}
}
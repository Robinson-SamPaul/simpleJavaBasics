package simple;

class CollegeStudent {
	String studentName;
	int studentId;
	CollegeSubject subject;
	
	public CollegeStudent(String studentName, int studentId, CollegeSubject subject) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.subject = subject;
	}
	
	public CollegeStudent(String studentName, int studentId) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
	}
}

class CollegeSubject {
	String subjectName;
}

public class AgfAggregation {
	public static void main(String[] args) {
		CollegeStudent student1 = new CollegeStudent("Sam", 0);
		// Student exist without subject too
		System.out.println(student1);
		
		CollegeSubject subject = new CollegeSubject();
		CollegeStudent student2 = new CollegeStudent("Sam", 0, subject);
		// Student exist with subject too
		System.out.println(student2);
	}
}
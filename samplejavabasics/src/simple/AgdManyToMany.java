package simple;

import java.util.List;

class Intern {
    String name;
    List<Course> courses;
}

class Course {
    String title;
    List<Intern> students;
}

public class AgdManyToMany {
	public static void main(String[] args) {
        print("From both POV, it's many to many"
        		+ "1 Intern can enroll in multiple courses"
        		+ "1 course can be enrolled by multiple interns");
    }
	
	private static void print(Object obj) {
		System.out.println(obj);
	}
}

// There is one concept of delegation, it's like delegating it's task to other method/class
// eg: print() method



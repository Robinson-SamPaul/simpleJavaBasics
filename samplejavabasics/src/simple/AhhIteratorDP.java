package simple;

public class AhhIteratorDP {

    public static void main(String[] args) {
        StudentList StudentList = new StudentList(5);
        StudentList.addStudent(new Student(1, "Sam"));
        StudentList.addStudent(new Student(2, "Rob"));
        StudentList.addStudent(new Student(3, "Paul"));

        Iterator iterator = StudentList.createIterator();
        
        while (iterator.hasNext()) {
            Student Student = (Student) iterator.next();
            System.out.println("Student: " + Student.getName());
        }
    }
}
interface Iterator {
    boolean hasNext();
    Object next();
}
class StudentIterator implements Iterator {
    private Student[] Students;
    private int position = 0;

    public StudentIterator(Student[] Students) {
        this.Students = Students;
    }

    @Override
    public boolean hasNext() {
        return position < Students.length && Students[position] != null;
    }

    @Override
    public Object next() {
        return Students[position++];
    }
}
interface StudentCollection {
    Iterator createIterator();
}
class StudentList implements StudentCollection {
    private Student[] Students;
    private int index = 0;

    public StudentList(int size) {
        Students = new Student[size];
    }

    public void addStudent(Student Student) {
        if (index < Students.length) {
            Students[index++] = Student;
        }
    }

    @Override
    public Iterator createIterator() {
        return new StudentIterator(Students);
    }
}

package simple;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Students implements Cloneable {
	int rollNo;
	String name;
	List<String> strings;
	StudentsSubClass school;

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public Students deepClone() throws CloneNotSupportedException {
		Students superCopy = (Students) super.clone();
		StudentsSubClass subManualCopy = new StudentsSubClass();
		subManualCopy.teacher = superCopy.school.teacher;
		superCopy.school = subManualCopy;
		
		/*
		 * Important thing to note is Cloneable is Marker interface
		 * It doesn't contain clone() method
		 * But to use it, we need to implement cloneable interface
		 * to inform JVM about permission
		 * 
		 * we can do below instead of above manual sub class copy, but for this, 
		 * we need implement Cloneable interface and implement clone() method
		 * in the subclass too
		 * 
		 * primitive types and String(immutable), so no problem for that, 
		 * but in case of other class as subfield, we need to clone it manually/clone() method
		 * 
		 * important thing to note 
		 * <superCopy.school = (StudentsSubClass) superCopy.school.clone();>
		 */
		return superCopy;
	}

	@Override
	public String toString() {
		return "["
				+ "rollNo=" + rollNo + ", "
				+ "name=" + name + ", "
				+ "strings=" + strings + ", "
				+ "subclass=" + school + ", "
				+ "teacher=" + (school != null ? school.teacher : "null") + "]";
	}
}

class StudentsSubClass {
	String teacher;
}

public class AatCloneAndFinalize {

	public static void main(String[] args) throws CloneNotSupportedException {

		System.out.println(URI.create("https://youtu.be/7FJ5mA2UtFY?si=pESJeTIGOdnN9jK1&t=360"));
		System.out.println();

		int n = 1;
		String s = "Sam";

		Students s1 = new Students();
		s1.name = s;
		s1.rollNo = n;
		System.out.println("Object1 = " + s1);
		System.out.println();

		Students s2 = s1; // shallow copy, will affect the source
		System.out.println("Before Changing");
		System.out.println("Object1 = " + s1);
		System.out.println("Object2 = " + s2);
		s1.rollNo = 3;
		System.out.println("After Changing");
		System.out.println("Object1 = " + s1);
		System.out.println("Object2 = " + s2);
		System.out.println();

		Students s3 = new Students(); // deep copy, won't affect the source
		s3.name = s1.name;
		s3.rollNo = s1.rollNo;
		System.out.println("Before Changing");
		System.out.println("Object1 = " + s1);
		System.out.println("Object3 = " + s3);
		s1.rollNo = 4;
		System.out.println("After Changing");
		System.out.println("Object1 = " + s1);
		System.out.println("Object3 = " + s3);
		System.out.println();

		List<String> strings = Arrays.asList("Apple", "Banana", "Cactus");
		s1.strings = strings;
		StudentsSubClass teach = new StudentsSubClass();
		teach.teacher = "Abdul";
		s1.school = teach;
		Students s4 = (Students) s1.clone();

		System.out.println("Before Changing");
		System.out.println("Object1 = " + s1);
		System.out.println("Object4 = " + s4);
		s1.name = "Jackie";
		s1.rollNo = 87;
		pointToNote(strings);
		teach.teacher = "Clarke";
		System.out.println("After Changing");
		System.out.println("Object1 = " + s1);
		System.out.println("Object4 = " + s4);
		System.out.println();
		
		List<String> list = new ArrayList<>();
		list.add("Duster");
		list.add("Wraith");
		list.add("Ghost");
		s1.strings = list;
		Students s5 = s1.deepClone();

		System.out.println("Before Changing");
		System.out.println("Object1 = " + s1);
		System.out.println("Object5 = " + s5);
		s1.name = "Peter";
		s1.rollNo = 45;
		pointToNote(list);
		teach.teacher = "James";
		System.out.println("After Changing");
		System.out.println("Object1 = " + s1);
		System.out.println("Object5 = " + s5); // list is getting affected, cuz I didn't that in deepClone method
		System.out.println();

//		finalise is a method, it'll be called by garbage collector in jvm, it'll be executed before deleting an unused object, it must be in protected

		/*
		 * example
		 * 
		 * A a = new A(); // <new A()> object is unused a = null; (or) C c = new C(); B
		 * b = new B(); // <new B()> object is unused b = c;
		 *
		 * new Stud(); // if we create this
		 * 
		 * protected void finalize() { Syso("hi""); } // it'll be executed only when
		 * unused object is to be deleted, cuz jvm will call finalize only on this
		 */
	}
	
	private static void pointToNote(List<String> strings) {
		/*
		 * If you are using collections created by methods like List.of,
		 * Collections.unmodifiableList, or Arrays.asList, these collections do not
		 * support modification operations such as remove or clear.
		 */
		try {
			strings.clear();
		} catch (Exception e) {
			System.out.println(e.getClass());
		}
	}

}
package simple;

import java.util.Scanner;

class Students implements Cloneable {
	int rollNo;
	String name;
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class AatCloneAndFinalize {

	public static void main(String[] args) throws CloneNotSupportedException{
		// TODO Auto-generated method stub
		
		Scanner sn = new Scanner(System.in);
		int n = sn.nextInt();
		String s = sn.next();
		
		Students s1 = new Students();
		s1.name = s;
		s1.rollNo = n;
		System.out.println("Object1 = " + s1.rollNo);
		System.out.println();
		
		Students s2 = s1; // shallow copy, will affect the source
		s2.rollNo = 3;
		System.out.println("Object1 = " + s1.rollNo);
		System.out.println("Object2 = " + s2.rollNo);
		System.out.println();
		
		Students s3 = new Students(); // deep copy, won't affect the source
		s3.name = s1.name;
		s3.rollNo = s1.rollNo;
		s3.rollNo = 5;
		System.out.println("Object1 = " + s1.rollNo);
		System.out.println("Object2 = " + s2.rollNo);
		System.out.println("Object3 = " + s3.rollNo);
		System.out.println();
		
		Students s4 = (Students) s1.clone(); // by default, it's undefined, we need to ovverride clone method, Cloneable interface gives permission to copy object, exceptions must be thrown
		s4.rollNo = 7;
		System.out.println("Object1 = " + s1.rollNo);
		System.out.println("Object2 = " + s2.rollNo);
		System.out.println("Object3 = " + s3.rollNo);
		System.out.println("Object4 = " + s4.rollNo);
		System.out.println();
		
		sn.close();
		
//		finalise is a method, it'll be called by garbage collector in jvm, it'll be executed before deleting an unused object, it must be in protected
		
/*		example
		
*		A a = new A(); // <new A()> object is unused 
*		a = null; 
*		(or)
*		C c = new C();
*		B b = new B(); // <new B()> object is unused
*		b = c;
*
*		new Stud(); // if we create this
*		
*		protected void finalize() {
*			Syso("hi"");
*		} // it'll be executed only when unused object is to be deleted, cuz jvm will call finalize only on this
*/
	}

}
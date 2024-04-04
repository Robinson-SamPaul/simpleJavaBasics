package simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AcdComparable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Guys> ls = new ArrayList<>();
		ls.add(new Guys(1, "Sam"));
		ls.add(new Guys(2, "Paul"));
		ls.add(new Guys(3, "Rob"));
		
		Collections.sort(ls);
		System.out.println(ls);
	}

}

class Guys implements Comparable<Guys>{
	int rollno;
	String name;
	
	public Guys(int rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Guys [rollno=" + rollno + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Guys that) {
		return (this.rollno > that.rollno) ? 1 : -1;
	}
}

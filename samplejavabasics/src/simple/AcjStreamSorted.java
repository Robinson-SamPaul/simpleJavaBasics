package simple;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class AcjStreamSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> ls = Arrays.asList(2,3,5,4,6,7);
		Stream<Integer> s1 = ls
				.parallelStream() // helps to run on multiple threads
				.filter(n -> n>0)
				.sorted(); // gives sorted values, while sorting parallelstream doesn't make any sense

		Stream<Integer> s2 = ls.stream().sorted(Comparator.reverseOrder());
		
		ls.stream().sorted((a, b) -> a-b).forEach(n -> System.out.print(n)); // a-b will return -/+. + swap & - won't
		System.out.println();
		s1.forEach(n -> System.out.print(n));
		System.out.println();
		s2.forEach(n -> System.out.print(n));

		System.out.println();
		System.out.println(ls);
		Collections.sort(ls);
		System.out.println(ls);
		Collections.reverse(ls);
		System.out.println(ls);
		
		List<Member> members = Arrays.asList(
				new Member(3, "Sam"),
				new Member(2, "Rob"),
				new Member(1, "Paul"),
				new Member(4, "Anu"));
		members.stream().forEach(obj -> System.out.print(obj));
		System.out.println();
		
		members.stream().sorted(
				(p1, p2) -> Integer.compare(p1.getId(), p2.getId()))
				.forEach(obj -> System.out.print(obj));
		System.out.println();
		
		members.stream().sorted(
				(p1, p2) -> p1.getName().compareTo(p2.getName()))
				.forEach(obj -> System.out.print(obj));
		System.out.println();
	}
}

class Member {
	
	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Member(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + "]";
	}
}

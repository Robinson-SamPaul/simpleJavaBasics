package simple;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class AefFuncIntrfsAndCmpring {

	public static void main(String[] args) {
		
		List<Member> members = Arrays.asList(
				new Member(3, "Sam"),
				new Member(2, "Rob"),
				new Member(1, "Paul"),
				new Member(4, "Anu"),
				new Member(3, "Kat"));

		System.out.print("List = ");
		members.stream().forEach(obj -> System.out.print(obj));
		System.out.println("\n");
		
		Function<Member, String> function = new Function<Member, String>() {

			@Override
			public String apply(Member t) {
				return t.getName();
			}
		};
		System.out.println("sorted with name using function object = ");
		members.stream().sorted(Comparator.comparing(function))
		.forEach(obj -> System.out.print(obj));
		System.out.println();

		System.out.println("sorted with ID using Lambda = ");
		members.stream().sorted(Comparator.comparing(obj -> obj.getId()))
		.forEach(obj -> System.out.print(obj));
		System.out.println();

		System.out.println("sorted with name using Method reference = ");
		/*
		 * not sure below, refer - \codePractise\src\main\java\org\example\test\MethodReference.java 
		 *
		 * 1, Reference to a Static Method
		 * 2, Reference to an Instance Method
		 * 3, Reference to a Constructor
		 * 4, Reference to an Instance Method of an Arbitrary Object of a Particular Type"
		 * 
		 * You have a Person class with a non-static method getName().
		 * You define a functional interface MyNameFetcher with a method:
		 * 		String fetch(Person p);
		 * You assign:
		 *		MyNameFetcher ref = Person::getName;
		 * Java sees:
		 * 		Person::getName is a non-static method.
		 * 		fetch(Person p) expects a Person object.
		 * 		So it rewrites it internally as:
		 * 			MyNameFetcher ref = (Person p) -> p.getName();
		 * Then when you call:
		 * 		ref.fetch(p1);
		 * It becomes:
		 * 		p1.getName(); // "John"
		 * 
		 * above is imaginary example, now for below;
		 * 
		 * You have a class Member with a non-static method getName().
		 * You use the built-in Function<T, R>:
		 * 		Function<Member, String> functionObj = Member::getName;
		 * Java understands:
		 * 		Function<T, R> has method: R apply(T t);
		 * So it needs a method that takes Member and returns String.
		 * Member::getName is non-static, so Java rewrites:
		 * 		Function<Member, String> functionObj = (Member m) -> m.getName();
		 * Then when you call:
		 * 		functionObj.apply(m1);
		 * It becomes:
		 * 		m1.getName(); // "Alice"
		 */
		Function<Member, String> functionObj = Member::getName;
		members.stream().sorted(Comparator.comparing(functionObj))
		.forEach(obj -> System.out.print(obj));
		System.out.println();

		System.out.println("sorted with ID using method reference = ");
		members.stream().sorted(Comparator.comparing(Member::getId))
		.forEach(obj -> System.out.print(obj));
		System.out.println();

		System.out.println("Sort after sort with ID & later name using method reference = ");
		members.stream().sorted(Comparator.comparing(Member::getId).thenComparing(Member::getName))
		.forEach(obj -> System.out.print(obj));
		System.out.println();

		System.out.println("reversed with ID using method reference = ");
		members.stream().sorted(Comparator.comparing(Member::getId).reversed())
		.forEach(obj -> System.out.print(obj));
		System.out.println();	
		
		System.out.println("\nFunction Object with constructor reference : " + functionObj);
		
		Collections.sort(members, Comparator.comparing(Member::getId));
	}
}
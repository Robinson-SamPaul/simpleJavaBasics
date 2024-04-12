package simple;

import java.util.Arrays;
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
		 * We have learnt method reference
		 * It is alternate for lambda expression
		 * Instead lambda;
		 * 		we can use Static Method Reference of static methods
		 * 		we can use Instance Method Reference of non-static methods
		 * 		we can use Constructor Method Reference 
		 * Other thing is, we can use Static method reference, even if it's not static method
		 * How? If the expected return type is Function, eg: comparing(), map(), etc
		 * We can use it
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
	}
}
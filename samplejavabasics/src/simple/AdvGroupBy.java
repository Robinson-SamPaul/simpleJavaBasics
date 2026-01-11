package simple;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AdvGroupBy {

	public static void main(String[] args) {
		
		List<GroupBy> groupBies = Arrays.asList(
				new GroupBy("Sam", 100),
				new GroupBy("Rob", 100),
				new GroupBy("Paul", 93));
		
		Function<GroupBy, Integer> classifier = new Function<GroupBy, Integer>() {
			
			@Override
			public Integer apply(GroupBy t) {
				return t.marks;
			}
		};
		
		Map<Object, List<GroupBy>> groupBy = groupBies.stream().collect(
				Collectors.groupingBy(classifier));
		System.out.println(groupBy);
		
		Map<Object, List<GroupBy>> groupedByMarks = groupBies.stream().collect(
				Collectors.groupingBy(grpBy -> grpBy.marks));
		System.out.println(groupedByMarks);

		List<GroupBy> centumGuys = groupedByMarks.get(100);
		System.out.println(centumGuys);
		List<GroupBy> otherGuys = groupedByMarks.get(93);
		System.out.println(otherGuys);
		
		List<String> list = List.of("one", "two", "three", "four");

		Map<Integer, List<String>> grouped = list.stream()
		    .collect(Collectors.groupingBy(String::length));

		System.out.println(grouped);

	}
}

class GroupBy {
	
	String name;
	int marks;
	
	public GroupBy(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "GroupBy [name=" + name + ", marks=" + marks + "]";
	}
}

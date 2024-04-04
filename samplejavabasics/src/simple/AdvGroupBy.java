package simple;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvGroupBy {

	public static void main(String[] args) {
		
		List<GroupBy> groupBies = Arrays.asList(
				new GroupBy("Sam", 100),
				new GroupBy("Rob", 100),
				new GroupBy("Paul", 93));
		
		Map<Object, List<GroupBy>> groupedByMarks = groupBies.stream().collect(Collectors.groupingBy(grpBy -> grpBy.marks));
		System.out.println(groupedByMarks);

		List<GroupBy> centumGuys = groupedByMarks.get(100);
		System.out.println(centumGuys);
		List<GroupBy> otherGuys = groupedByMarks.get(93);
		System.out.println(otherGuys);
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

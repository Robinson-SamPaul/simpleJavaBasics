package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AeaCollectWords {

	public static void main(String[] args) {
		
		/*
		 * Collection is an interface that represents a group of objects 
		 * Root interface in the Java Collections Framework hierarchy
		 */
		Collection<Integer> integers = new ArrayList<>(); 
		integers.add(3);
		integers.add(5);
		integers.add(4);
		System.out.println(integers);
		
		List<Integer> integerList = (List<Integer>) integers;
		
		/*
		 * Collections is a utility class that provides static methods for working with collections
		 * It is not an interface or a part of the Collections Framework hierarchy 
		 * It is a helper class that offers utility methods for common collection operations
		 */
		System.out.println(integerList);
		Collections.sort(integerList);
		System.out.println(integerList);
		Collections.reverse(integerList);
		System.out.println(integerList);
		Collections.shuffle(integerList);
		System.out.println(integerList);
		Collections_unmodifiableCollection(integerList);
		List<Integer> emptyList = Collections.emptyList();
		System.out.println(emptyList);
		integerList.clear();
		System.out.println(integerList);
		
		/*
		 * The Collectors class in Java provides a set of static factory methods for creating collectors 
		 * Collectors are objects that define how stream elements are accumulated or 
		 * collected into a result container, such as a List, Set, Map, or a custom collection
		 */
		List<String> namesOriginal = Arrays.asList("Alice", "Bob", "Charlie", "Bob");
		System.out.println(namesOriginal);
		List<String> namesCollected1 = namesOriginal.stream().collect(Collectors.toList());
		System.out.println(namesCollected1);
		Set<String> namesCollected2 = namesOriginal.stream().collect(Collectors.toSet());
		System.out.println(namesCollected2);
		List<String> namesCollected3 = namesOriginal.stream().collect(Collectors.toUnmodifiableList());
		System.out.println(namesCollected3);
		
//		Not much info though, will refer this later - https://youtu.be/GPXmofUWj44?si=4MT8SPIqSAT-yLxI
		Collector<Integer, List<Integer>, Integer> collector = Collector.of(
                ArrayList :: new, // () -> new ArrayList<>()
                List :: add, // (list, element) -> list.add(element)
                (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                },
                list -> list.stream().reduce(0, Integer::sum)
        );
		List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Integer sum = numbers.stream().collect(collector);
        System.out.println(sum);

	}
	
	private static void Collections_unmodifiableCollection(List<Integer> integerList) {
		Collection<Integer> constList = Collections.unmodifiableCollection(integerList);
		try {
			constList.add(3);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
package simple;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AfgCollectors {

	public static void main(String[] args) {
		
		/*
		 * The Collectors class in Java provides various utility methods 
		 * for collecting elements from a stream into a collection or 
		 * performing aggregation operations.
		 */

		/*Collects elements of the stream into a List*/
		List<String> list = getStream().collect(Collectors.toList());
		System.out.println("List = " + list);
		
		/*Collects elements of the stream into a Set*/
		Set<String> set = getStream().collect(Collectors.toSet());
		System.out.println("Set = " + set);
		
		/*
		 * Collects elements of the stream into a Map
		 * provide functions to extract keys and values from elements
		 */
		Map<Integer, String> map = getStream().collect(Collectors.toMap(String::length, str->str.toUpperCase()));
		System.out.println("Map = " + map);
		
		/*
		 * Concatenates elements of the stream into a single String, 
		 * optionally with a delimiter, prefix, and suffix.
		 */
		String result = getStream().collect(Collectors.joining(", ", "[", "]"));
		System.out.println("Join = " + result);
		
		/*
		 * Groups elements of the stream by a classifier function, 
		 * creating a Map where keys are the results of the 
		 * classifier function and values are lists of elements
		 */
		Map<Character, List<String>> groupedByFirstLetter = getStream().collect(Collectors.groupingBy(s -> s.charAt(0)));
		System.out.println("Group = " + groupedByFirstLetter);
		
		/*
		 * Partitions elements of the stream into two groups based on a predicate, 
		 * creating a Map<Boolean, List<T>> where true key contains elements 
		 * that match the predicate and false key contains elements that don't.
		 */
		Map<Boolean, List<String>> partitioned = getStream().collect(Collectors.partitioningBy(s -> s.length() > 5));
		System.out.println("Partition = " + partitioned);
		
		/*Collects statistics such as count, sum, min, average, and max for elements of numeric streams*/
		DoubleSummaryStatistics stats = getIntStream().collect(Collectors.summarizingDouble(Integer::intValue));
		System.out.println(
				"Sum = " + stats.getSum() + 
				"\nAverage = " + stats.getAverage() + 
				"\nMinimum = " + stats.getMin() + 
				"\nMaximum = " + stats.getMax() + 
				"\nCount = " + stats.getCount());
		
		/*Counts the number of elements in the stream*/
		long count = getStream().collect(Collectors.counting());
		System.out.println(count);
	}

	private static Stream<String> getStream() {
		return Arrays.asList("apple", "banana", "pine", "berryfruit").stream();
	}

	private static Stream<Integer> getIntStream() {
		Integer[] intArr = {1, 3, 5};
		return Arrays.asList(intArr).stream();
	}
}

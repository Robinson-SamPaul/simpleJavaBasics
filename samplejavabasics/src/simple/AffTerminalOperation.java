package simple;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AffTerminalOperation {

	public static void main(String[] args) {

		Integer[] numbersArray = {1, 2, 3, 4, 5};
		Stream<Integer> stream = Arrays.stream(numbersArray);
		String s = "spliterator";
		
		/*
		 * These terminal operations are used to close the stream 
		 * and produce a result or side-effect. 
		 * They are typically used after intermediate operations like 
		 * filtering, mapping, and sorting to perform computations or 
		 * collect the stream's elements into a final form.
		 */		
		switch(s) {
		
			case "forEach" :
				/*Executes an action for each element in the stream*/
				stream.forEach(element -> System.out.println(element));
				break;
				
			case "toArray":
				/*Converts the stream into an array*/
				Object[] array = stream.toArray();
				System.out.println(array);
				break;
		
			case "reduce":
				/*Reduces the stream to a single value*/
				Optional<Integer> result = stream.reduce((accumulator, element) -> accumulator + element);
				System.out.println(result.get());
				break;
		
			case "collect" :
				/*Collects the elements of the stream into a collection or other structure*/
				Map<String, Integer> map = stream.collect(Collectors.toMap(n -> n.toString(), n -> n));
				System.out.println(map);
				break;
				
			case "minMax":
				/* Finds the minimum or maximum element in the stream based on a comparator */
				Optional<Integer> min = stream.min((a, b) -> a.compareTo(b));
				/* Optional<Integer> max = stream.max(Integer::compareTo); */
				System.out.println(min.get());
				break;
				
			case "count":
				/* Counts the number of elements in the stream */
				long count = stream.count();
				System.out.print(count);
				break;
				
			case "matchVal" :
				/*Checks if any, all, or none of the elements match a given predicate*/
				boolean anyMatch = stream.anyMatch(n -> n==7);
				//boolean allMatch = stream.allMatch(n -> n==7);
				//boolean noneMatch = stream.noneMatch(n -> n==7);
				System.out.print(anyMatch);
				break;
				
			case "matchBool" :
				/*Checks if any, all, or none of the elements match a given predicate*/
				boolean any = stream.anyMatch(n -> n==7);
				//boolean all = stream.allMatch(n -> n==7);
				//boolean none = stream.noneMatch(n -> n==7);
				System.out.print(any);
				break;
				
			case "find":
				/*Returns the first or any element of the stream*/
				Optional<Integer> val = stream.findFirst();
				//Optional<Integer> val = stream.findAny();
				System.out.print(val);
				break;
			
			case "iterator":
				/*Returns an iterator for the stream elements*/
				Iterator<Integer> iterator = stream.iterator();
				if(iterator.hasNext()) {
					System.out.print(iterator.next());
				}
				break;
			
			case "spliterator":
				/*Returns a spliterator for the stream elements*/
				Spliterator<Integer> spliterator = stream.spliterator();
				spliterator.tryAdvance(System.out::print); // print 1st
				System.out.println();
				spliterator.trySplit().forEachRemaining(System.out::print); // split half and print 1st
				System.out.println();
				spliterator.forEachRemaining(System.out::print); // print 2nd half
				break;
		}
		System.out.println();
		
		int[] intArray = {1, 2, 3, 4, 5};
		IntStream strm = Arrays.stream(intArray);
		if(intArray[4] == 5) {
			System.out.print(Arrays.toString(strm.toArray()));
		} else {
			strm.forEach(n -> System.out.print(n));
		}
	}
}

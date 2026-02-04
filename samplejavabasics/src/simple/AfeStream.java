package simple;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AfeStream {
	
	public static void main(String[] args) {
		
		Stream<String> stringStream = Stream.of("apple", "banana", "cherry");
		System.out.println(stringStream);
		System.out.println();
		
		Integer[] intArray = new Integer[] 
			{23, 34, 56, 21, 78, 82, 48, 100, 165, 934, 23, 78};
		Collection<Integer> collection = Arrays.asList(intArray);
		Stream<Integer> stream = collection.stream();
		
		// NOTE: Stream operations can return results - such operations are known as terminal
		// operations. Count is the simplest terminal operation.
		System.out.println("Count the elements in a stream: " + stream.count());
	
		// NOTE: Stream operations can return other streams
		Stream<Integer> distinctStream = collection.stream().distinct();
		System.out.println("Count distinct elements in a stream: " + distinctStream.count());

		Stream<Integer> limitStream = collection.stream().limit(5);
		System.out.println("Count elements in limit stream: " + limitStream.count());

		Stream<Integer> skipStream = collection.stream().skip(10);
		System.out.println("Count elements in skipped stream: " + skipStream.count());

		Stream<Integer> sortedStream = collection.stream().sorted();
		/* Stream to array */
		System.out.println("\nElements in the sorted stream: " + Arrays.toString(sortedStream.toArray()));
		
		boolean greaterThan50 = collection.stream()
				.allMatch(new Predicate<Integer>() {

					@Override
					public boolean test(Integer t) {
						return t > 50;
					}
			
				});
		System.out.println("Are all numbers are greater than 50: " + greaterThan50);

		boolean anyLessThan0 = collection.stream()
				.anyMatch(e -> e < 0);	
		System.out.println("Is any number lesser than 0: " + anyLessThan0);
		
		boolean noneLessThan0 = collection.stream()
				.noneMatch(e -> e < 0);
		System.out.println("Are no numbers lesser than 0: " + noneLessThan0);
		
		System.out.print("\nEven numbers turned to double : ");
		collection.stream()
			.filter(num -> num%2==0)
			.mapToDouble(p -> p)
			.forEach(a -> System.out.print(a+", "));
		System.out.println();
		
		int max =collection.stream()
			.filter(num -> num%2==0)
			.mapToInt(p -> p)
			.max()
			.getAsInt();
		System.out.print("\nMaximum number is : " + max);
		
		double min =collection.stream()
			.filter(num -> num%2==0)
			.mapToInt(p -> p)
			.max()
			.getAsInt();
		System.out.print("\nMinimum number is : " + min);
		
		double sum =collection.stream()
			.filter(num -> num%2==0)
			.mapToInt(p -> p)
			.sum();
		System.out.print("\nSum of number is : " + sum);
		
		double ave =collection.stream()
			.filter(num -> num%2==0)
			.mapToInt(p -> p)
			.average()
			.getAsDouble();
		System.out.print("\nAverage number is : " + ave);
		System.out.println("\n");
		
		/* FlatMap */
		List<String> sentences = Arrays.asList("Hello", "World");

		Function<String, Stream<String>> mapper = new Function<>() {

			@Override
			public Stream<String> apply(String strVal) {
				return strVal
						.chars() // returns IntStream
						.mapToObj(ch -> (char) ch) // int to Char
						.map(String::valueOf); // char to string
			}
		};
		/*
		 * provide a function that maps each element of the stream 
		 * to another stream or collection.
		 */
        List<String> wordsList = sentences.stream()
                .flatMap(mapper) // Split each sentence into words
                .collect(Collectors.toList()); // Collect the words into a list

        System.out.println(wordsList);

	}
}
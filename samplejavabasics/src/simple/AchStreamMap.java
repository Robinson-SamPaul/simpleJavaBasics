package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class AchStreamMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> ls = Arrays.asList(2,3,4,5,6,7);
		Stream<Integer> s1 = ls.stream();
		
		Function<Integer, Integer> fn = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer t) {
				// TODO Auto-generated method stub
				return t*2;
			}
		};
		System.out.println(fn.apply(3));
		Stream<Integer> s2 = s1.map(fn);
//		Stream<Integer> s2 = s1.map(n -> n*2);
		s2.forEach(n -> System.out.print(n + " "));
		
		System.out.println();
		optionalMap();
	}
	
	private static void optionalMap() { // not part of stream, but of optional class/object
		Optional<String> stringValue = Optional.of("Sam");
		Optional<String> nullValue = Optional.ofNullable(null);
		List<Optional<String>> optionals = new ArrayList<>();
		optionals.add(stringValue);
		optionals.add(nullValue);
		
		Function<String, String> mapper = new Function<String, String>() {
			
			@Override
			public String apply(String t) {
				// TODO Auto-generated method stub
				return t.toUpperCase();
			}
		};
		System.out.println(mapper.apply("test"));
		for(Optional<String> string : optionals) {
			// String value = string.map(mapper).orElse("NULL_VALUE");
			String value = string.map(s -> s.toUpperCase()).orElse("NULL_VALUE");
			System.out.println("Value " + value);
		}
	}

}

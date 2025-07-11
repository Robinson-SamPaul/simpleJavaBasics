package simple;

import java.util.Optional;

public class AcpOptional {

	/*
	Optional.of(name);
		Throws NullPointerException if the value is null.
	Optional.ofNullable(name);
		If value is null → returns Optional.empty()
		If value is not null → wraps it like Optional.of(value)
	 */
	public static void main(String args[]) {
		
		String s1 = value(-2);
		if(s1 == null) {
			System.out.println("NULL");
//			System.out.println(s1.charAt(2));
		} else {
			System.out.println(s1.charAt(2)); 
		}
		
		Optional<String> s2 = Optional.ofNullable(value(-2));
		if(s2.isPresent()) {
			System.out.println(s2.get().charAt(2));
		} else {
			System.out.println("NULL");
		}
		
		Optional<String> s3 = Optional.ofNullable(value(-2));
		System.out.println(s3.orElse("NULL"));

		System.out.println();
		
		System.out.println("With empty string " + Optional.ofNullable(""));
		System.out.println("With string value " + Optional.ofNullable("test"));
		System.out.println("With null value" + Optional.ofNullable(null));

		System.out.println();
		
		Optional<String> optional = Optional.ofNullable(null);
		System.out.println("null value " + optional);
		System.out.println("null present " + optional.isPresent());
		System.out.println("null empty " + optional.isEmpty());
		System.out.println();
		
		optional = Optional.of("");
		System.out.println("_ value " + optional);
		System.out.println("_ present " + optional.isPresent());
		System.out.println("_ empty " + optional.isEmpty()); // empty mean null, not empty string
		System.out.println();
		
		optional = Optional.of("test");
		System.out.println("test value " + optional);
		System.out.println("test present " + optional.isPresent());
		System.out.println("test empty " + optional.isEmpty());
		System.out.println();
		
		System.out.println(optional.get());
//		Integer length = optional.map(s -> s.length()).orElse(100);
		Integer length = optional.map(String::length).orElse(100);
		System.out.println(length);
		optional = Optional.ofNullable(null);
		System.out.println(optional.isPresent() ? optional.get() : optional.orElse("test"));
	}
	
	public static String value(int n) {
		
		return (n >= 0) ? "Hello" : null;
	}
	
	public static String temp() {
		return "test";
	}
}

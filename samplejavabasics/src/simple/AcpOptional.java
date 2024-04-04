package simple;

import java.util.Optional;

public class AcpOptional {

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
		
		System.out.println(Optional.ofNullable(""));
		System.out.println(Optional.ofNullable("test"));
		System.out.println(Optional.ofNullable(null));

		System.out.println();
		
		Optional<String> optional = Optional.ofNullable(null);
		System.out.println(optional);
		System.out.println(optional.isPresent());
		System.out.println();
		
		optional = Optional.of("");
		System.out.println(optional);
		System.out.println(optional.isPresent());
		System.out.println(optional.isEmpty());
		System.out.println();
		
		optional = Optional.of("test");
		System.out.println(optional);
		System.out.println(optional.isPresent());
		System.out.println(optional.isEmpty());
		System.out.println();
	}
	
	public static String value(int n) {
		
		return (n >= 0) ? "Hello" : null;
	}
}

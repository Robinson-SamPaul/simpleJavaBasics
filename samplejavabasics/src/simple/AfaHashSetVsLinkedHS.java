package simple;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class AfaHashSetVsLinkedHS {

	public static void main(String[] args) {

		Set<Integer> integers1 = new HashSet<>();
		Set<Integer> integers2 = new LinkedHashSet<>();
		
		Instant start, end;
		
		start = Instant.now();
		addSetValues(integers1);
		end = Instant.now();
		System.err.println(Duration.between(start, end).getNano() + " Add HashSet");
		
		start = Instant.now();
		addSetValues(integers2);
		end = Instant.now();
		System.err.println(Duration.between(start, end).getNano() + " Add LinkedHashSet\n");
		
		start = Instant.now();
		accessSetValues(integers1);
		end = Instant.now();
		System.err.println(Duration.between(start, end).getNano() + " Access HashSet");
		
		start = Instant.now();
		accessSetValues(integers2);
		end = Instant.now();
		System.err.println(Duration.between(start, end).getNano() + " Access LinkedHashSet\n");
		
		start = Instant.now();
		iterateSetValues(integers1);
		end = Instant.now();
		System.err.println(Duration.between(start, end).getNano() + " Iterate HashSet");
		
		start = Instant.now();
		iterateSetValues(integers2);
		end = Instant.now();
		System.err.println(Duration.between(start, end).getNano() + " Iterate LinkedHashSet\n");
	}
	
	/* HashSet is faster */
	public static void addSetValues(Set<Integer> integers) {
		for (int i=0; i<500000; i++) {
			integers.add(i);
		}
	}
	
	/* LinkedHashSet is faster */
	public static void accessSetValues(Set<Integer> integers) {
		for (int i=0; i<500000; i++) {
			integers.contains(i);
		}
	}
	
	/* LinkedHashSet is faster */
	public static void iterateSetValues(Set<Integer> integers) {
		for(Integer i : integers) {
			i.byteValue();
		}
	}

}

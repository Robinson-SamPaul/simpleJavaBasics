package simple;

import java.util.ArrayList;
import java.util.Collection;

public class AbgCollectionGenerics {

	public static void main(String[] args) {
		/*
		 * The diamond operator (<>) in Java is a language feature introduced in Java 7 
		 * that simplifies the creation of generic instances by inferring the type parameters from the context.
		 * After Java 7, we don't need to include the generic in RHS
		 * 
		 * You cannot use <> with anonymous inner classes (until Java 9):
		 * After Java 9, we don't need to include the generic for anonymous inner classes too in RHS
		 */
//		Collection<Object> val = new ArrayList<Object>(); // no need to mention in RHS
		Collection<Object> val = new ArrayList<>();
//		Collection<Integer> val = new ArrayList<>();
		val.add(7);
		val.add("hi");
		System.out.println(val);
		
		System.out.println(ActGenerics.class);
	}

}

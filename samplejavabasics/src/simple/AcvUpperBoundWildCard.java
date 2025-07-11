package simple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class AcvUpperBoundWildCard {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		List<Integer> ints = new ArrayList<>();
		ints.add(6);
		List<Integer> v1 = MathCalc.isNumber1(ints);
		System.out.println(v1.get(0).getClass());
//		List<Integer extends Number> v2 = MathCalc.isNumber2(ints);
		List<? extends Number> v2 = MathCalc.isNumber2(ints); // almost the same, but  name is exactly not visible
		System.out.println(v2.get(0).getClass());

		List<List> listOfLists = new ArrayList<>();
		List<Collection> listOfCollections = new ArrayList<>();
		List<Iterable> listOfIterables = new ArrayList<>();
		List<LinkedList> listOfLinkedLists = new ArrayList<>();
		MathCalc.listCheck(listOfLists);
		MathCalc.listCheck(listOfCollections);
		MathCalc.listCheck(listOfIterables);
//		MathCalc.listCheck(listOfLinkedLists);
		System.out.println("Not works as it is not superclass of arraylist " + listOfLinkedLists);
	}

	/*
	 * extends - upper boundtype/wildcard
	 * super - lower/super boundtype/wildcard
	 */
	
	/*
	 * WE CAN CREATE CLASS, INTERFACE WITH GENERICS(type parameter or a type variable), BUT CAN'T WITH WILDCARDS
	 */
	/*
	 * T is Type parameter 
	 * T extends/super Class Bounded Type Parameter 
	 * T extends Class Upper Bounded Type Parameter 
	 * T super Class Lower Bounded Type Parameter
	 */
}

class MathCalc {
	
	public static<T extends Number> List<T> isNumber1(List<T> value) {
		System.out.println("Number = " + value);
		return value;
	}
	
	public static List<? extends Number> isNumber2(List<? extends Number> value) { // same, but way of using is different
		System.out.println("Number = " + value);
		return value;
	}
	
	public static void listCheck(@SuppressWarnings("rawtypes") List<? super ArrayList> list) { // super/lower bound, if only '?' is mentioned = unbounded similiar to Bounded.
		System.out.println("It works");
	}
	
	public <T> void listCheck1(List<T> list) {
		System.out.println("It works");
	}
	
	// super bounded type won't work, super works only for wildCards
	public <T extends Number> void printDoubleBoundedType(T value) {
	    System.out.println(value.doubleValue());
	}
	
	// below won't work, wildcards won't work for generic method or class definitions, only work for already defined Generics
	/*
	public <? extends Number> void printDoubleBywildCard(? value) {
	    System.out.println(value.doubleValue());
	}
	*/

}


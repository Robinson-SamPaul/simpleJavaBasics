package simple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class AcvUpperBoundWildCard {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
}


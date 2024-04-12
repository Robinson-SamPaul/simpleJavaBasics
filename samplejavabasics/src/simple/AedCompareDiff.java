package simple;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AedCompareDiff {

	public static void main(String[] args) {
		
		System.err.println("check ACC & ACD for more\n");

		beanWithComaparatorsSort();
		/*
		 * Comparable from lang package
		 * Comparable must be implemented with user defined class, In Integer class, it's already implemented
		 * Comparable will have compareTo method
		 * This method will be called automatically when we use sort method
		 * We don't need additional params, called natural ordering as it's in main POJO class
		 * If we want to have different sorting way, we may need to modify comparable method in POJO class
		 */
		beanWithComparablesSort(); // right way
		/*
		 * Comparator from util package
		 * Comparator object must be created and passed to sort method
		 * Comparator will have compare method
		 * We can create n no.of sorting calls by passing different comparator implementations
		 */
		beanWithOutComparatorsSort(); // right way
		beanWithOutComaparableSort();
	}

	private static void beanWithOutComaparableSort() {
		List<BeanWithOutComparable> beanWithComaparators = Arrays.asList(
				new BeanWithOutComparable(1, "Sam"),
				new BeanWithOutComparable(4, "Sam"),
				new BeanWithOutComparable(3, "Sam"),
				new BeanWithOutComparable(2, "Sam"));
		System.out.println("Before sort");
		System.out.println(beanWithComaparators);
		System.out.println("After sort");
		
		Comparable<BeanWithComparable> comparable = new Comparable<BeanWithComparable>() {
			
			@Override
			public int compareTo(BeanWithComparable o) {
				return 0;
			}
		};
		System.out.println(comparable);
	}

	private static void beanWithOutComparatorsSort() {
		List<BeanWithOutComparator> beanWithOutComparators = Arrays.asList(
				new BeanWithOutComparator(1, "Rob"),
				new BeanWithOutComparator(4, "Sam"),
				new BeanWithOutComparator(3, "Paul"),
				new BeanWithOutComparator(2, "Cam"));
		System.out.println("Before sort");
		System.out.println(beanWithOutComparators);
		
		Comparator<BeanWithOutComparator> comparator1 = new Comparator<BeanWithOutComparator>() {
			
			@Override
			public int compare(BeanWithOutComparator o1, BeanWithOutComparator o2) {
				return o1.id - o2.id;
			}
		};
		System.out.println("After sort");
		Collections.sort(beanWithOutComparators, comparator1);
		System.out.println(beanWithOutComparators);
		
		Comparator<BeanWithOutComparator> comparator2 = (o1, o2) -> o1.name.compareTo(o2.name);
		System.out.println("After sort");
		Collections.sort(beanWithOutComparators, comparator2);
		System.out.println(beanWithOutComparators);
	}

	private static void beanWithComparablesSort() {
		List<BeanWithComparable> beanWithComparables = Arrays.asList(
				new BeanWithComparable(1, "Sam"),
				new BeanWithComparable(4, "Sam"),
				new BeanWithComparable(3, "Sam"),
				new BeanWithComparable(2, "Sam"));
		System.out.println("Before sort");
		System.out.println(beanWithComparables);
		Collections.sort(beanWithComparables);
		System.out.println("After sort");
		System.out.println(beanWithComparables);
		System.out.println();
	}

	private static void beanWithComaparatorsSort() {
		List<BeanWithComparator> beanWithComaparators = Arrays.asList(
				new BeanWithComparator(1, "Sam"),
				new BeanWithComparator(4, "Sam"),
				new BeanWithComparator(3, "Sam"),
				new BeanWithComparator(2, "Sam"));
		System.out.println("Before sort");
		System.out.println(beanWithComaparators);
		System.out.println("After sort");
		try {
			Collections.sort(beanWithComaparators, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
	}

}

class BeanWithComparator implements Comparator<BeanWithComparator> {
	
	int id;
	String name;

	public BeanWithComparator(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compare(BeanWithComparator o1, BeanWithComparator o2) {
		return o1.id - o2.id;
	}
}

class BeanWithComparable implements Comparable<BeanWithComparable> {
	
	int id;
	String name;

	public BeanWithComparable(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(BeanWithComparable that) {
		return this.id - that.id;
	}
}

class BeanWithOutComparator {
	
	int id;
	String name;

	public BeanWithOutComparator(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + "]";
	}
}

class BeanWithOutComparable {
	
	int id;
	String name;

	public BeanWithOutComparable(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + "]";
	}
}

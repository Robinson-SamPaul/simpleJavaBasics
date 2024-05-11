package simple;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class AfcTreeSet {

	public static void main(String[] args) {

		Set<Integer> integers = new TreeSet<>();
		integers.add(45);
		integers.add(27);
		integers.add(33);
		integers.add(18);
		System.out.println(integers);
		
		/*
		 * Sorted Ordering: 
		 * 		NavigableSet maintains its elements in sorted order
		 *		according to either the natural ordering of its elements or a 
		 *		custom comparator provided at the time of creation. 
		 * Navigation Methods: 
		 * 		lower(E e):
		 * 			Returns the greatest element in the set strictly less than the given element e, 
		 * 			or null if there is no such element. 
		 * 		floor(E e): 
		 * 			Returns the greatest element in the set less than or equal to the given element e, 
		 * 			or null if there is no such element. 
		 * 		ceiling(E e): 
		 * 			Returns the smallest element in the set greater than or equal to the given element e, 
		 * 			or null if there is no such element. 
		 * 		higher(E e): 
		 * 			Returns the smallest element in the set strictly greater than the given element e, 
		 * 			or null if there is no such element. 
		 * Subset Views: 
		 * 		subSet(fromElement, toElement): 
		 * 			Returns a view of the portion of the set whose elements range from fromElement, 
		 * 			inclusive, to toElement, exclusive. 
		 * 		headSet(toElement): 
		 * 			Returns a view of the portion of the set whose elements are less than 
		 * 			(or equal to, depending on the inclusive/exclusive nature of the implementation) toElement. 
		 * 		tailSet(fromElement): 
		 * 			Returns a view of the portion of the set whose elements 
		 * 			are greater than or equal to fromElement. 
		 * Traversal: 
		 * 		descendingSet(): 
		 * 			Returns a reverse order view of the set. 
		 * 		descendingIterator(): 
		 * 			Returns an iterator over the elements in reverse order.
		 */
		
		NavigableSet<Integer> navigableSet = new TreeSet<>();
		System.out.println(navigableSet);
		
		Comparator<Integer> comparatorInteger = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				/* return o2-o2; */
				return o2-o1;
			}
		};
		Set<Integer> integerSet = new TreeSet<>(comparatorInteger);
		integerSet.add(45);
		integerSet.add(27);
		integerSet.add(33);
		integerSet.add(18);
		System.out.println(integerSet);
		
		Set<TreeSetValue> treeSetValues = new TreeSet<>(
					(obj1, obj2) -> {
						return obj1.id - obj2.id;
					}
				);
		treeSetValues.add(new TreeSetValue(1, "Sam"));
		treeSetValues.add(new TreeSetValue(1, "Sam"));
		treeSetValues.add(new TreeSetValue(2, "Rob"));
		treeSetValues.add(new TreeSetValue(3, "Paul"));
		System.out.println(treeSetValues);
	}

}

class TreeSetValue {
	int id;
	String name;
	
	public TreeSetValue(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "{id=" + id + ", name=" + name + "}";
	}

	/*
	 * compareTo itself will decide duplicates, no need hashcode & equals contract
	 */
	/*
	 * @Override public int hashCode() { return Objects.hash(id, name); }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; TreeSetValue other = (TreeSetValue) obj; return id == other.id &&
	 * Objects.equals(name, other.name); }
	 */
}

/*
 * HashSet:
 * 		Implements the Set interface and uses a hash table for storage.
 * 		Does not guarantee the order of elements.
 * 		Allows null elements.
 * 		Offers constant-time performance for basic operations (add, remove, contains) on average.
 * TreeSet:
 * 		Implements the SortedSet interface and uses a red-black tree for storage.
 * 		Maintains elements in sorted order (natural ordering or custom comparator).
 * 		Does not allow null elements.
 * 		Provides log(n) time complexity for most operations (add, remove, contains).
 * LinkedHashSet:
 * 		Extends HashSet and maintains a doubly linked list alongside the hash table for insertion order.
 * 		Preserves the order of elements as they were inserted.
 * 		Allows null elements.
 * 		Offers performance similar to HashSet for most operations.
 * EnumSet:
 * 		Specialized implementation for sets of enum constants.
 * 		Very efficient and compact representation.
 * 		Ensures type safety (only enum constants of a specific type can be added).
 * 		Provides constant-time performance for most operations.
 * CopyOnWriteArraySet:
 * 		Implements the Set interface and internally uses a copy-on-write array.
 * 		Designed for concurrent access and is thread-safe.
 * 		Suitable for situations where traversal is more frequent than modification.
 * 		Offers snapshot-style iteration.
 */

package simple;

import java.util.Vector;

public class AbiVector {

	public static void main(String[] args) {
//		Vector - unsorted, ordered, duplicate, synchronized, increase 100% of current if exceeds the size.
		Vector<Integer> val = new Vector<>();
		val.add(6);
		val.add(7);
		val.add(7);
		val.add(67);
		System.out.println(val);
		val.remove(0);
		System.out.println(val.capacity()); // default size is 10 {, 20, 40, etc} and it'll extend by 100% of cur size
		for(int i : val) {
			System.out.println(i);
		}
		System.out.println(AelVector.class);
	}

}

/*
 * Vector: 
 * 		Entire data structure is locked
 * Collections.synchronizedList()
 * 		Entire data structure is locked, wraps the existing list into sync list
 * CopyOnWriteArrayList:
 * 		Write operations are synchronized, reads are non locked
 * 
 * HashTable: 
 * 		Entire data structure is locked
 * Collections.synchronizedMap()
 * 		Entire data structure is locked, wraps the existing map into sync map
 * ConcurrentHashMap:
 * 		Write operations are synchronized for each bucket, reads are non locked, and other buckets also non locked
 * 
 * Collections.synchronizedSet()
 * 		Entire data structure is locked, wraps the existing set into sync set
 * CopyOnWriteArraySet:
 * 		Write operations are synchronized, reads are non locked
 */
package simple;

import java.util.HashSet;

public class AbnHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> val = new HashSet<>();
		val.add(454);
		val.add(78);
		val.add(454);
		val.add(567);
		val.add(78);
		System.out.println(val);
		val.remove(78);
		System.out.println(val);
	}

}

/*
 * HashMap (initial size is 16, if 12 values entered which is 75%, then size will be increased to 100% which is 32.)
 * 		Default initial capacity: 16
 * 		Default load factor: 0.75
 * 			Map<String, String> map = new HashMap<>(50);
 * 			You ask for capacity 50, but actual internal capacity will be the nearest power of 2 ≥ 50, which is 64.
 * When you do:
 * 		map.put("apple", 100);
 * Java does:
 * 		int hash = hash("apple"); // calls hashCode() and does some bit-shifting
 * Bucket Index Calculation
 * 		int index = (n - 1) & hash; // n = capacity of array (e.g., 16)
 * 		& is a bitwise AND to fit it into the current array (bucket) range.
 * Store Entry in Array (Table)
 * 		Each bucket is an array index. Inside it stores:
 * 			A LinkedList (Java 7 and earlier)
 * 			A LinkedList or TreeNode (red-black tree) in Java 8+
 * 
 * Collision Handling
 * 		If two keys hash to the same index:
 * 			map.put("bat", 50);
 * 			map.put("tab", 60); // same index as "bat"
 * 		Java uses:
 * 			Chaining: It maintains a linked list at each bucket.
 * 			Treeing (Java 8+): If the linked list grows > 8, 
 * 				it’s converted into a balanced Red-Black Tree for better performance (O(log n) instead of O(n)).
 * 
 * Resize Operation:
 * 		When size > capacity * loadFactor (default 0.75):
 * 			A new, double-sized array is created. 
 * 			All existing entries are rehashed and redistributed. 
 * 			This is an expensive operation.
 */

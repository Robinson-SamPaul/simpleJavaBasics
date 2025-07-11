package simple;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

import simple.AfbEnumSet.Status;

public class AfdDifMaps {
	
	public static void main(String[] args) {
		
		/*
		 * HashMap: 
		 * 		Implements the Map interface and uses a hash table for storage.
		 * 		Provides fast retrieval and insertion of key-value pairs. 
		 * 		Does not guarantee the order of keys and values. 
		 * 		Allows null key and values (but only one null key). 
		 */
		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(1, "Sam");
		hashMap.put(null, "Rob");
		System.out.println(hashMap);
		hashMap.put(null, "Paul");
		System.out.println(hashMap.get(null));
		System.out.println();
		
		/*
		 * TreeMap: 
		 * 		Implements the SortedMap interface and uses a red-black tree for storage. 
		 * 		Maintains keys in sorted (ascending) order. 
		 * 		Provides efficient operations for range views and key-based navigation. 
		 * 		Does not allow null keys (values can be null). 
		 */
		Map<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(4, "Sam");
		treeMap.put(2, "Rob");
		System.out.println(treeMap);
		try {
			treeMap.put(null, "Paul");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println();
		
		/* Difference in speed is as same as hashSet and LinkedHAshSet, refer previous */
		/* 
		 * LinkedHashMap: 
		 * 		Extends HashMap and maintains a doubly linked list alongside the hash table. 
		 * 		Preserves the insertion order of key-value pairs. 
		 * 		Provides predictable iteration order (insertion order or access order). 
		 * 		Allows null keys and values. 
		 */
		Map<Integer, String> lHashMap = new LinkedHashMap<>();
		lHashMap.put(1, "Sam");
		lHashMap.put(null, "Rob");
		System.out.println(lHashMap);
		lHashMap.put(null, "Paul");
		System.out.println(lHashMap);
		System.out.println();
		
		/*
		 * EnumMap: 
		 * 		Specialized implementation for maps with enum keys. 
		 * 		Very efficient and compact representation, optimized for enums. 
		 * 		Ensures type safety (only enum keys of a specific type can be used). 
		 * 		Offers constant-time "performance for most operations". 
		 */
		Map<Status, String> enumMap = new EnumMap<>(Status.class);
		enumMap.put(Status.SUCCESS, "Sam");
		try {
			treeMap.put(null, "Paul");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(enumMap);
		System.out.println();
		
		/* 
		 * IdentityHashMap: 
		 * 		Uses reference equality (==) instead of object equality (equals) for key comparison. 
		 * 		Suitable for scenarios where object identity is important (e.g., caching based on object identity). 
		 * 		Does not override equals and hashCode methods of keys. 
		 */
		Map<Integer, String> identityMap = new IdentityHashMap<>();
		identityMap.put(1, "SAM");
		System.out.println(identityMap);
		System.out.println();
		
		/*
		 * ConcurrentHashMap: 
		 * 		Implements the ConcurrentMap interface and is designed for concurrent access. 
		 * 		Provides thread-safe operations without the need for external synchronization. 
		 * 		Uses fine-grained locking and other techniques for high concurrency. 
		 * 		Supports atomic operations like putIfAbsent, replace, etc. 
		 */
		Map<Integer, String> concurrencyMap = new ConcurrentHashMap<>();
		concurrencyMap.put(3, "Jane");
		System.out.println(concurrencyMap);
		concurrencyMap.forEach((k, v) -> concurrencyMap.put(k+10, v));
		System.out.println(concurrencyMap);
		concurrencyMap.putIfAbsent(4, "four");
        concurrencyMap.computeIfPresent(3, (key, value) -> value.repeat(2));
		System.out.println(concurrencyMap);
		System.out.println();
		
		/*
		 * WeakHashMap: Implements a
		 * map with weak keys. Allows keys to be garbage collected when there are no
		 * strong references to them. Useful for caching or temporary mappings where
		 * keys may become unreachable.
		 */
        Map<String, Integer> weakHashMap = new WeakHashMap<>();

        String key1 = new String("One");
        String key2 = new String("Two");
        String key3 = new String("Thirty");

        weakHashMap.put(key1, 1);
        weakHashMap.put(key2, 2);
        weakHashMap.put(key3, 3);

        System.out.println(weakHashMap);
        
        // remove strong references to key3
        key3 = null;

        // Trigger garbage collection to remove unreferenced keys
        System.gc();

        // Check the size of the WeakHashMap again
        System.out.println(weakHashMap);
	}

}

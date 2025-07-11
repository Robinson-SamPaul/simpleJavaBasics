package simple;

import java.util.LinkedHashMap;
import java.util.Map;

public class AcsLeastRecentlyUsed {
	
	public static void main(String[] args) {
		
		Map<Integer, String> map = new LRUCache<>();
		map.put(1, "AAA");
		map.put(2, "BBB");
		map.put(3, "CCC");
		map.put(4, "DDD");
		map.put(5, "EEE");
		map.put(1, "EEE");
		System.out.println(map);
		
		map.put(6, "FFF");
		System.out.println(map);
		
		map.remove(3);
		System.out.println(map);
	}

}

class LRUCache<K, V> extends LinkedHashMap<K, V> {
	
	private static final long serialVersionUID = 1L;
	private static final int MAX_ENTRIES = 5;
	
	public LRUCache() {
		/*
		Initial Capacity (16): 
			This parameter sets the initial capacity of the LinkedHashMap. 
			It represents the number of buckets that the map can hold initially. 
			Setting it to 16 means that the map will have space for 16 key-value pairs 
			without needing to resize the internal data structures.

		Load Factor (0.75f): 
			The load factor is a measure of how full the LinkedHashMap can be 
			before it needs to be resized to accommodate more entries. 
			The value 0.75f indicates that the map will be resized when it is 75% full. 
			Resizing involves rehashing the elements into a larger data structure to maintain efficiency.

		Access Order (true): 
			This parameter determines the ordering mode for the entries in the map. 
			When access order is set to true, the LinkedHashMap maintains the order of entries 
			based on their access patterns. This means that when an entry is accessed 
			(via get, put, or iteration), it is moved to the end of the iteration order, 
			making it the most recently accessed entry. 
			This feature is crucial for implementing LRU (Least Recently Used) cache behavior.
		*/
		super(16, 0.75f, true);
	}

	@Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) { // is automatically called after every put() operation in LinkedHashMap.
        return size() > MAX_ENTRIES;
    }
}

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
		super(16, 0.75f, true);
	}

	@Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > MAX_ENTRIES;
    }
}

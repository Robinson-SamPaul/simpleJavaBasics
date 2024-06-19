package simple;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
//import java.util.Set;

public class AcqEntryMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> map =  new HashMap<>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		System.out.println(map);
		
		Set<Entry<Integer, String>> entryMap = map.entrySet();
		System.out.println(entryMap);
		for(Entry<Integer, String> entry : map.entrySet()) {
			System.out.print(entry.getKey() + " " + entry.getValue() + "\n");
		}
		Set<Integer> keys = map.keySet();
		for(Integer key : keys) {
			System.out.print(key + " " + map.get(key) + "\n");
		}
	}
	/*
	 * Both approaches achieve similar results, but using entrySet can be more
	 * efficient and expressive, especially in scenarios where you need to work with
	 * both keys and values together or when performance optimizations are necessary
	 */
}

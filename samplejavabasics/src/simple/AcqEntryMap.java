package simple;

import java.util.HashMap;
import java.util.Map.Entry;
//import java.util.Set;

public class AcqEntryMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> map =  new HashMap<>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
//		Set<Entry<Integer, String>> entryMap = map.entrySet();
		for(Entry<Integer, String> entry : map.entrySet()) {
			System.out.print(entry.getKey() + " " + entry.getValue());
		}
	}

}

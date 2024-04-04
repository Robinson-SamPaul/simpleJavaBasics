package simple;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AcmStreamToList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> m = new HashMap<>();
		m.put(1, "Sam");
		m.put(2, "Paul");
		m.put(1, "Rob"); // map won't allow duplicate keys
		m.put(3, "Rob");
		System.out.println(m);
		System.out.println(m.entrySet());
		System.out.println(m.values());
		
		Collection<String> c = m.values();
		List<String> ls = c.stream().collect(Collectors.toList());
		ls.forEach(n -> System.out.println(n));		
	}

}

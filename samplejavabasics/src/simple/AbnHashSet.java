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
//		System.out.println(val);
	}

}

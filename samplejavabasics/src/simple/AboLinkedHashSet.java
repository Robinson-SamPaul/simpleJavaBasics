package simple;

import java.util.LinkedHashSet;

public class AboLinkedHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashSet<Integer> val = new LinkedHashSet<>();
		val.add(454);
		val.add(78);
		val.add(567);
		val.remove(78);
		System.out.println(val);
	}

}

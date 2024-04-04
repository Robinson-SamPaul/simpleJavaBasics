package simple;

import java.util.TreeSet;

public class AbpTreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> val = new TreeSet<>();
		val.add(454);
		val.add(78);
		val.add(3);
		val.add(567);
		val.remove(78);
		System.out.println(val);
	}

}

package simple;

import java.util.ArrayList;
import java.util.Collection;

public class AbgCollectionGenerics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<Object> val = new ArrayList<>();
//		Collection<Integer> val = new ArrayList<>();
		val.add(7);
		val.add("hi");
		System.out.println(val);
	}

}

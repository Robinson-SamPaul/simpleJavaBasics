package simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AccComparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ls = new ArrayList<>();
		ls.add(4);
		ls.add(1);
		ls.add(3);
		ls.add(2);
		
		Collections.sort(ls);
		System.out.println(ls);
		
//		Comparator<Integer> cr = new Comparator<Integer>() { // for anonymous inner class, generics is must in constructor
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				
//				if(o1 < o2) {
//					return 1;
//				}
//				return -1;
//			}
//		
//		};	
		
		Comparator<Integer> cr = (o1, o2) -> (o1 < o2) ? 1 : -1;	
		Collections.sort(ls, cr);
		System.out.println(ls);
		
		Collections.sort(ls, (o1, o2) -> (o1 < o2) ? 1 : -1);
		System.out.println(ls);
	}

}

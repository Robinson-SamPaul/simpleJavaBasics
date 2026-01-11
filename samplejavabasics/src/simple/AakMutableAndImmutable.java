package simple;

import java.util.HashSet;

public class AakMutableAndImmutable {

	@SuppressWarnings("removal")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a = new Integer(3);		
		Integer b = new Integer(3);
		int c = 3;
		int d = 3;
		Integer e = 3;
		Integer f = 3;
		Integer g = Integer.valueOf(3);
		Integer h = Integer.valueOf(3);

		System.err.println(a == b);
		System.err.println(e == f);
		System.err.println(g == h);
		System.err.println(a.equals(b));
		System.err.println(a.hashCode() == a.hashCode());
		
		HashSet<Integer> hashSet1 = new HashSet<Integer>();
		hashSet1.add(a);
		hashSet1.add(b);
		hashSet1.add(e);
		hashSet1.add(f);
		hashSet1.add(g);
		hashSet1.add(h);
		System.out.println(hashSet1);
		
		System.out.println(a.hashCode() + "\n" + b.hashCode() + "\n" + e.hashCode() + "\n" + f.hashCode() + "\n" + g.hashCode() + "\n" + h.hashCode() + "\n");
		System.out.print(System.identityHashCode(a) + "\n" + System.identityHashCode(b));
		System.out.println("\n\n" + System.identityHashCode(c) + "\n" + System.identityHashCode(d) + "\n" + System.identityHashCode(e) + "\n" + System.identityHashCode(f) + "\n" + System.identityHashCode(g) + "\n" + System.identityHashCode(h));
		
		/*
		 * Java caches only finite, small, discrete-value wrappers:
			Byte, Short, Integer, Long, Character <0 to 127 (\u0000–\u007F)>
		 */
		// Integer caching
        Integer cache1 = 127;
        Integer cache2 = 127;
        System.out.println(cache1 == cache2); // true

        Integer cache3 = 128;
        Integer cache4 = 128;
        System.out.println(cache3 == cache4); // false

        // Byte, Short, Long also same -128 to 127
        // double, Float - no caching at all

        // Character caching
        Character cache5 = 65;
        Character cache6 = 65;
        System.out.println(cache5 == cache6); // true

        Character cache7 = 128;
        Character cache8 = 128;
        System.out.println(cache7 == cache8); // false

	}
}

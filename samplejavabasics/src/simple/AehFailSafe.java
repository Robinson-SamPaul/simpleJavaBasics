package simple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AehFailSafe {

	public static void main(String[] args) {

		List<Integer> integers = new ArrayList<>();
		integers.add(2);
		integers.add(2);
		integers.add(4);
		integers.add(3);
		integers.add(2);
		
		/*
		 * integers.remove(3); // this will remove the 3rd index
		 * integers.remove(Integer.valueOf(3)); // this will remove the 3 value
		 */	
		
		concurrentModification(integers);
		
		/*
		 * v r getting concurrent modification exception
		 * as v trying to manipulate collection
		 * while iterating through it
		 * still, it'll remove/add/any process
		 * but throw exception
		 * to avoid
		 * v can use iterator
		 */
		System.out.println(integers);
		
		checkCheckedException(integers);
		
		Iterator<Integer> iterator = integers.iterator();
		
		while (iterator.hasNext()) {
			if(iterator.next() == 4) {
				iterator.remove();  // modifying, while iterating, but no issue
			}
		}
		System.out.println(integers);  // iterator removed the value(4) in list
	}
	
	private static void concurrentModification(List<Integer> integers) {
		/*
		 * in below blocks of try catch,
		 * 2nd catch block is executed
		 * Why? because
		 * lambda function can't work with runtime exception
		 * so, it'll throw the exception to method signature
		 * which is forEach method in below example
		 * from their exception will be thrown
		 * so, 2nd catch block will be executed
		 */
		try {
			integers.forEach(n -> {
				System.out.print(n + " ");
				if(n == 3) {
					try {
						integers.remove(Integer.valueOf(3)); // unchecked exception, runtime
					} catch (Exception e) {
						System.out.println("\n1 " + e);
					}
				}
			});
		} catch (Exception e) {
			System.out.println("\n2 " + e);
		}
	}
	
	private static void checkCheckedException(List<Integer> integers) {
		/**
		 * here compile time, exception, so it goes to 1st catch itself
		 * as lambda can handle it
		 */
		try {
            integers.forEach(n -> {
                if (n == 4) {
                    try {
                        throw new IOException(); // checked exception, compile time, IDE asks to handle it
                    } catch (IOException e) {
                        System.out.println("1 " + e);
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("2 " + e);
        }
	}

}

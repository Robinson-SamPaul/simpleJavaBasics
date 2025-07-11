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
		 * v r getting concurrent modification exception as v trying to manipulate
		 * collection while iterating through it still, it'll remove/add/any process but
		 * throw exception, to avoid v can use iterator
		 */
		System.out.println(integers);

		// basically, if exception occurs in iterator/collection, then exception will be thrown at 2nd catch block
		checkCheckedException(integers);

		Iterator<Integer> iterator = integers.iterator();

		while (iterator.hasNext()) {
			if (iterator.next() == 4) {
				/*
				 * we can remove iterator object, but not list object for example;
				 * iterator.remove(); can be done 
				 * integers.add(2); can't, 
				 * even though we're using inside iterator
				 * 
				 * And even though we have try catch block for concurrentModificationException
				 * still it'll throw error
				 */
				iterator.remove(); // modifying, while iterating, but no issue
			}
		}
		System.out.println(integers); // iterator removed the value(4) in list

		ArrayList<String> students = new ArrayList<String>();
		students.add("Emma");
		students.add("Paul");
		students.add("Walker");
		students.add("Elanie");
		students.add("Amara");

		Iterator<String> itr = students.iterator();

		try {
			while (itr.hasNext()) {
				if (itr.next().equals("Paul")) {
					try {
//						itr.remove(); // this will work
						students.remove("Amara");
					} catch (Exception e) {
						// this is not being executed, as exception thrown at iterator, not remove() method
						System.out.println("First catch block"); 
						System.out.println(e);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Second catch block");
			System.out.println(e);
		}
	}

	private static void concurrentModification(List<Integer> integers) {
		/*
		 * The second catch block is getting executed 
		 * because the exception occurs outside the forEach lambda expression
		 * 
		 * You are iterating over a collection (integers) using the forEach method
		 * Inside the forEach lambda expression, you print the current integer (n).
		 * When the integer n is 3, you try to remove the integer 3 
		 * from the integers collection within the lambda expression.
		 * Removing an element from the collection 
		 * while iterating over it using forEach results in a ConcurrentModificationException.
		 * This exception is thrown by the underlying collection's iterator, 
		 * and it is not caught by the inner catch block inside the lambda expression 
		 * because it propagates out of the lambda expression.
		 */
		try {
			integers.forEach(n -> {
				System.out.print(n + " ");
				if (n == 3) {
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
		 * here checked time, exception, so it goes to 1st catch itself as lambda can
		 * handle it
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
	
	@SuppressWarnings("unused")
	private static void checkUncheckedException(List<Integer> integers) {
		/**
		 * Exception occurs in that particular line only, not to the collection or iterator
		 */
		try {
			integers.forEach(n -> {
				if (n == 4) {
					try {
						System.out.println(n/0);
					} catch (Exception e) {
						System.out.println("1 " + e);
					}
				}
			});
		} catch (Exception e) {
			System.out.println("2 " + e);
		}
	}
}

package simple;

@SuppressWarnings("unused")
public class AfkOtherComplex {

	public static void main(String[] args) {
		
		/* 
		 * O(N) = O(N)
		 * O(N+k) ~ O(N)
		 * O(N*k) ~ O(N)
		 * O(N/k) ~ O(N)
		 *  
		 */

		/*
		 * Linear Time Complexity
		 * Order of N - O(N)
		 */
		int[] array = {1, 2, 3, 4, 5};
		getN(array);
		System.out.println();

		/*
		 * Quadratic Time Complexity
		 * Order of N^2 - O(N^2)
		 */
		getNsquare(array);
		System.out.println();

		/*
		 * Cubic Time Complexity
		 * Order of N^3 - O(N^3)
		 */
		getNcube(array);
	}

	private static void getN(int[] array) {
		int count = 0;
		for (int i : array) {
			count++;
		}
		System.out.println("Count = " + count);
	}

	private static void getNsquare(int[] array) {
		int count = 0;
		for (int i : array) {
			for (int j : array) {
				count++;
			}
		}
		System.out.println("Count = " + count);
	}

	private static void getNcube(int[] array) {
		int count = 0;
		for (int i : array) {
			for (int j : array) {
				for (int k : array) {
					count++;
				}
			}
		}
		System.out.println("Count = " + count);
	}
}

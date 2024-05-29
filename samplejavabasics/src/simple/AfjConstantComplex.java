package simple;

public class AfjConstantComplex {

	public static void main(String[] args) {
		
		/*
		 * Time Complexity:
		 * 		How long the algorithm takes to read the file, prepare it for transfer, and send it.
		 * 
		 * Space Complexity:
		 * 		How much memory is required to store the file during transfer.
		 * 
		 * Network Bandwidth:
		 * 		The rate at which the file can be transmitted over the network to its destination.
		 */

		/*
		 * Constant Time Complexity
		 * Order of 1 - O(1)
		 */
		int[] array = {1, 2, 3, 4, 5};
		get(array);
	}

	private static void get(int[] array) {
		System.out.println("Print First element = " + array[0]);
	}
}

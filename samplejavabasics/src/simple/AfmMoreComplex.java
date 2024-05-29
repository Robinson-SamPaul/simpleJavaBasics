package simple;

public class AfmMoreComplex {

	public static void main(String[] args) {

		/*
		 * Exponential Time Complexity
		 * Order of N - O(2^N)
		 */
		getExponential(5);

		/*
		 * Exponential Time Complexity
		 * Order of N - O(2^N)
		 */
		getFactorial(5);
	}
	
	private static void getFactorial(int n) {
		int num = factorial(n);
		for(int i=0; i<num; i++) {
			if(i == num-1) {
				System.err.println("O(2N!) = " + (i + 1));
			}
		}		
	}
	
	private static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

	private static void getExponential(int n) {
		int num = (int) Math.pow(2, n);
		for(int i=0; i<num; i++) {
			if(i == num-1) {
				System.err.println("O(2^N) = " + (i + 1));
			}
		}
	}
}

package simple;

public class AflLogarithmicComplex {
    
	public static void main(String[] args) {

		/*
		 * Logarithmic Time Complexity (better than Linear, Quadratic, Cubic)
		 * Order of N - O(Log N)
		 * 
		 * After 1st step: N/2
		 * After 2nd step: N/4
		 * After 3rd step: N/8
		 * ..........
		 * 
		 * 1 = N/2^k
		 * 2^k = N
		 * log2 N = K
		 * 
		 * binary search algorithm is example
		 */
        get(1024);
    }
	
	private static void get(int n) {
		
        int count = 0;
        while (n > 1) {
            n = n / 2;
            count++;
        }
        
        System.out.println("Number of divisions: " + count);
	}
}

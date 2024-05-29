package programs;

public class CheckPrime {

    public static void main(String[] args) {
    	int number = 49;
        System.out.println("Is " + number + " prime? " + isPrime(number));
    }

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        
    	// Edge cases
        if (number <= 1) {
            return false; // 0, 1, and negative numbers are not prime
        }
        
        if (number == 2 || number == 3) {
            return true; // 2 and 3 are prime numbers
        }
        
        if (number % 2 == 0 || number % 3 == 0) {
            return false; // Multiples of 2 or 3 are not prime
        }

		/*
		 * A number is divisible by 2 if its last digit is even 
		 * A number is divisible by 3 if the sum of its digits is divisible by 3
		 * Divisibility by 6 combines the rules for divisibility by 2 and 3 
		 * A number is divisible by 6 if it's divisible by both 2 and 3
		 * 
		 * When a number is divided by 6, the possible remainders are 0, 1, 2, 3, 4, or 5
		 * 6 divided by 6 leaves a remainder of 0
		 * 7 divided by 6 leaves a remainder of 1
		 * 8 divided by 6 leaves a remainder of 2
		 * 9 divided by 6 leaves a remainder of 3
		 * 10 divided by 6 leaves a remainder of 4
		 * 11 divided by 6 leaves a remainder of 5.
		 * 
		 * Remainder 1: 6𝑘+1
		 * Remainder 2: 6𝑘+2 (even, already excluded)
		 * Remainder 3: 6𝑘+3 (multiple of 3, already excluded)
		 * Remainder 4: 6𝑘+4 (even, already excluded)
		 * Remainder 5: 6𝑘+5
		 * 
		 * Prime numbers greater than 3 that are not divisible by 2 or 3 
		 * must fall into one of these forms (6k+1 or 6k+5)
		 * 
		 * it checks for factors from 5 up to the square root of the number, 
		 * using a loop that increments by 6 
		 * as ***all primes greater than 3 are of the form 6n ± 1***, 
		 * and if any factor is found, the number is considered non-prime
		 */

        for (int i = 5; i * i <= number; i += 6) {
        	System.out.println("i = " + i + "\ti\u00B2 = " + i*i);
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        /*
         * The reason we iterate only up to the square root of the number, 
         * rather than all the way to the number itself, is based on a mathematical property of factors.
         * If a number 𝑛 is not a prime, it can be factored into two factors, say 
         * 𝑎 and 𝑏, such that: 𝑛 = 𝑎 × 𝑏
         * If both 𝑎 and 𝑏 were greater than the square root of 𝑛, 
         * then their product 𝑎 × 𝑏 would be greater than 𝑛, which is a contradiction
         * At least one of those factors must be less than or equal to the square root of 𝑛
         * Hence, to check if 𝑛 has any factors (and thus is not a prime), 
         * it's sufficient to check for divisors from 2 up to 𝑛
         * Example: n=36, Factors pairs are (2, 18), (3, 12), (4, 9), and (6, 6).
         * We only need to check up to 6 (which is36), 
         * because any factor larger than 6 would have a corresponding factor smaller than 6.
         */
        
        return true; // If no factors are found, the number is prime
    }
}

package szabados.alpar.exercises.euler

import org.junit.Test

import static szabados.alpar.exercises.euler.Utils.*

class Euler_4 {

    /**
     * <strong>Problem 4: Largest palindrome product</strong>
     * <p>
     * A palindromic number reads the same both ways. The largest palindrome made
     * from the product of two 2-digit numbers is 9009 = 91 × 99.
     * <p>
     * Find the largest palindrome made from the product of two 3-digit numbers.
     * <p>
     * See also <a href="https://projecteuler.net/problem=4">projecteuler.net problem 4</a>.
     */
    @Test
    public void shouldSolveProblem3() {
        assert (largestPalindromeOfProductsFromFactorsInRange(10, 99)) == 9009
        assert (largestPalindromeOfProductsFromFactorsInRange(100, 999)) == 906609
    }

    static final int largestPalindromeOfProductsFromFactorsInRange(int min, int max){
        int palindrome = 0
        for (i in max..min) {
            for (j in max..min) {
                def result = i * j
                if (result <= palindrome) break
                if (result == numberInReverse(result)) {
                    palindrome = result
                    break
                }
            }
        }
        palindrome
    }
}

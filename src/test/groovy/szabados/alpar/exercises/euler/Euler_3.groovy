package szabados.alpar.exercises.euler

import org.junit.Test

import static szabados.alpar.exercises.euler.Utils.primeFactorsOf

class Euler_3 {

    /**
     * <strong>Problem 3: Largest prime factor</strong>
     * <p>
     * The prime factors of 13195 are 5, 7, 13 and 29.
     * <p>
     * What is the largest prime factor of the number 600851475143?
     * <p>
     * See also <a href="https://projecteuler.net/problem=3">projecteuler.net problem 3</a>.
     */
    @Test
    public void shouldSolveProblem3() {
        assert biggestPrimeFactorOf(23) == 23
        assert biggestPrimeFactorOf(24) == 3
        assert biggestPrimeFactorOf(600_851_475_143) == 6857
    }

    private static long biggestPrimeFactorOf(long num) {
        return primeFactorsOf(num).max()
    }
}

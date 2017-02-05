package szabados.alpar.exercises.euler

import org.junit.Test

import static szabados.alpar.exercises.euler.Utils.primeFactorsOf

class Euler_05 {

    /**
     * <strong>Problem 5: Smallest multiple</strong>
     * <p>
     * 2520 is the smallest number that can be divided by each of the numbers from 1
     * to 10 without any remainder.
     * <p>
     * What is the smallest positive number that is evenly divisible by all of the
     * numbers from 1 to 20?
     * <p>
     * See also <a href="https://projecteuler.net/problem=5">projecteuler.net problem 5</a>.
     */
    @Test
    public void shouldSolveProblem5() {
        assert smallestPositiveNumberEvenlyDivisibleByAllNumbersFrom1To(10) == 2_520
        assert smallestPositiveNumberEvenlyDivisibleByAllNumbersFrom1To(20) == 232_792_560
    }

    private static long smallestPositiveNumberEvenlyDivisibleByAllNumbersFrom1To(int max) {
        def lowestCommonMultiple = 2
        (2..max).each { int n ->
            if (lowestCommonMultiple % n != 0)
                lowestCommonMultiple *= primeFactorsOf(n).min()
        }
        lowestCommonMultiple
    }
}

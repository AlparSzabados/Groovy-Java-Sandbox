package szabados.alpar.exercises.euler

import org.junit.Test

class Euler_10 {

    /**
     * <strong>Problem 10: Summation of primes</strong>
     * <p>
     * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
     * <p>
     * Find the sum of all the primes below two million.
     * <p>
     * See also <a href="https://projecteuler.net/problem=10">projecteuler.net problem 10</a>.
     */
    @Test
    public void shouldSolveProblem10() {
        assert sumOfPrimesBelow(10) == 17
        assert sumOfPrimesBelow(2_000_000) == 142_913_828_922
    }

    private static long sumOfPrimesBelow(int limit) {
        long sum = 0
        BitSet composite = new BitSet(limit)
        int end = Math.sqrt(limit)

        for (int i = 2; i <= end; i++)
            if (!composite.get(i))
                for (int j = i * i; j <= limit; j += i)
                    composite.set(j)

        for (int i = 2; i <= limit; i++)
            if (!composite.get(i))
                sum += i

        sum
    }
}

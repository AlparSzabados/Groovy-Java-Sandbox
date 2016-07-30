package szabados.alpar.exercises.euler

import org.junit.Test

import static szabados.alpar.exercises.euler.Utils.isPrime

class Euler_7 {

    /**
     * <strong>Problem 7: 10001st prime</strong>
     * <p>
     * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
     * <p>
     * What is the 10 001st prime number?
     * <p>
     * See also <a href="https://projecteuler.net/problem=7">projecteuler.net problem 7</a>.
     */
    @Test
    public void shouldSolveProblem7() {
        assert prime(1) == 2
        assert prime(2) == 3
        assert prime(3) == 5
        assert prime(4) == 7
        assert prime(5) == 11
        assert prime(6) == 13
        assert prime(10_001) == 104_743
    }

    private static long prime(long limit) {
        long count = 1
        long maxPrime = 0
        for (int i = 2; count <= limit; i++) {
            if (isPrime(i)) {
                maxPrime = i
                count++
            }
        }
        maxPrime
    }
}

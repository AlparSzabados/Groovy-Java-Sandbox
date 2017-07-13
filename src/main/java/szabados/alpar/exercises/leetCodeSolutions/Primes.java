package szabados.alpar.exercises.leetCodeSolutions;

import java.util.BitSet;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class Primes {
    public int countPrimes(int n) {
        BitSet isComposite = new BitSet(n);
        for (int i = 2, length = (int) Math.sqrt(n); i <= length; i++) {
            for (int j = i * i; j < n; j += i) {
                isComposite.set(j);
            }
        }
        return Math.max(0, n - (isComposite.cardinality() + 2));
    }
}

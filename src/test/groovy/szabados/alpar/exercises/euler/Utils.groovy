package szabados.alpar.exercises.euler

class Utils {
    static final List<Integer> fibonacci(int limit = 0) {
        int n1 = 0
        int n2 = 1
        List<Integer> fibNumbersList = [n1, n2]

        int fibNum = 0
        while ((fibNum + n1) < limit) {
            fibNum = n1 + n2
            n1 = n2
            n2 = fibNum
            fibNumbersList += fibNum
        }
        fibNumbersList
    }

    static final List<Long> primeFactorsOf(long num) {
        List<Long> primes = []
        long primeNum = 2
        while (primeNum <= num) {
            if (num % primeNum == 0L) {
                num /= primeNum
                primes += primeNum
            } else
                primeNum++
        }
        primes
    }

    static int numberInReverse(int num) {
        def numReverse = 0
        while (num > 0) {
            numReverse = (numReverse * 10) + (num % 10)
            num /= 10
        }
        numReverse
    }
    static boolean isPrime(long n) {
        if (n == 2L) return true
        if (n % 2 == 0L && n != 2L) return false
        for (long i = 3; i <= Math.sqrt(n) + 1; i += 2) {
            if (n % i == 0L) return false;
        }
        return true;
    }
}
package szabados.alpar.exercises.euler

class Utils {
    static final List<Integer> fibonacci(int limit = 0) {
        int n1 = 0
        int n2 = 1
        List<Integer> isEven = [n1, n2]

        int fibNum = 0
        while ((fibNum + n1) < limit) {
            fibNum = n1 + n2
            n1 = n2
            n2 = fibNum
            isEven += fibNum
        }
        isEven
    }

    static final List<Long> primeFactorsOf(long num){
        List<Long> primes = []
        long primeN = 2
        while (primeN < num) {
            if (num % primeN == 0L ) {
                num /= primeN
                primes += primeN
            } else {
                primeN++
            }
        }
        primes += primeN
        primes
    }

    static int numberInReverse(int num) {
        def numReverse = 0
        while(num > 0){
            numReverse = (numReverse * 10) + (num % 10)
            num /= 10
        }
        numReverse
    }
}
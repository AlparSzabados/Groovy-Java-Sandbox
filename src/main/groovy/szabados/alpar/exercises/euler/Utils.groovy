package szabados.alpar.exercises.euler

class Utils {
    static final ArrayList<Integer> fibonacci(int limit = 0, int n1 = 0, int n2 = 1) {
        ArrayList<Integer> result = [n1, n2]

        int fibNum = 0
        while (fibNum < limit) {
            fibNum = n1 + n2
            n1 = n2
            n2 = fibNum

            if (fibNum > limit) {
                break
            } else {
                result += fibNum
            }
        }
        result
    }
}
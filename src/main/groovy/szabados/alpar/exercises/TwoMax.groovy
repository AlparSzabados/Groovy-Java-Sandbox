package szabados.alpar.exercises

class TwoMax {
    static List<Integer> findTwoMax(List<Integer> list) {
        List<Integer> max1 = []

        for (int n : list) {
            if (n > max1[0]) {
                max1[0] = n
            } else if (n <= max1[0]) {
                max1[1] = n
            }
        }
        return max1
    }
}
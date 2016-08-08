package szabados.alpar.exercises

class TwoMax {
    static List<Integer> findTwoMax(List<Integer> list) {
        List<Integer> twoMax = []

        for (int n : list) {
            if (n > twoMax[1]) {
                twoMax[0] = twoMax[1]
                twoMax[1] = n
            } else if (n <= twoMax[1] && n > twoMax[0])
                twoMax[0] = n
        }
        return twoMax.findAll { it != null }
    }
}
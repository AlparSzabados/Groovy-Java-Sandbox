package szabados.alpar.exercises

class Sort {
/* Sort an array of values */

    static List<Integer> sortListOfIntegers(List<Integer> list) {
        int valueSize = list.size()

        for (i in 0..<valueSize) {
            int minValue = i
            for (j in (i + 1)..<valueSize)
                if (list[j] < list[minValue])
                    minValue = j as int

            if (i != minValue)
                list.swap(i, minValue)
        }
        list
    }
}
package szabados.alpar.exercises

/* Sort an array of values */

def values = [1, 2, 3, 9, 1000, 0, 99, 8, 7, 7, 1, 0, 0]

int valueSize = values.size()

for (i in 0..<valueSize) {
    int minValue = i
    for (j in (i + 1)..<valueSize)
        if (values[j] < values[minValue])
            minValue = j as int

    if (i != minValue)
        values.swap(i, minValue)
}

assert values == [0, 0, 0, 1, 1, 2, 3, 7, 7, 8, 9, 99, 1000]

package szabados.alpar.exercises

/* Sort a random array of values */

def values = [1, 2, 3, 9, 1000, 0, 99, 8, 7, 7, 1, 0, 0]

for (i in values.indices)
    for (j in values.indices) {
        if (values[i] < values[j]) {
            values.swap(i, j)
        }
    }

assert values == [0, 0, 0, 1, 1, 2, 3, 7, 7, 8, 9, 99, 1000]
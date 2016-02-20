package szabados.alpar.exercises

/* Sort a random array of numbers */

def numbers = [1, 2, 3, 9, 1000, 0, 99, 8, 7, 7, 1, 0, 0]

for (number in numbers.indices) {
    for (index in numbers.indices) {
        def compare = numbers[number].compareTo(numbers[index])
        if (compare == -1) {
            def numberReplace = numbers[index]
            numbers[index] = numbers[number]
            numbers[number] = numberReplace
        }
    }
}

println numbers
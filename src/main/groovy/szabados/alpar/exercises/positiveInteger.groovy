package szabados.alpar.exercises

// TODO optimize it to O(n**3) at least

def counter = 0
for (a in 1..200) {
    for (b in 1..200) {
        def value1 = a**3 + b**3
        for (c in 1..200) {
            for (d in 1..200) {
                def value2 = c**3 + d**3
                if (a != c && b != d && a != d && b != c && value1 == value2) {
                    counter += 1
                    println "${a}^3 + ${b}^3 = ${c}^3 + ${d}^3"
                }
            }
        }
    }
}

println counter

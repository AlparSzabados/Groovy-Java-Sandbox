package szabados.alpar.exercises

def container3L = [0, 0, 0]
def container5L = [0, 0, 0, 0, 0]
println "The 3L jar and the 5L jar is empty: $container3L $container5L"

for (i in container5L.indices) {
    container5L[i] = 1
}
println "Filling up the 5L jar, the 3L jar remains empty: $container3L $container5L"

for (i in container3L.indices) {
    container3L[i] = container5L[i]
    container5L[i] = 0
}
println "Filling up the 3L jar from the 5L jar: $container3L $container5L"

for (i in container3L.indices) {
    container3L[i] = 0
}
println "Emptying the 3L jar: $container3L $container5L"

def counter = 0
for (i in container5L.indices) {
    if (container5L[i] == 1) {
        container3L[counter] = 1
        counter += 1
        container5L[i] = 0
    }
}
println "Pouring the water from the 5L jar to the 3L jar: $container3L $container5L"

for (i in container5L.indices) {
    container5L[i] = 1
}
println "Filling up the 5L jar again: $container3L $container5L"

container3L[2] = container5L[0]
container5L[0] = 0
println "Filling up the 3L jar from the 5L jar : $container3L $container5L"
println "The 5L jar now contains 4 liters of water. SUCCESS!"

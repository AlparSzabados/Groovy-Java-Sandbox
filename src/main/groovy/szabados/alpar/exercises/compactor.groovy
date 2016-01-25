package szabados.alpar.exercises

// TODO write test for it

def text = 'aaaccdefss' as List

/* Compacts a string of repeating characters */

def result = ''
def count = 0
for (i in 0..text.size()) {
    count++
    if (text[i] != text[i + 1]) {
        result += (text[i] + count)
        count = 0
    }
}

println result
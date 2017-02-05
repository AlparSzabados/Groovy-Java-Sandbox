package szabados.alpar.exercises

// TODO write test

/* All Permutations of a small string in a big string */

def text = 'abcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefghijk'
def word = 'abcdefghijk'

def bigStringUnsorted = []
def smallStringSorted = word.toList().sort()

def wordEnd = word.size() - 1
def textSize = text.size() - word.size()
for (i in 0..textSize) {
    bigStringUnsorted << text[i..wordEnd]
    wordEnd += 1
}

bigStringUnsorted.eachWithIndex { unsorted, index ->
    def list = unsorted as List
    def bigStringSorted = list.sort()
    if (bigStringSorted == smallStringSorted) {
        println "Permutation on index ${index} : ${unsorted}"
    }
}

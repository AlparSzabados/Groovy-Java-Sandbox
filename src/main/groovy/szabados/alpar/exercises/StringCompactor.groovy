package szabados.alpar.exercises

class StringCompactor {
/* Compacts a string of repeating characters */

    static compactString(String s) {
        List<String> text = s.toList()
        String compactedString = ''

        int counter = 0
        for (int i in 0..<text.size()) {
            counter++
            if (text[i] != text[i + 1]) {
                compactedString += (text[i] + counter)
                counter = 0
            }
        }
        compactedString
    }
}
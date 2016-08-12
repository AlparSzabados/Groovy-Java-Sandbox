package szabados.alpar.exercises.euler

class Helper {
    static createMatrix(String st) {
        def s = st.replaceAll("\\s", '')
        def MATRIX = []
        def rows = []
        def counter = 0

        for (int i = 0; i < s.length() - 1; i += 2) {
            def num = ''
            for (int j = i; j <= i + 1; j++)
                num += s[j]
            rows += num
            counter++
            if (counter == 20) {
                MATRIX += [rows]
                rows = []
                counter = 0
            }
        }
        MATRIX
    }
}

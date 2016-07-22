package szabados.alpar.exercises

class CamelCase {
    static List<String> matching(String pattern, ArrayList<String> classNames) {
        def result = []

        def upperCaseSplitter = "(?=\\p{Lu})"
        def patternSplit = pattern.split(upperCaseSplitter)
        for (int i in 0..<classNames.size()) {
            def classNameSplit = classNames[i].split(upperCaseSplitter)
            def patternSize = patternSplit.size()

            if (classNameSplit.size() >= patternSize) {
                def numberOfHits = 0
                for (int j in 0..<patternSize)
                    if (classNameSplit[j].startsWith(patternSplit[j]))
                        numberOfHits++

                if (numberOfHits == patternSize)
                    result += classNames[i]
            }
        }
        result
    }
}

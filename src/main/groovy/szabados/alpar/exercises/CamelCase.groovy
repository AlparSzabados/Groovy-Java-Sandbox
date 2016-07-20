package szabados.alpar.exercises

class CamelCase {
    static List<String> matching(String pattern, ArrayList<String> classNames) {
        def result = []

        def regEx = "(?=\\p{Lu})"
        def patternSplit = pattern.split("${regEx}")
        for (int i in 0..<classNames.size()) {
            def classNameSplit = classNames[i].split("${regEx}")
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

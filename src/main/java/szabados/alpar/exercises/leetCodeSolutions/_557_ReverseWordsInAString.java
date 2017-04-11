package szabados.alpar.exercises.leetCodeSolutions;

import java.util.Arrays;
import java.util.stream.Collectors;

public class _557_ReverseWordsInAString {
    public String reverseWords(String s) {
        return Arrays.stream(s.split("\\s+"))
                     .map(StringBuilder::new)
                     .map(StringBuilder::reverse)
                     .collect(Collectors.joining(" "));
    }
}

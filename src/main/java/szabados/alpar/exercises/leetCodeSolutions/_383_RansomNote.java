package szabados.alpar.exercises.leetCodeSolutions;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _383_RansomNote {
    private static Map<Character, Long> letterFrequencies(String input) {
        return input.chars()
                    .mapToObj(i -> (char) i)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Long> bigString = letterFrequencies(magazine);
        Map<Character, Long> shortString = letterFrequencies(ransomNote);

        for (Map.Entry<Character, Long> entry : shortString.entrySet()) {
            if (bigString.containsKey(entry.getKey())) {
                if (bigString.get(entry.getKey()) <= entry.getValue()) return false;
            } else return false;
        }
        return true;
    }
}
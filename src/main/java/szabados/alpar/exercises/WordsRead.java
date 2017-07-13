package szabados.alpar.exercises;

import java.util.Arrays;

public class WordsRead {
    public static long wordsRead(long maxLength, String s) {
        return Arrays.stream(s.split("\\W+"))
                     .filter(w -> w.length() <= maxLength)
                     .count();
    }
}

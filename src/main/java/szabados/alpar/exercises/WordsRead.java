package szabados.alpar.exercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsRead {
    public static int wordsRead(int maxLength, String s) {
        Matcher matcher = Pattern.compile("[a-zA-Z]+").matcher(s);

        int count = 0;
        while (matcher.find()) {
            if (matcher.group().length() <= maxLength) count++;
        }

        return count;
    }
}

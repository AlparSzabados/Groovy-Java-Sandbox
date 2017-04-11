package szabados.alpar.exercises.leetCodeSolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a List of words, return the words that can be typed using letters
 * of alphabet on only one row's of American keyboard.
 */

public class _500_KeyboardRow {
    private static String[] keyboardLine = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

    public String[] findWords(String[] words) {
        List<String> validWords = new ArrayList<>();
        for (String word : words) {
            if (isOneLine(word, keyboardLine[0])) validWords.add(word);
            else if (isOneLine(word, keyboardLine[1])) validWords.add(word);
            else if (isOneLine(word, keyboardLine[2])) validWords.add(word);
        }
        return validWords.toArray(new String[validWords.size()]);
    }

    private boolean isOneLine(String word, String keyboardLine) {
        for (int j = 0; j < word.length(); j++) {
            if (!keyboardLine.contains(Character.toString(word.charAt(j)).toLowerCase())) {
                return false;
            }
        }
        return true;
    }
}

package szabados.alpar.exercises.leetCodeSolutions;

import java.util.Objects;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 *
 * Otherwise, we define that this word doesn't use capitals in a right way.
 */
public class _520_DetectCapital {
    public boolean detectCapitalUse(String word) {
        return Objects.equals(word, word.toUpperCase()) || Objects.equals(word.substring(1), word.substring(1).toLowerCase());
    }
}

package szabados.alpar.exercises;

import java.util.Arrays;

/**
 * Write a function that takes a string as input and returns the string reversed.
 */

public class StringReverse {
    public String reverseString(String s) {
        char[] result = s.toCharArray();
        for (int i = s.length() - 1, j = 0; i >= j; i--, j++) {
            char tmp = s.charAt(i);
            result[i] = s.charAt(j);
            result[j] = tmp;
        }

        return Arrays.toString(result);
    }
}

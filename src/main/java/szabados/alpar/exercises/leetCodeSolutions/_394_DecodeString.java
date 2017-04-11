package szabados.alpar.exercises.leetCodeSolutions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.util.Collections.nCopies;
import static jdk.nashorn.internal.objects.NativeArray.join;

/**
 * Given an encoded string, return it's decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 */
public class _394_DecodeString {
    static String decodeString(String s) {
        final Pattern p = Pattern.compile("(\\d+)\\[([a-z]+)\\]");
        final StringBuilder result = new StringBuilder(s);
        return decode(p, result);
    }

    private static String decode(Pattern p, StringBuilder result){
        Matcher m = p.matcher(result);
        if (!m.find()) return result.toString();
        return decode(p, result.replace(m.start(), m.end(), join("", nCopies(parseInt(m.group(1)), m.group(2)))));
    }
}
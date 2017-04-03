package szabados.alpar.exercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Given two strings representing two complex numbers.
 * Return a string representing their multiplication.
 * Note i2 = -1 according to the definition.
 */
public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        int[] pair1 = parseNumber(a);
        int[] pair2 = parseNumber(b);

        return ((pair1[0] * pair2[0]) - (pair1[1] * pair2[1])) + "+" + ((pair1[0] * pair2[1]) + (pair1[1] * pair2[0])) + "i";
    }

    private int[] parseNumber(String number) {
        Matcher m = Pattern.compile("([+-]?\\d+)\\+([+-]?\\d+)i").matcher(number);
        String num1 = "";
        String num2 = "";

        if (m.find()) {
            num1 = m.group(1);
            num2 = m.group(2);
        }

        return new int[]{Integer.parseInt(num1), Integer.parseInt(num2)};
    }
}

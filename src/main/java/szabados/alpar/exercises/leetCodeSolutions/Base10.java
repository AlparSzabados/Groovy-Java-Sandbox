package szabados.alpar.exercises.leetCodeSolutions;

import java.util.concurrent.ThreadLocalRandom;

public class Base10 {
    private static final int MIN_BASE = 2;
    private static final int MAX_BASE = 32;

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int expected = ThreadLocalRandom.current().nextInt();

            int base = randomBase();
            String source = Integer.toString(expected, base);

            assert toBase10(source, base) == expected : expected;
        }
    }

    private static int randomBase() {
        return ThreadLocalRandom.current().nextInt(MIN_BASE, MAX_BASE);
    }

    private static int toBase10(String num, int base) {
        if (num.startsWith("-")) {
            return -convertNumber(num.substring(1), base);
        } else {
            return convertNumber(num, base);
        }
    }

    private static int convertNumber(String num, int base) {
        int result = 0;
        for (char c : num.toUpperCase().toCharArray()) {
            result *= base;
            result += charToDigit(c);
        }
        return result;
    }

    private static int charToDigit(char c) throws NumberFormatException {
        if (c >= '0' && c <= '9') return c - '0';
        else if (c >= 'A' && c <= 'Z') return c - 'A' + 10;
        else throw new NumberFormatException("Not a valid character: '" + c + "'");
    }
}
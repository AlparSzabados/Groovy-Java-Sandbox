package szabados.alpar.exercises;

/* Write a program which takes input as a number and converts it into string format. */

public class NumToString {

    private static String onesString[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static String tensString[] = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static String main(int num) {
        int remainder, tens;

        String value = "";

        if (num < onesString.length + 1) {
            for (int i = 0; i <= onesString.length; i++) {
                if (num == i) {
                    value += onesString[i - 1];
                }
            }
        } else {
            remainder = num % 10;
            tens = (num - remainder) / 10;
            for (int i = 0; i <= tensString.length + 1; i++) {
                if (tens == i) {
                    value += tensString[i - 2];
                }
            }
            for (int i = 0; i <= onesString.length; i++) {
                if (remainder != 0) {
                    if (remainder == i) {
                        value += " " + onesString[i - 1];
                    }
                }
            }
        }
        return value;
    }
}





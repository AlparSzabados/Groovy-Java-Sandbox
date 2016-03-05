package szabados.alpar.exercises;

public class NumToString {

    public static String ones[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    public static String tens[] = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    public static String main(int num) {

        int rem, t;

        String value = "";

        if (num < 20) {
            for (int i = 0; i <= ones.length; i++) {
                if (num == i) {
                    value += ones[i - 1];
                }
            }
        } else {
            rem = num % 10;
            t = (num - rem) / 10;
            for (int i = 0; i <= tens.length + 1; i++) {
                if (t == i) {
                    value += tens[i - 2];
                }
            }
            for (int i = 0; i <= ones.length; i++) {
                if (rem != 0) {
                    if (rem == i) {
                        value += " " + ones[i - 1];
                    }
                }
            }
        }
        return value;
    }
}





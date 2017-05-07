package szabados.alpar.exercises;

import java.text.DecimalFormat;

public class ConvertToCurrency {
    public static String convertToDollars(String s) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        float value = Float.parseFloat(s);
        return "$" + decimalFormat.format(value);
    }
}
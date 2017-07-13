package szabados.alpar.exercises;

import java.util.ArrayList;
import java.util.List;

public class OrderUnique {
    public static String[] uniqueOrder(String s) {
        List<String> result = new ArrayList<>();
        result.add(String.valueOf(s.charAt(0)));

        char prev = s.charAt(0);
        for (char c : s.toCharArray()) {
            if (c != prev) {
                result.add(String.valueOf(c));
                prev = c;
            }
        }
        return result.toArray(new String[0]);
    }
}

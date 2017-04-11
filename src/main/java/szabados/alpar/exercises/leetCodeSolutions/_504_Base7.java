package szabados.alpar.exercises.leetCodeSolutions;

/**
 * Given an integer, return its base 7 string representation.
 */
public class _504_Base7 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        else {
            StringBuilder result = new StringBuilder();
            for (int abs = Math.abs(num); abs > 0; abs /= 7)
                result.append(abs % 7);
            if (num < 0)
                result.append("-");
            return result.reverse().toString();
        }
    }
}

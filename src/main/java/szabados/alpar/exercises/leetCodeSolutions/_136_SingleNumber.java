package szabados.alpar.exercises.leetCodeSolutions;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class _136_SingleNumber {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _136_SingleNumber().singleNumber(new int[]{2, 2, 10, 11, 3, 3})));
    }

    public int[] singleNumber(int[] nums) {
        Map<Integer, Long> duplicates = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return duplicates.entrySet().stream().filter(entry -> entry.getValue() == 1).mapToInt(Map.Entry::getKey).toArray();
    }
}

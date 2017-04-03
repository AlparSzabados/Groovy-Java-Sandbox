package szabados.alpar.exercises.leetCodeSolutions;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        final Map<Integer, Long> collect = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                     .entrySet().stream().filter(e -> e.getValue() == 1).mapToInt(Map.Entry::getKey).toArray();
    }
}

package szabados.alpar.exercises;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an array of integers with possible duplicates, randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
 *
 * int[] nums = new int[] {1,2,3,3,3}
 * Solution solution = new Solution(nums);
 *
 * pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * pick(1) should return 0. Since in the array only nums[0] is equal to 1.
*/

public class RandomPickIndex {
    private int[] nums;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        final Map<Integer, List<Integer>> listMap = IntStream.range(0, nums.length).boxed()
                                                             .collect(Collectors.groupingBy(i -> nums[i], Collectors.toList()));
        final List<Integer> integers = listMap.get(target);
        return integers.get(new Random().nextInt(integers.size()));
    }
}

package szabados.alpar.exercises.leetCodeSolutions;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class _001_TwoSum {
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; map.put(nums[i], i++)) {
            if (map.containsKey(target - nums[i])){
                return new int[] {map.get(target - nums[i]), i};
            }
        }
        return null;
    }
}

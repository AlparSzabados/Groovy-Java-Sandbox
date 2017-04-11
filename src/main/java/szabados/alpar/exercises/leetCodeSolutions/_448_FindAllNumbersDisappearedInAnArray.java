package szabados.alpar.exercises.leetCodeSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
public class _448_FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= nums.length; i++) {
            if (!numbers.contains(i)){
                result.add(i);
            }
        }

        return result;
    }
}

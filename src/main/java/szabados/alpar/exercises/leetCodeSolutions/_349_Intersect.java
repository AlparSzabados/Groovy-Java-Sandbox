package szabados.alpar.exercises.leetCodeSolutions;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class _349_Intersect {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet1 = asSet(nums1);
        Set<Integer> numSet2 = asSet(nums2);

        numSet1.retainAll(numSet2);
        return numSet1.stream().mapToInt(i -> i).toArray();
    }

    private Set<Integer> asSet(int[] nums) { return Arrays.stream(nums).boxed().collect(Collectors.toSet()); }
}

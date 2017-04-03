package szabados.alpar.exercises.leetCodeSolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 *
 * Given the below binary tree and sum = 22
 *
 *        5
 *       / \
 *      4   8
 *     /   / \
 *    11  13  4
 *   /  \    / \
 *  7    2  5   1
 *
 * return [[5,4,11,2], [5,8,4,5]]
 */

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        traverse(root, sum, new ArrayList<>(), results);
        return results;
    }

    private void traverse(TreeNode root, int sum, List<Integer> result, List<List<Integer>> results) {
        if (root != null) {
            result.add(root.val);
            if (root.left == root.right && sum == root.val) results.add(new ArrayList<>(result));
            else {
                traverse(root.left, sum - root.val, result, results);
                traverse(root.right, sum - root.val, result, results);
            }
            result.remove(result.size() - 1);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

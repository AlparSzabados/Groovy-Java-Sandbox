package szabados.alpar.exercises;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all
 * the values along the path equals the given sum.
 *
 * Given the below binary tree and sum = 22
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

public class PathSum1 {
    private boolean hasPathSum(TreeNode root, int sum) {
        if (root != null) {
            if (root.right == root.left && sum - root.val == 0) {
                return true;
            } else if (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val)) {
                return true;
            }
        }
        return false;
    }
}

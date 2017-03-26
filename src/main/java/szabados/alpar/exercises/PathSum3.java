package szabados.alpar.exercises;

/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards
 * (traveling only from parent nodes to child nodes).
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */

public class PathSum3 {
    private int pathSum(TreeNode root, int sum) {
        int count = 0;
        if (root != null) {
            count += traverse(root, sum);
            count += pathSum(root.left, sum);
            count += pathSum(root.right, sum);
        }
        return count;
    }

    private int traverse(TreeNode node, int target) {
        int count = 0;
        if (node != null) {
            if (target - node.val == 0) {
                count++;
            }
            count += traverse(node.left, target - node.val);
            count += traverse(node.right, target - node.val);
        }
        return count;
    }
}

package com.guof.tree.maximum_depth_of_a_binary_tree;

/**
 * ClassName: Solution
 * Package: com.feng.tree.maximum_depth_of_a_binary_tree
 * Description:
 *
 * @Author guof
 * @Create 2023/3/25 21:58
 * @Version 1.0
 */
class Solution {
    public int maxDepth(TreeNode root) {
        // 递归，左右深度相加
        if (root == null) {
            return 0;
        }

        if (root.right == null && root.left == null) {
            return 1;
        }

        int depth = 1;
        depth += Math.max(maxDepth(root.left), maxDepth(root.right));

        return depth;
    }
}
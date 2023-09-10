package com.feng.using_recursion_to_solve_problems.total_ath;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, 0, targetSum);
    }

    public boolean dfs(TreeNode root, int sum, int targetSum) {
        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum == targetSum;
        } else {
            boolean output = false;
            if (root.left != null) {
                output |= dfs(root.left, sum, targetSum);
            }
            if (root.right != null) {
                output |= dfs(root.right, sum, targetSum);
            }
            return output;
        }
    }
}
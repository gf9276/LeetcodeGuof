package com.feng.using_recursion_to_solve_problems.the_maximum_depth_of_a_binary_tree;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> output = new ArrayList<>();

    public boolean isSymmetric(TreeNode root) {
        // 序列化是个办法
        if (root == null) return true;

        return isSymmetric(root.left, root.right);

    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        //如果当前节点只有一个子节点或者有两个子节点，但两个子节点的值不相同，直接返回false
        if (left == null || right == null || left.val != right.val)
            return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

    }
}
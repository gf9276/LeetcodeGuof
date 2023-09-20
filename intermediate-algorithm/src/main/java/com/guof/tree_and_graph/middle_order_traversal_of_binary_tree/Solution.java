package com.guof.tree_and_graph.middle_order_traversal_of_binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Package: com.feng.tree_and_graph.middle_order_traversal_of_binary_tree
 * Description:
 *
 * @Author guof
 * @Create 2023/4/6 16:22
 * @Version 1.0
 */
class Solution {
    List<Integer> output = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return output;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        output.add(root.val);
        inorder(root.right);
    }
}

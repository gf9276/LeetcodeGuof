package com.feng.tree_and_graph.the_smallest_k_element_in_the_binary_search_tree;

/**
 * ClassName: Solution
 * Package: com.feng.tree_and_graph.the_smallest_k_element_in_the_binary_search_tree
 * Description:
 *
 * @Author guof
 * @Create 2023/4/7 20:23
 * @Version 1.0
 */
class Solution {
    int k = 0;
    int output = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrderTraversal(root);
        return output;
    }

    public void inOrderTraversal(TreeNode node) {
        if (node == null || k == 0) {
            return;
        }

        inOrderTraversal(node.left);

        k--;

        if (k == 0) {
            output = node.val;
            return;
        } // 有没有什么办法直接跳出所有循环

        inOrderTraversal(node.right);
    }
}
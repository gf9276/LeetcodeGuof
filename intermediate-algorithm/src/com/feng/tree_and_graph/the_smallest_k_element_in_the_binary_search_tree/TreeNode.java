package com.feng.tree_and_graph.the_smallest_k_element_in_the_binary_search_tree;

/**
 * ClassName: TreeNode
 * Package: com.feng.tree_and_graph.middle_order_traversal_of_binary_tree
 * Description:
 *
 * @Author guof
 * @Create 2023/4/6 16:23
 * @Version 1.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

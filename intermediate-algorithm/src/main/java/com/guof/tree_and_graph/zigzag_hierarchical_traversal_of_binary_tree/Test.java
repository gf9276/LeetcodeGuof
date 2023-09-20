package com.guof.tree_and_graph.zigzag_hierarchical_traversal_of_binary_tree;

/**
 * ClassName: Test
 * Package: com.feng.tree_and_graph.zigzag_hierarchical_traversal_of_binary_tree
 * Description:
 *
 * @Author guof
 * @Create 2023/4/6 18:18
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node = root;
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node = node.right;
        node.left = new TreeNode(15);
        node.right = new TreeNode(7);

        Solution solu = new Solution();
        solu.zigzagLevelOrder(root);
    }
}

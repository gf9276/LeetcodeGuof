package com.guof.upside_down_binary_tree;

/**
 * ClassName: Test
 * Package: com.feng.arrays_and_strings.letter_heterotopic_word_grouping
 * Description:
 *
 * @Author guof
 * @Create 2023/4/4 19:53
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode move = root;
        move.left = new TreeNode(2);
        move.right = new TreeNode(3);
        move = move.left;
        move.left = new TreeNode(4);
        move.right = new TreeNode(5);
        solution.upsideDownBinaryTree(root);
    }
}

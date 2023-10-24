package com.guof.del_nodes;

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
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4)));
        solution.delNodes(root, new int[]{2, 1});
    }
}

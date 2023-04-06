package com.feng.tree_and_graph.constructing_binary_tree_from_pre_order_and_middle_order_traversal_sequences;

/**
 * ClassName: Test
 * Package: com.feng.tree_and_graph.constructing_binary_tree_from_pre_order_and_middle_order_traversal_sequences
 * Description:
 *
 * @Author guof
 * @Create 2023/4/6 20:35
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Solution solu = new Solution();
        solu.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}

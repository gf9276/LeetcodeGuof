package com.guof.design_issues.serialization_and_deserialization_of_binary_tree;

/**
 * ClassName: Test
 * Package: com.feng.sort_and_search.color_classification
 * Description:
 *
 * @Author guof
 * @Create 2023/4/16 16:42
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode move = root;
        move.right = new TreeNode(2);
        move = move.right;
        move.left = new TreeNode(3);

        Codec solu = new Codec();
        String data = solu.serialize(root);
        TreeNode root2 = solu.deserialize(data);

        System.out.println("hehe");
    }

}

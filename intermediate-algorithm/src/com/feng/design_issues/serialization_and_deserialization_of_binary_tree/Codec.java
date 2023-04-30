package com.feng.design_issues.serialization_and_deserialization_of_binary_tree;


import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> value = new ArrayList<>();
        serPreOrder(root, value);
        return String.join(",", value);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] value = data.split(","); // 分割
        return deserPreOrder(value, new int[]{0});
    }

    public void serPreOrder(TreeNode root, List<String> value) {
        // 前序遍历，并将值存储到List里

        if (root == null) {
            value.add("n"); // null 也得加啊，不过因为是要转成string，所以我这里直接用"n"了
            return;
        }

        value.add(String.valueOf(root.val)); // 直接变string了
        serPreOrder(root.left, value);
        serPreOrder(root.right, value);
    }

    public TreeNode deserPreOrder(String[] value, int[] now_idx) {
        if (value.length - 1 < now_idx[0]) {
            return null;
        }
        if (value[now_idx[0]].equals("n")) {
            return null;
        }


        TreeNode root = new TreeNode(Integer.parseInt(value[now_idx[0]])); // 创建一个新的节点
        now_idx[0]++;
        root.left = deserPreOrder(value, now_idx);
        now_idx[0]++;
        root.right = deserPreOrder(value, now_idx);
        return root;
    }
}
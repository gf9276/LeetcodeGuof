package com.guof.summarize.serialization_and_deserialization_of_binary_trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode == null) {
                    stringBuilder.append("null").append(",");
                    continue;
                }
                stringBuilder.append(curNode.val).append(",");
                queue.add(curNode.left);
                queue.add(curNode.right);
            }
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        return String.valueOf(stringBuilder);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> stringQueue = new LinkedList<>(Arrays.asList(data.split(",")));
        String str = stringQueue.poll();
        assert str != null;
        if (str.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(str));
        queue.add(root);

        while (!stringQueue.isEmpty()) {
            TreeNode curNode = queue.poll();
            String curStr = stringQueue.poll();

            if (!curStr.equals("null")) {
                curNode.left = new TreeNode(Integer.parseInt(curStr));
                queue.add(curNode.left);
            }
            curStr = stringQueue.poll();

            if (!curStr.equals("null")) {
                curNode.right = new TreeNode(Integer.parseInt(curStr));
                queue.add(curNode.right);
            }
        }
        return root;
    }
}

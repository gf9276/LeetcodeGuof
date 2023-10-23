package com.guof.del_nodes;


import java.util.*;


class Solution {
    List<TreeNode> output = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        output = new ArrayList<>();
        Set<Integer> toDeleteSet = new HashSet<Integer>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        dfs(root, true, toDeleteSet);
        return output;
    }

    public TreeNode dfs(TreeNode root, boolean canAdd, Set<Integer> toDelete) {
        if (root == null) {
            return null;
        }

        boolean remove = toDelete.contains(root.val); // 当前点是否删除

        root.left = dfs(root.left, remove, toDelete); // 如果root被删除了，说明下个点有成为add的潜质
        root.right = dfs(root.right, remove, toDelete);

        if (remove) {
            return null;
        } else {
            if (canAdd) {
                output.add(root);
            }
            return root;
        }
    }
}
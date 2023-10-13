package com.guof.clone_tree;


class Solution {
    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }
        // 用Dfs吧，前序便利就行，头左右，
        Node cloneRoot = new Node(root.val);
        dfs(root, cloneRoot);
        return cloneRoot;
    }

    public void dfs(Node root, Node cloneRoot) {
        if (root == null) {
            // 到此为止了
            return;
        }

        for (Node rootChild : root.children) {
            // 一个子节点
            cloneRoot.children.add(new Node(rootChild.val)); // 直接搞一个就好了
            dfs(rootChild, cloneRoot.children.get(cloneRoot.children.size() - 1));
        }
    }
}

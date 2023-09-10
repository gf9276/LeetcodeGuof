package com.feng.summarize.fill_in_the_next_right_node_pointer_for_each_node;

class Solution {
    //    public Node connect(Node root) {
//        if (root == null) {
//            return null;
//        }
//
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Node curNode = queue.poll();
//                if (i < size - 1) {
//                    curNode.next = queue.peek();
//                }
//                if (curNode.left != null) {
//                    queue.add(curNode.left);
//                }
//                if (curNode.right != null) {
//                    queue.add(curNode.right);
//                }
//
//            }
//        }
//        return root;
//    }
    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node curr, Node next) {
        if (curr == null)
            return;
        curr.next = next;
        dfs(curr.left, curr.right);  // 左侧的指向右侧
        dfs(curr.right, curr.next == null ? null : curr.next.left);  // 右侧的指向上一层右侧的下面
    }
}
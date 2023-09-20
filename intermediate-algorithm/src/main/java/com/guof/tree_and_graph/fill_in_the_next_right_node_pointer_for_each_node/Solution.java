package com.guof.tree_and_graph.fill_in_the_next_right_node_pointer_for_each_node;

/**
 * ClassName: Solution
 * Package: com.feng.tree_and_graph.fill_in_the_next_right_node_pointer_for_each_node
 * Description:
 *
 * @Author guof
 * @Create 2023/4/7 19:48
 * @Version 1.0
 */
class Solution {
//    public Node connect(Node root) {
//        // 这题就很普通的BFS遍历啊
//
//        if (root == null) {
//            return null;
//        }
//
//        int now_nbr = 0;
//        int next_nbr = 0;
//
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        now_nbr++;
//        while (!queue.isEmpty()) {
//            Node node = queue.poll();
//            now_nbr--;
//            if (node.left != null) {
//                queue.add(node.left);
//                next_nbr++;
//            }
//            if (node.right != null) {
//                queue.add(node.right);
//                next_nbr++;
//            }
//
//            if (now_nbr == 0) {
//                now_nbr = next_nbr;
//                next_nbr = 0;
//                node.next = null;
//            } else {
//                node.next = queue.peek();
//            }
//
//        }
//        return root;
//    }

//    public Node connect(Node root) {
//        dfs(root, null);
//        return root;
//    }
//
//    private void dfs(Node curr, Node next) {
//        if (curr == null)
//            return;
//        curr.next = next;
//        dfs(curr.left, curr.right);  // 左侧的指向右侧
//        dfs(curr.right, curr.next == null ? null : curr.next.left);  // 右侧的指向上一层右侧的下面
//    }


    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    public void dfs(Node curr, Node next) {
        if (curr == null) {
            return;
        }
        curr.next = next;
        dfs(curr.left, curr.right);
        dfs(curr.right, next == null ? null : next.left);
    }
}

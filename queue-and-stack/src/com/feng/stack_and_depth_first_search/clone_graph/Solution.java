package com.feng.stack_and_depth_first_search.clone_graph;


import java.util.*;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        // dfs遍历整个图
        // 感觉还得用到map
        Map<Node, Node> nodeMap = new HashMap<>();
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();

        stack.add(node);

        while (!stack.isEmpty()) {
            Node nowNode = stack.pop();
            set.add(nowNode);
            nodeMap.put(nowNode, new Node(nowNode.val));
            if (nowNode.neighbors != null) {
                for (Node neighbor : nowNode.neighbors) {
                    if (set.contains(neighbor)) continue;
                    stack.add(neighbor);
                }
            }
        }

        for (Node nowNode : nodeMap.keySet()) {
            Node copyNode = nodeMap.get(nowNode);
            for (Node neighbor : nowNode.neighbors) {
                copyNode.neighbors.add(nodeMap.get(neighbor));
            }
        }

        return nodeMap.get(node);
    }
}
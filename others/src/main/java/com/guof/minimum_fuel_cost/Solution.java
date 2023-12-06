package com.guof.minimum_fuel_cost;


import java.util.*;

class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        // 个人认为，这个就是拓扑排序，反正就是由外到内
        // 应该有个前提，都能到达
        // 无环
        // 考虑到是双向的，入度至少为1

        long output = 0;

        // 用map吧，应该不容易超时（除了0之外，其他的其实只有两个，一个是来，一个是去）
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] road : roads) {
            if (!map.containsKey(road[0])) {
                map.put(road[0], new ArrayList<>());
            }
            if (!map.containsKey(road[1])) {
                map.put(road[1], new ArrayList<>());
            }
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }

        // 用来拓扑排序的
        Queue<Integer> queue = new LinkedList<>();
        for (int key : map.keySet()) {
            if (map.get(key).size() == 1 && key != 0) {
                // 入度为1，且不在罗马(笑
                queue.add(key);
            }
        }

        // 记录人数
        int[] personCnt = new int[roads.length + 1]; // roads.length 是 n-1
        Arrays.fill(personCnt, 1);
        personCnt[0] = 0; // 中心没人噢

        while (!queue.isEmpty()) {
            int curCity = queue.poll();
            int nextCity = map.get(curCity).get(0); // 只有一个城市，才会被我加入queue
            output += personCnt[curCity] / seats;
            if (personCnt[curCity] % seats != 0) {
                output += 1; // 多一辆车
            }
            personCnt[nextCity] += personCnt[curCity];
            personCnt[curCity] = 0;

            map.get(nextCity).remove((Object)curCity); // 断掉这个联系吧
            if (map.get(nextCity).size() == 1 && nextCity != 0) {
                queue.add(nextCity);
            }
            map.remove(curCity);
        }
        return output;
    }
}
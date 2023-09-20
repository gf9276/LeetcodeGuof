package com.guof.other.least_interval;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Package: com.feng.other.least_interval
 * Description:
 *
 * @Author guof
 * @Create 2023/5/11 16:30
 * @Version 1.0
 */
class Solution {
//    public int leastInterval(char[] tasks, int n) {
//        Map<Character, Integer> map1 = new HashMap<>(); // 记录任务个数
//        Map<Character, Integer> map2; // 记录任务是否处于冷却
//
//        // 统计任务
//        for (char task : tasks) {
//            if (map1.containsKey(task)) {
//                map1.replace(task, map1.get(task) + 1); // 数量+1
//            } else {
//                map1.put(task, 1); // 重新生成
//            }
//        }
//
//        map2 = new HashMap<>(map1);
//        for (char key : map2.keySet()) {
//            map2.replace(key, 0); // 冷却时间都变成0
//        }
//
//        int time = 0; // 统计时间
//        // 开始分配
//        while (true) {
//            // 按照任务数量排序，当然是先干事情多的了
//            Map<Character, Integer> sorted_map1 = new LinkedHashMap<>();
//            map1.entrySet()
//                    .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                    .forEachOrdered(x -> sorted_map1.put(x.getKey(), x.getValue()));
//
//
//            List<Integer> tmp = new ArrayList<>(sorted_map1.values());
//            if (tmp.get(0) <= 0) {
//                // 完事了
//                break;
//            }
//
//
//            for (Character key : sorted_map1.keySet()) // key应该是按照顺序的吧
//            {
//                if (map2.get(key) != 0 || map1.get(key) <= 0) {
//                    // 如果还在cd或者事情做完了，直接跳过
//                    continue;
//                }
//                // 终于找到不忙的了
//                map2.replace(key, n + 1); // 直接进入cd
//                map1.replace(key, map1.get(key) - 1); // 控制数量减一
//                break;
//            }
//
//            time++;
//            for (Character key : map2.keySet()) {
//                if (map2.get(key) > 0) {
//                    // 如果在cd，cd减一
//                    map2.replace(key, map2.get(key) - 1);
//                }
//            }
//        }
//        return time;
//    }

    public int leastInterval(char[] tasks, int n) {
        int[][] record = new int[26][2]; // 26个字母，每个字母对应两列--任务数量和cd
        int time = 0; // 统计时间
        // 统计任务个数
        for (char task : tasks) {
            record[task - 'A'][0]++;
        }


        while (true) {
            Arrays.sort(record, (o1, o2) -> o2[0] - o1[0]);

            if (record[0][0] == 0) {
                // 没任务直接退出
                break;
            }

            for (int i = 0; i < record.length; i++) {
                if (record[i][1] > 0 || record[i][0] <= 0) {
                    // 如果在cd 或者 任务数量为0，直接跳过
                    continue;
                }
                // 终于找到合适的任务了，进cd，并且任务书减一
                record[i][1] = n + 1;
                record[i][0]--;
                break;
            }
            time++;
            for (int i = 0; i < record.length; i++) {
                record[i][1]--; // cd 全部都减一
            }

        }
        return time;
    }
}
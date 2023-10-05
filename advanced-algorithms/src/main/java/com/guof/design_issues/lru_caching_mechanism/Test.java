package com.guof.design_issues.lru_caching_mechanism;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ClassName: Test
 * Package: com.feng.dynamic_programming.climb_stairs
 * Description:
 *
 * @Author guof
 * @Create 2023/3/30 20:14
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("hehe", 0);
        map.put("haha", 1);
        map.put("qqqq", 2);
        map.put("wwww", 3);
        map.put("hehe", 4);

        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }


    }
}

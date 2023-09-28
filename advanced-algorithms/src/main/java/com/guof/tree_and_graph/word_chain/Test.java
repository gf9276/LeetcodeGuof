package com.guof.tree_and_graph.word_chain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Solution solu = new Solution();
        List<String> list = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        solu.ladderLength("hit", "cog", list);
    }
}

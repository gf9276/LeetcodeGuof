package com.guof.backtracking_algorithm.word_search2;


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
        Solution solution = new Solution();
        char[][] input = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] input2 = {"oath","pea","eat","rain"};
        solution.findWords(input, input2);
    }
}
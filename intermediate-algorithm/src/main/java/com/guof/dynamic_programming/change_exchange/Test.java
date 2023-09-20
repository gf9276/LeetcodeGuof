package com.guof.dynamic_programming.change_exchange;

/**
 * ClassName: Test
 * Package: com.feng.sort_and_search.the_kth_largest_element_in_the_array
 * Description:
 *
 * @Author guof
 * @Create 2023/4/23 17:42
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Solution solu = new Solution();
        int output = solu.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(output);
    }
}


package com.guof.linear_dp.double_string_problem_string_matching_series.wildcard_maching;

/**
 * ClassName: Test
 * Package: com.feng.arrays_and_strings.letter_heterotopic_word_grouping
 * Description:
 *
 * @Author guof
 * @Create 2023/4/4 19:53
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isMatch("abcabczzzde"
                , "*abc???de*");
    }
}
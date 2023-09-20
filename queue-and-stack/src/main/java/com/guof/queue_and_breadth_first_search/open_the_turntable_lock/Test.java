package com.guof.queue_and_breadth_first_search.open_the_turntable_lock;

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
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        System.out.println(solution.openLock(deadends, "0202"));


    }
}

package com.guof.count_intervals;

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
        CountIntervals countIntervals = new CountIntervals();
        countIntervals.count();
        countIntervals.add(33,49);
        countIntervals.add(43,47);
        countIntervals.count();
        countIntervals.count();
        countIntervals.add(37,37);
    }
}

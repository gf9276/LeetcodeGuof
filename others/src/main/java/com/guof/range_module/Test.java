package com.guof.range_module;

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
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(10, 180);
        rangeModule.addRange(150, 200);
        rangeModule.addRange(250, 500);
        rangeModule.queryRange(50, 100);
//        rangeModule.addRange(1, 3);
//        rangeModule.queryRange(2, 3);
//        rangeModule.addRange(4, 8);
//        rangeModule.queryRange(2, 3);
//        rangeModule.removeRange(4, 9);
        System.out.println();
    }
}

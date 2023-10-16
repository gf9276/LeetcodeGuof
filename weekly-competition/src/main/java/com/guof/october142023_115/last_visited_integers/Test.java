package com.guof.october142023_115.last_visited_integers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<String> words = new ArrayList<>(Arrays.asList(new String[]{"1", "prev", "2", "prev", "prev"}));
        System.out.println(solution.lastVisitedIntegers(words));
    }
}

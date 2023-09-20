package com.guof.mathematics.fizz_buzz;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Soludion
 * Package: com.feng.mathematics.fizz_uzz
 * Description:
 *
 * @Author guof
 * @Create 2023/3/30 20:50
 * @Version 1.0
 */
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<String>();

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                answer.add("FizzBuzz");
            } else if (i % 3 == 0) {
                answer.add("Fizz");
            } else if (i % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add(String.valueOf(i));
            }
        }
        return answer;
    }
}

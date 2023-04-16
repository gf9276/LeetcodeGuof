package com.feng.backtracking_algorithm.word_search;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Test
 * Package: com.feng.backtracking_algorithm.word_search
 * Description:
 *
 * @Author guof
 * @Create 2023/4/16 15:55
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        List<String> tmpList = new ArrayList<>();
        tmpList.add("a");
        tmpList.add("b");
        String nowString = String.join("", tmpList);
        System.out.println(nowString.equals("ab"));
        System.out.println(nowString.substring(0, 2));
    }
}



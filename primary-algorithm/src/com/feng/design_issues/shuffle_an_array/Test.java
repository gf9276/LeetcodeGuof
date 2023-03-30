package com.feng.design_issues.shuffle_an_array;


import java.util.Arrays;

/**
 * ClassName: Test
 * Package: com.feng.design_issues.shuffle_an_array
 * Description:
 *
 * @Author guof
 * @Create 2023/3/30 20:16
 * @Version 1.0
 */
public class Test {


    public static void main(String[] args) {

        Solution solu = new Solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});

        System.out.println(Arrays.toString(solu.shuffle()));

    }


}

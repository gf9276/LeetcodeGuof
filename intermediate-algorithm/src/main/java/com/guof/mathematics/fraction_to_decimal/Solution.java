package com.guof.mathematics.fraction_to_decimal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ClassName: Solution
 * Package: com.feng.mathematics.fraction_to_decimal
 * Description:
 *
 * @Author guof
 * @Create 2023/5/4 21:03
 * @Version 1.0
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == Integer.MIN_VALUE && denominator == -1) {
            return String.valueOf(2147483648L);
        }
        if (numerator == Integer.MIN_VALUE && denominator == 1) {
            return String.valueOf(-2147483648L);
        }
        if (numerator == 0) {
            return "0";
        }
        if (numerator == -1 && denominator == Integer.MIN_VALUE) {
            double value = -1.0 / Integer.MIN_VALUE;
            BigDecimal db = new BigDecimal(value);
            return db.toPlainString();
        }


        boolean flag = ((numerator > 0) ^ (denominator > 0)); // false: 同号，即正数；true: 异号，即负数
        if (numerator > 0) numerator = -numerator; // 变成正数
        if (denominator > 0) denominator = -denominator; // 变成正数

        StringBuilder output = new StringBuilder(); // 可变长度字符串
        if (flag) {
            output.insert(0, "-");
        }

        int intValue = numerator / denominator; // 整数部分
        output.insert(output.length(), intValue); // 插入字符串


        int curNumerator = numerator % denominator; // 剩下的分子
        if (curNumerator == 0) {
            // 说明有小数
            return output.toString();
        }
        output.insert(output.length(), ".");

        // 两者同时相等，说明重复了
        List<String> quotient = new ArrayList<>(); // 商
        List<String> remainder = new ArrayList<>(); //余数

        int repeatIdx = -1;

        while (curNumerator != 0) {
            curNumerator *= 10;
            intValue = curNumerator / denominator; // 获取整数位置，肯定小于10
            curNumerator = curNumerator % denominator;
            if (quotient.size() > 0) {
                for (int i = 0; i < quotient.size(); i++) {
                    if (Objects.equals(quotient.get(i), String.valueOf(intValue))) {
                        if (Objects.equals(remainder.get(i), String.valueOf(curNumerator))) {
                            // 重复了
                            repeatIdx = i;
                            curNumerator = 0;// 让他退出而已
                            break;
                        }
                    }
                }
            }
            quotient.add(String.valueOf(intValue));
            remainder.add(String.valueOf(curNumerator));
        }
        if (repeatIdx == -1) {
            for (String str : quotient) {
                output.insert(output.length(), str);
            }
        } else {
            for (int i = 0; i < repeatIdx; i++) {
                output.insert(output.length(), quotient.get(i));
            }
            output.insert(output.length(), "(");
            for (int i = repeatIdx; i < quotient.size() - 1; i++) {
                output.insert(output.length(), quotient.get(i));
            }
            output.insert(output.length(), ")");
        }

        return output.toString();
    }
}
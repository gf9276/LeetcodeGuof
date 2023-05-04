package com.feng.mathematics.excel_table_column_nbr;

/**
 * ClassName: Solution
 * Package: com.feng.mathematics.excel_table_column_nbr
 * Description:
 *
 * @Author guof
 * @Create 2023/5/4 19:42
 * @Version 1.0
 */
class Solution {
    public int titleToNumber(String columnTitle) {

        int output = 0;
        char[] chars = columnTitle.toCharArray();

        for (char c : chars) {
            output *= 26;
            output += c - 'A' + 1;
        }

        return output;
    }
}
package com.feng.backtracking_algorithm.bracket_generating;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Package: com.feng.backtracking_algorithm.bracket_generating
 * Description:
 *
 * @Author guof
 * @Create 2023/4/11 23:25
 * @Version 1.0
 */
//class Solution {
//    public List<String> generateParenthesis(int n) {
//        List<String> res = new ArrayList<>();
//        preOrder(res, n, n, "");
//        return res;
//    }
//
//    public static void preOrder(List<String> res, int restLeftNbr, int restRightNbr, String curStr) {
//        // 刚好
//        if (restLeftNbr == 0 && restRightNbr == 0) {
//            res.add(curStr);
//            return;
//        }
//
//        // 左括号余留数量不能小于0
//        if (restLeftNbr < 0) {
//            return;
//        }
//        // 右括号剩余数量必须大于等于左括号
//        if (restRightNbr < restLeftNbr) {
//            return;
//        }
//
//        preOrder(res, restLeftNbr - 1, restRightNbr, curStr + '(');
//        preOrder(res, restLeftNbr, restRightNbr - 1, curStr + ')');
//
//    }
//
//}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        dfs(output, n, n, new ArrayList<>());
        return output;
    }

    public void dfs(List<String> output, int leftNbr, int rightNbr, List<Character> curChars) {
        if (leftNbr == 0 && rightNbr == 0) {
            StringBuilder sb = new StringBuilder();
            for (Character c : curChars) {
                sb.append(c);
            }
            output.add(sb.toString());
            return;
        }

        if (rightNbr < leftNbr) {
            return;
        }
        if (leftNbr < 0) {
            return;
        }

        curChars.add('(');
        dfs(output, leftNbr - 1, rightNbr, curChars);
        curChars.remove(curChars.size() - 1);
        curChars.add(')');
        dfs(output, leftNbr, rightNbr - 1, curChars);
        curChars.remove(curChars.size() - 1);
    }
}
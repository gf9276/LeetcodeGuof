package com.guof.string.implement_str_str;

/**
 * ClassName: Solution
 * Package: com.feng.string.implement_str_str
 * Description: 使用KMP算法，先要获取前缀表，前缀表如何获取
 * 好像并没有很快。。。
 *
 * @Author guof
 * @Create 2023/3/24 16:03
 * @Version 1.0
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            // 长度不对直接退出，提速
            return -1;
        }

        int[] next = getNext(needle);

        int idx = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                // 第一个对上了
                int j = 0;
                for (; j < needle.length(); j++) {
                    if (i + j >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j)) {
                        // 匹配失败
                        i = i - 1 + j - next[j];
                        break;
                    }
                }
                if (j == needle.length()) {
                    // 没有中途退出
                    idx = i;
                    break;
                }
            }
        }
        return idx;
    }

    private int[] getNext(String p) {
        int length = p.length();
        int preIndex = 0;// 前一个位置的下标
        int count = -1;//公共前缀的长度
        int[] next = new int[length];
        next[0] = -1;
        while (preIndex < length - 1) {
            if (count == -1 || p.charAt(preIndex) == p.charAt(count)) {
                preIndex++;
                count++;
                // preIndex执行加1就变成当前位置的下标了
                next[preIndex] = count;
            } else {
                count = next[count];
            }
        }
        return next;
    }

}


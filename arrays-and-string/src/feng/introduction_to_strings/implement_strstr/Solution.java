package feng.introduction_to_strings.implement_strstr;

/**
 * ClassName: Solution
 * Package: com.feng.applying_basic_algorithmic_ideas.merge
 * Description: 中心回文，简单粗暴~
 *
 * @Author guof
 * @Create 2023/5/15 21:32
 * @Version 1.0
 */
class Solution {
    public int strStr(String haystack, String needle) {
        char[] T = needle.toCharArray();
        char[] S = haystack.toCharArray();

        //首先要构造next[]数组
        int jj = 0, k = -1;
        int[] next = new int[needle.length() + 1];
        next[jj] = k;
        while (jj < needle.length()) {
            if (k == -1 || T[jj] == T[k]) {
                jj++;
                k++;
                next[jj] = k;
            } else k = next[k];
        }

        //然后利用next数组就可使用KMP算法啦
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || S[i] == T[j]) {
                i++;         //继续对下一个字符比较
                j++;         //模式串向右滑动
            } else j = next[j];
        }
        if (j == needle.length()) return (i - j);    //匹配成功返回下标
        else return -1;                 //匹配失败返回-1

    }
}

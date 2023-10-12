package com.guof.emotionally_rich_text;


class Solution {
    public int expressiveWords(String s, String[] words) {
        int output = 0;
        char[] cs = s.toCharArray();

        for (String word : words) {
            char[] cWord = word.toCharArray();
            int sp = 0;
            int wp = 0;
            output++; // 姑且当他是，不是的话，后面我会减掉
            boolean right = true;
            while (sp < cs.length && wp < cWord.length) {
                int spNbr = 1;
                int wpNbr = 1;
                if (cs[sp] != cWord[wp]) {
                    // 字母都不一样了，搞毛
                    right = false;
                    break;
                }
                while (sp < cs.length - 1 && cs[sp] == cs[sp + 1]) {
                    // 统计相同字母的个数，定位到最后一个相同字母
                    sp++;
                    spNbr++;
                }
                while (wp < cWord.length - 1 && cWord[wp] == cWord[wp + 1]) {
                    // 统计相同字母的个数，定位到最后一个相同字母
                    wp++;
                    wpNbr++;
                }
                if (!(spNbr == wpNbr || (spNbr > wpNbr && spNbr >= 3))) {
                    right = false;
                    break;
                }
                sp++;
                wp++;
            }
            if (sp < cs.length || wp < cWord.length || !right) {
                output--;
            }
        }
        return output;
    }
}
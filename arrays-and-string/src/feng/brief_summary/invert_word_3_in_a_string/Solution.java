package feng.brief_summary.invert_word_3_in_a_string;

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
    public String reverseWords(String s) {

        String[] s_arrays = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String s_array : s_arrays) {
            sb.append(new StringBuilder(s_array).reverse().toString()).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();

    }
}
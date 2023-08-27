package feng.introduction_to_strings.implement_strstr;

/**
 * ClassName: Test
 * Package: com.feng.applying_basic_algorithmic_ideas.merge
 * Description:
 *
 * @Author guof
 * @Create 2023/5/15 22:15
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.strStr("aabaaabaaac", "aabaaac");
        System.out.println(i);
    }
}

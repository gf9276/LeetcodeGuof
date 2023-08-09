package feng.diagonal_traversal;

import java.util.Arrays;

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
        int[][] mat = new int[1][1];
        mat[0] = new int[]{1};
//        mat[1] = new int[]{4, 5, 6};
//        mat[2] = new int[]{7, 8, 9};
        System.out.println(Arrays.toString(solution.findDiagonalOrder(mat)));
    }
}

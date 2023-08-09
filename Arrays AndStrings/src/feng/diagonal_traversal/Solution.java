package feng.diagonal_traversal;

/**
 * ClassName: Solution
 * Package: com.feng.applying_basic_algorithmic_ideas.merge
 * Description:
 *
 * @Author guof
 * @Create 2023/5/15 21:32
 * @Version 1.0
 */
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0) {
            return new int[0];
        }

        int x = 0;
        int y = 0;
        int idx = 0;
        int[] output = new int[mat.length * mat[0].length];
        output[mat.length * mat[0].length - 1] = mat[mat.length - 1][mat[0].length - 1];

        while (!(x == mat.length - 1 && y == mat[0].length - 1)) {
            // 向上
            for (; x >= 0 && y <= mat[0].length - 1; x--, y++) {
                output[idx++] = mat[x][y];
            }
            x++;
            y--;
            if (y < mat[0].length - 1) y++;
            else x++;
            if ((x == mat.length - 1 && y == mat[0].length - 1)) break;
            // 向下
            for (; y >= 0 && x <= mat.length - 1; y--, x++) {
                output[idx++] = mat[x][y];
            }
            y++;
            x--;
            if (x < mat.length - 1) x++;
            else y++;
            if ((x == mat.length - 1 && y == mat[0].length - 1)) break;
        }
        return output;
    }
}
package feng.rotation_matrix;


class Solution {
    public void rotate(int[][] matrix) {
        // 先沿对脚线对折，然后水平翻转

        // 对折
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < (1 + matrix[i].length) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = tmp;
            }
        }
    }
}
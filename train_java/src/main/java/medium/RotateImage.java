package medium;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/2
 * @time : 10:58
 */
public class RotateImage {

    public void rotate(int[][] matrix) {

        // 先沿对角线翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 再水平翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = (matrix[i].length - 1) >> 1; j >= 0; j--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = temp;
            }
        }
    }

}

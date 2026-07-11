package templates;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description : 矩阵旋转模板
 * @date : 2026/7/11
 * @time : 18:19
 */
public class MatrixRotate {

    public void rotate(int[][] matrix) {
        // 先沿对角线旋转180°
        int raw = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < column; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 再反转每一横行
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    // 反转一维数组
    void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (1 < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}

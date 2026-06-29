package medium;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/6/29
 * @time : 12:19
 */
public class MatrixBlockSum {

    public int[][] matrixBlockSum(int[][] mat, int k) {

        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0][0];
        }

        int m = mat.length;
        int n = mat[0].length;

        int[][] preSum = new int[m + 1][n + 1];

        // 构筑前缀和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        // 使用前缀和构筑新矩阵
        int[][] res = new int[m][n];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                // 如果超出矩阵 则不参与计算
                int rowStart = Math.max(0, i - k);
                int lineStart = Math.max(0, j - k);
                int rowEnd = Math.min(m - 1, i + k);
                int lineEnd = Math.min(n - 1, j + k);
                // 最大的正方形减去四个角
                res[i][j] = preSum[rowEnd + 1][lineEnd + 1] - preSum[rowStart][lineEnd + 1] - preSum[rowEnd + 1][lineStart] + preSum[rowStart][lineStart];
            }
        }

        return res;
    }

}

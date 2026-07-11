package templates;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description : 前缀和模板
 * @date : 2026/7/11
 * @time : 17:36
 */
public class PreSum {

    public int[] preSum;

    public int[][] preSumMatrix;

    public int[] oneDimension(int[] nums) {
        int length = nums.length;
        preSum = new int[length + 1];
        preSum[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        return preSum;
    }

    // 两个索引间的累加和
    public int oneDimensionSumRange(int start, int end) {
        return preSum[end + 1] - preSum[start];
    }

    public int[][] twoDimension(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) return preSumMatrix;

        preSumMatrix = new int[m + 1][n + 1];

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                preSumMatrix[i][j] = preSumMatrix[i - 1][j] + preSumMatrix[i][j - 1] + matrix[i - 1][j - 1] - preSumMatrix[i - 1][j - 1];
            }
        }

        return preSumMatrix;
    }

    // 两个坐标间的累加和
    public int twoDimensionSumRange(int x1, int y1, int x2, int y2) {
        return preSumMatrix[x2+1][y2+1] - preSumMatrix[x1][y2+1] - preSumMatrix[x2+1][y1] + preSumMatrix[x1][y1];
    }

}

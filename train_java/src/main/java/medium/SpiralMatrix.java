package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/2
 * @time : 11:54
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        // 定好四个边界 右->下->左->上
        int rightLimit = n - 1;
        int leftLimit = 0;
        int downLimit = m - 1;
        int upLimit = 0;

        // 循环
        while (leftLimit <= rightLimit && upLimit <= downLimit) {
            // 从左往右 行固定
            for (int i = leftLimit; i <= rightLimit; i++) {
                res.add(matrix[upLimit][i]);
            }
            upLimit++;

            // 从上往下 列固定
            for (int i = upLimit; i <= downLimit; i++) {
                res.add(matrix[i][rightLimit]);
            }
            rightLimit--;

            // 从右往左 行固定
            if (upLimit <= downLimit) {
                for (int i = rightLimit; i >= leftLimit; i--) {
                    res.add(matrix[downLimit][i]);
                }
                downLimit--;
            }

            // 从下往上 列固定
            if (leftLimit <= rightLimit) {
                for (int i = downLimit; i >= upLimit; i--) {
                    res.add(matrix[i][leftLimit]);
                }
                leftLimit++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] test = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] test2 = {{1, 2, 3, 4}, {5, 6, 7, 8},{9,10,11,12}};
        SpiralMatrix sm = new SpiralMatrix();
        System.out.println(sm.spiralOrder(test2));
    }

}

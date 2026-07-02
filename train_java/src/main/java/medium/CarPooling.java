package medium;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/2
 * @time : 10:10
 */
public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1000];

        // 构建差分数组（每个站之间的乘客的人数差）
        for (int i = 0; i < trips.length; i++) {
            int val = trips[i][0];
            int startIndex = trips[i][1];
            int endIndex = trips[i][2];
            diff[startIndex] += val;
            if (endIndex + 1 < 1000) {
                diff[endIndex] -= val;
            }
        }

        // 构建原数组（每个站车上的对应乘客数）
        int[] original = new int[1000];
        original[0] = diff[0];
        if (original[0] > capacity) {
            return false;
        }

        // 如果原数组存在 大于 capacity 的值，则返回false
        for (int i = 1; i < diff.length; i++) {
            original[i] = original[i - 1] + diff[i];
            if (original[i] > capacity) {
                return false;
            }
        }

        return true;
    }

}

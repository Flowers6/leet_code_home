package medium;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/1
 * @time : 19:42
 */
public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 构建一个初始差分数组
        int[] diff = new int[n];

        // // 循环bookings的行，每一行对差分数组做 int[i].length - 1 次 增值
        for (int i = 0; i < bookings.length; i++) {
            // 每一行的值都相同 为 bookings[row][length - 1]
            int rowVal = bookings[i][2];
            // 行 的起始索引
            int startRowIndex = bookings[i][0] - 1;
            diff[startRowIndex] += rowVal;
            // 行 的结束索引
            int endRowIndex = bookings[i][1] - 1;
            if (endRowIndex + 1 < n) {
                diff[endRowIndex + 1] -= rowVal;
            }
        }

        // 使用差分数组返回结果
        int[] res = new int[n];
        res[0] = diff[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + diff[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] test = {{1,2,10},{2,3,20},{2,5,25}};
        CorporateFlightBookings cfb = new CorporateFlightBookings();
        int[] res = cfb.corpFlightBookings(test, 5);
        for (int i : res) {
            System.out.println(i);
        }
    }
}

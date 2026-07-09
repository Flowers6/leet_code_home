package medium;

import java.util.*;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/9
 * @time : 15:21
 */
public class CarFleet {

    Deque<Double> timeStack = new ArrayDeque<>();

    public int carFleet(int target, int[] position, int[] speed) {
        // 车队数量默认 0
        int res = 0;
        List<int[]> timeList = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            int[] time = new int[] {position[i], speed[i]};
            timeList.add(time);
        }
        timeList.sort((a, b) -> b[0] - a[0]);

        for (int[] time : timeList) {
            double spendTime = (double) (target - time[0]) / time[1];
            if (!timeStack.isEmpty() && timeStack.peekLast() >= spendTime) {
                continue;
            }
            timeStack.addLast(spendTime);
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        CarFleet carFleet = new CarFleet();
        System.out.println(carFleet.carFleet(10, new int[]{6, 8}, new int[]{3, 2}));
    }

}

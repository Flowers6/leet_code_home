package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/11
 * @time : 11:30
 */
public class MinimumOperationsToReduceXToZero {

    public int minOperations(int[] nums, int x) {
        // 先对nums进行求和 窗口中索引对应值的和
        int sumInWin = 0;
        for (int num : nums) {
            sumInWin += num;
        }
        sumInWin -= x;

        if (sumInWin < 0) {
            return -1;
        }

        Set<Integer> window = new HashSet<>();
        int currentSum = 0;
        int res = Integer.MAX_VALUE;

        int left = 0, right = 0;
        while (right < nums.length) {
            int rightVal = nums[right];
            // 增大窗口
            window.add(right);
            right++;
            currentSum += rightVal;

            // 判断左侧窗口是否要收缩
            while (currentSum > sumInWin) {
                // leftVal 是将移出窗口的字符
                int leftVal = nums[left];
                window.remove(left);
                // 缩小窗口
                left++;
                currentSum -= leftVal;
            }

            if (sumInWin == currentSum) {
                res = Math.min(res, nums.length - window.size());
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        MinimumOperationsToReduceXToZero obj = new MinimumOperationsToReduceXToZero();
        System.out.println(obj.minOperations(nums, 5));
    }

}

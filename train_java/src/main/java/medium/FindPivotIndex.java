package medium;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/6/29
 * @time : 14:20
 */
public class FindPivotIndex {

    /**
     * 给你一个整数数组 nums ，请计算数组的 中心下标 。
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
     */
    public int pivotIndex(int[] nums) {

        // 计算前缀和
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        // 遍历前缀和
        int pivotIndex = -1;
        for (int i = 1; i < preSum.length; i++) {
            if (preSum[i - 1] == preSum[preSum.length - 1] - preSum[i]) {
                pivotIndex = i - 1;
                break;
            }
        }

        return pivotIndex;
    }

}

package medium;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/11
 * @time : 12:53
 */
public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        long window = 1;

        while (rightIndex < nums.length) {
            int currentVal = nums[rightIndex];
            // 窗口中存放 元素的乘积
            window *= currentVal;

            while (leftIndex <= rightIndex && window >= k) {
                // 当 乘积 >= k 时 窗口后移，并重新计数
                window /= nums[leftIndex];
                leftIndex++;
            }

            res += rightIndex - leftIndex + 1;
            rightIndex++;
        }

        return res;
    }

}

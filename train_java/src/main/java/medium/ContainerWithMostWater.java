package medium;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/6/27
 * @time : 11:51
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
//        int[] nums1 = {1,8,6,2,5,4,8,3,7};
        int[] nums2 = {1,2,3,1000,9};
//        System.out.println(func1(nums1));
        System.out.println(func1(nums2));
    }

    private static int func1(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int maxArea = 0;
        while (start < end) {
            maxArea = Math.max(maxArea, Math.min(nums[start], nums[end]) * (end - start));
            // 如果 start 高度低于 end 则 start 后移
            if (nums[start] < nums[end]) {
                start++;
            } else {
                // 如果 start 高度不低于 end 则 end 前移
                end--;
            }
        }
        return maxArea;
    }

}

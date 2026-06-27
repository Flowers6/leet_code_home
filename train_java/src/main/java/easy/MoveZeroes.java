package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/6/27
 * @time : 10:38
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums1 = {0,1,0,3,12};
        int[] nums2 = {0};
        int[] nums3 = {4,2,4,0,0,3,0,5,1,0};
        System.out.println(Arrays.toString(func1(nums1)));
        System.out.println(Arrays.toString(func1(nums2)));
        System.out.println(Arrays.toString(func1(nums3)));
    }

    private static int[] func1(int[] nums) {
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }

        while (slow < nums.length) {
            nums[slow++] = 0;
        }
        return nums;
    }

}

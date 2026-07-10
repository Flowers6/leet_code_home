package medium;

import java.util.Arrays;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/10
 * @time : 18:13
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int currentPosition = 0;
        while (currentPosition <= right) {
            if (nums[currentPosition] == 0) {
                int temp = nums[left];
                nums[left++] = nums[currentPosition];
                nums[currentPosition++] = temp;
            } else if (nums[currentPosition] == 2) {
                int temp = nums[right];
                nums[right--] = nums[currentPosition];
                nums[currentPosition] = temp;
            } else {
                currentPosition++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}

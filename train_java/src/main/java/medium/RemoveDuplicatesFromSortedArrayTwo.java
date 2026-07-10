package medium;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/10
 * @time : 16:52
 */
public class RemoveDuplicatesFromSortedArrayTwo {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1 || nums.length == 2) {
            return nums.length;
        }

        int slow = 0;
        int fast = 1;
        int repeatCount = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
                repeatCount = 0;
            } else if (repeatCount < 1) {
                slow++;
                nums[slow] = nums[fast];
                repeatCount++;
            }

            fast++;
        }

        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        RemoveDuplicatesFromSortedArrayTwo obj = new RemoveDuplicatesFromSortedArrayTwo();
        System.out.println(obj.removeDuplicates(nums));
    }

}

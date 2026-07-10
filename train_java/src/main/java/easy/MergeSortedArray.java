package easy;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/10
 * @time : 19:05
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int nums1Last = m - 1;

        int nums2Last = n - 1;

        int lastIndex = m + n - 1;

        if (nums2Last < 0) {
            return;
        }

        if (nums1Last < 0) {
            for (int i = m; i < m + n; i++) {
                nums1[i] = nums2[i - m];
            }
            return;
        }

        while (nums1Last >= 0 && nums2Last >= 0) {
            int num1Val = nums1[nums1Last];
            int num2Val = nums2[nums2Last];

            nums1[lastIndex--] = Math.max(num1Val, num2Val);
            if (num1Val - num2Val > 0) {
                nums1Last--;
            } else {
                nums2Last--;
            }
        }

        while (nums2Last >= 0) {
            nums1[lastIndex--] = nums2[nums2Last--];
        }
    }

}

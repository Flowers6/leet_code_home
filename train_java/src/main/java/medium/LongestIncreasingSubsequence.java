package medium;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/12
 * @time : 8:55
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int[] temp = new int[length];
            int tempLastIndex = 0;
            temp[tempLastIndex] = nums[i];
            int tempLength = 1;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] <= temp[tempLastIndex]) {
                    continue;
                }

                tempLastIndex++;
                temp[tempLastIndex] = nums[j];
                tempLength++;
            }
            res = Math.max(res, tempLength);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] n = {0,1,0,3,2,3};
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        System.out.println(obj.lengthOfLIS(n));
    }

}

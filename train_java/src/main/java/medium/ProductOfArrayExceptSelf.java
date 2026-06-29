package medium;

import java.util.Arrays;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/6/29
 * @time : 19:57
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 例子：
     * [1, 2, 3, 4]
     * 当 idx 为 1 时 ,res[1] = 1 * 3 * 4 = 12 = (3 * 4) * 1
     * 3 * 4 为 product[2] 1 为 nums[0]
     */
    public static int[] productExceptSelf(int[] nums) {
        int m = nums.length + 1;
        int[] prefix = new int[m];
        prefix[0] = 1;

        int[] suffix = new int[m];
        suffix[m - 1] = 1;

        // 构建前后缀乘积
        for (int i = 1; i < m; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
            suffix[m - 1 - i] = suffix[m - i] * nums[m - 1 - i];
        }

        // 使用前缀乘积构建返回
        int[] res = new int[m - 1];
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix[i] * suffix[i + 1];
        }

        return res;
    }

}

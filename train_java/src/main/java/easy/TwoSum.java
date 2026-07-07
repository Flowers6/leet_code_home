package easy;

import java.util.*;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/7
 * @time : 14:09
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        // 首循环nums，构建map
        // map的key为值 val为数组索引
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            } else {
                map.put(nums[i], i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,11,3};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }

}

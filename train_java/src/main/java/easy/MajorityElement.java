package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/7
 * @time : 20:18
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            if (count > nums.length / 2) {
                return nums[i];
            }
            map.put(nums[i], count);
        }
        return -1;
    }

}

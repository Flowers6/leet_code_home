package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/6/30
 * @time : 20:16
 */
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        // 前缀和
        int length = nums.length + 1;
        int[] prefixSum = new int[length];
        prefixSum[0] = 0;

        // map<最长子数组和, 最长子数组的索引>
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历nums 构建前缀和
        for (int i = 1; i < length; i++) {
            prefixSum[i] = prefixSum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }

        // 构建map
        for (int i = 0; i < prefixSum.length; i++) {
            if (!map.containsKey(prefixSum[i])) {{
                map.put(prefixSum[i], i);
            }}
        }

        int res = 0;

        for (int i = 1; i < prefixSum.length; i++) {
            int need = prefixSum[i];
            if (map.containsKey(need)) {
                res = Math.max(res, i - map.get(need));
            }
        }
        return res;
    }

}

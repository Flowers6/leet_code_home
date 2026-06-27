package medium;

import java.util.*;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/6/26
 * @time : 16:23
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums1 = {100,4,200,1,3,2};
        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};
        int[] nums3 = {1,0,1,2};
        System.out.println(func2(nums1));
        System.out.println(func2(nums2));
        System.out.println(func2(nums3));
    }

    private static int func2(int[] nums) {
        int res = 0;
        if (nums.length == 0) {
            return res;
        }
        Set<Integer> hashSet = new HashSet<>(nums.length * 2);
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int num : hashSet) {
            hashSet.add(num);
            if (hashSet.contains(num - 1)) {
                continue;
            }
            // 如果左侧没有元素，则开始计算连续长度
            int curr = num;
            int length = 0;
            while (hashSet.contains(curr++)) {
                length++;
            }
            res = Math.max(res, length);
        }
        return res;
    }

    private static int func1(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // 数字重复的情况 跳过
            if (map.containsKey(num)) {
                continue;
            }

            // 当数字不存在map中时 获取左右边界 如果存在左右边界 则计算当前数字的连续序列长度
            // 左侧长度
            int leftLength = getLeft(num, map, 0);
            // 右侧长度
            int rightLength =  getRight(num, map, 0);

            // 当左右两侧均无数字时 将当前数字连续长度设置为1
            if (leftLength == 0 && rightLength == 0) {
                map.put(num, 1);
                res = Math.max(res, 1);
                continue;
            }

            // 当左右两侧均存在数字时 计算当前数字及其相邻项的连续序列长度
            if (leftLength != 0 && rightLength != 0) {
                map.put(num - 1, leftLength);
                map.put(num, leftLength + 1);
                map.put(num + 1, leftLength + rightLength + 1);
                res = Math.max(res, leftLength + rightLength + 1);
                continue;
            }

            // 当右侧无数字时 获取当前及左侧数字的连续序列长度
            if (leftLength != 0) {
                map.put(num - 1, leftLength);
                map.put(num, leftLength + 1);
                res = Math.max(res, leftLength + 1);
                continue;
            }

            map.put(num, rightLength);
            map.put(num + 1, rightLength + 1);
            res = Math.max(res, rightLength + 1);

        }
        return res;
    }

    /**
     * 递归获取左边界
     * @param num   当前数字
     * @param map   数字对应长度
     * @return      左边界
     */
    private static int getLeft(int num, Map<Integer, Integer> map, Integer leftLength) {
        if (map.containsKey(num - 1)) {
            leftLength++;
            return getLeft(num - 1, map, leftLength);
        }
        return leftLength;
    }

    /**
     * 递归获取右边界
     * @param num   当前数字
     * @param map   数字对应长度
     * @return      左边界
     */
    private static int getRight(int num, Map<Integer, Integer> map, Integer rightLength) {
        if (map.containsKey(num + 1)) {
            rightLength++;
            return getRight(num + 1, map, rightLength);
        }
        return rightLength;
    }

}

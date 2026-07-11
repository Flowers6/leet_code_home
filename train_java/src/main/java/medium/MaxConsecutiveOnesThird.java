package medium;

import java.util.*;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/11
 * @time : 16:02
 */
public class MaxConsecutiveOnesThird {

    public int longestOnes(int[] nums, int k) {
        // 可翻转次数
        int wildCard = k;
        int res = 0;

        int leftIndex = 0;
        int rightIndex = 0;

        int length = nums.length;
        // 记录是否使用可翻转次数
        Deque<Integer> wildCardUse = new ArrayDeque<>();

        while (rightIndex < length) {
            if (0 == nums[rightIndex]) {
                if (wildCard > 0) {
                    // 如果为 0 有反转次数 累计长度
                    wildCardUse.addLast(rightIndex);
                    wildCard--;
                } else {
                    if (wildCardUse.isEmpty()) {
                        leftIndex = rightIndex + 1;
                    } else {
                        leftIndex = wildCardUse.pollFirst() + 1;
                        wildCardUse.addLast(rightIndex);
                    }
                }
            }
            rightIndex++;

            res = Math.max(res, rightIndex - leftIndex);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        MaxConsecutiveOnesThird obj = new MaxConsecutiveOnesThird();
        System.out.println(obj.longestOnes(nums, 2));
    }

}

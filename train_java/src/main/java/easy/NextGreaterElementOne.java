package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/8
 * @time : 14:58
 */
public class NextGreaterElementOne {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        Map<Integer, Integer> greaterValMap = new HashMap<>();

        // 遍历nums2 获取每个值对应的更大值
        for (int i = num2Length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            greaterValMap.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        int[] res = new int[num1Length];
        for (int i = 0; i < num1Length; i++) {
            res[i] = greaterValMap.get(nums1[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,2,4};
        int[] nums2 = {6,5,4,3,2,1,7};
        NextGreaterElementOne nextGreaterElementOne = new NextGreaterElementOne();
        System.out.println(Arrays.toString(nextGreaterElementOne.nextGreaterElement(nums1, nums2)));
    }

}

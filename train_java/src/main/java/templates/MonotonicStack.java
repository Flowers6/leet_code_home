package templates;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description : 单调栈模板
 * @date : 2026/7/11
 * @time : 21:55
 */
public class MonotonicStack {

    int[] calculateGreaterElement(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekFirst() <= nums[i]) {
                stack.pollFirst();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peekFirst();
            stack.addFirst(res[i]);
        }
        return res;
    }

}

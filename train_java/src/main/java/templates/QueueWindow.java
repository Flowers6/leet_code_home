package templates;

import java.util.*;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/11
 * @time : 22:17
 */
public class QueueWindow {

    int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int length = nums.length;
        int[] res = new int[length - k + 1];
        int index = 0;
        for (int i = 0; i < length; i++) {

            // 1. 移除已经离开窗口的元素
            while (!deque.isEmpty()
                    && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 2. 维护递减队列
            while (!deque.isEmpty()
                    && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }


            // 3. 加入当前元素
            deque.addLast(i);


            // 4. 窗口形成后记录最大值
            if (i >= k - 1) {
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

}

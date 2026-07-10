package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/10
 * @time : 12:58
 */
public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // 使用优先队列存储 一对值
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(
                nums1.length * nums2.length,
                (a, b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));

        // 遍历
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                queue.add(list);
            }
        }

        // 输出k次
        while (k > 0) {
            res.add(queue.poll());
            k--;
        }

        return res;
    }

    public List<List<Integer>> fun1(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                Math.min(nums1.length, k),
                Comparator.comparingInt(a -> (nums1[a[0]] + nums2[a[1]])));
        for (int line = 0; line < Math.min(nums1.length, k); line++) {
            queue.offer(new int[]{line, 0});
        }

        while (k > 0) {
            int[] poll = queue.poll();
            List<Integer> resList = new ArrayList<>();
            resList.add(nums1[poll[0]]);
            resList.add(nums2[poll[1]]);
            res.add(resList);

            // 将下一列元素入栈
            if (poll[1] + 1 < nums2.length) {
                queue.offer(new int[]{poll[0], poll[1] + 1});
            }
            k--;
        }

        return res;
    }

}

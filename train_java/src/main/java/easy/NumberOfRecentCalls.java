package easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/9
 * @time : 11:34
 */
public class NumberOfRecentCalls {

    static class RecentCounter {

        Deque<Integer> queue = new ArrayDeque<>();

        public RecentCounter() {

        }

        public int ping(int t) {
            queue.offer(t);
            while (t - 3000 > queue.peek()) {
                queue.poll();
            }
            return queue.size();
        }

    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(642));
        System.out.println(recentCounter.ping(1849));
        System.out.println(recentCounter.ping(4921));
        System.out.println(recentCounter.ping(5936));
        System.out.println(recentCounter.ping(5957));
    }

}

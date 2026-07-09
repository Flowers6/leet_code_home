package easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/9
 * @time : 12:47
 */
public class TimeNeededToBuyTickets {

    Deque<Integer> queue = new ArrayDeque<>();

    public int timeRequiredToBuy(int[] tickets, int k) {
        int spendTime = 0;
        // 循环 tickets
        for (int i = 0; i < tickets.length; i++) {
            // 位置 i 的票已完成购买 不计时
            if (tickets[i] == 0) {
                continue;
            }

            // 购买计时
            tickets[i]--;
            spendTime++;

            // 当 位置为 k 且购买完成 直接返回
            if (i == k) {
                if (tickets[i] == 0) {
                    return spendTime;
                }
            }

            queue.addLast(i);
        }

        // 循环 queue
        while (!queue.isEmpty()) {
            // 获取头节点
            int index = queue.pollFirst();
            if (tickets[index] == 0) {
                continue;
            }
            // 头节点剩余的购票次数
            tickets[index]--;
            spendTime++;
            if (tickets[index] == 0) {
                // 购票结束 不排队
                if (index == k) {
                    return spendTime;
                }
            } else {
                // 购票没有结束 重新排队
                queue.addLast(index);
            }
        }
        return spendTime;
    }

    public static void main(String[] args) {
        int[] params = {5,1,3};
        TimeNeededToBuyTickets timeNeededToBuyTickets = new TimeNeededToBuyTickets();
        System.out.println(timeNeededToBuyTickets.timeRequiredToBuy(params, 1));
    }

}

package medium;

import common.ListNode;

import java.util.*;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/10
 * @time : 15:00
 */
public class AddTwoNumbersSecond {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<ListNode> plusNode = new ArrayList<>();

        // l1入栈
        Deque<ListNode> stack1 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.addLast(l1);
            l1 = l1.next;
        }

        // l2入栈
        Deque<ListNode> stack2 = new ArrayDeque<>();
        while (l2 != null) {
            stack2.addLast(l2);
            l2 = l2.next;
        }

        // 链表的存储值的规律为 从低位到高位
        int nextPlus = 0;
        while (stack1.peekLast() != null || stack2.peekLast() != null || nextPlus != 0) {
            int l1Val = 0;
            int l2Val = 0;

            if (stack1.peekLast() != null) {
                l1Val = stack1.pollLast().val;
            }

            if (stack2.peekLast() != null) {
                l2Val = stack2.pollLast().val;
            }

            // 将同位求和
            int newVal = l1Val + l2Val + nextPlus;
            if (newVal >= 10) {
                nextPlus = newVal / 10;
                newVal %= 10;
            } else {
                nextPlus = 0;
            }

            plusNode.add(new ListNode(newVal));
        }

        Collections.reverse(plusNode);
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        for (ListNode listNode : plusNode) {
            temp.next = listNode;
            temp = temp.next;
        }

        return res.next;
    }
}

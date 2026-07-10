package medium;

import java.util.List;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/10
 * @time : 14:41
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;

        // 链表的存储值的规律为 从低位到高位
        int nextPlus = 0;
        while (l1 != null || l2 != null || nextPlus != 0) {
            int l1Val = 0;
            int l2Val = 0;

            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }

            // 将同位求和
            int newVal = l1Val + l2Val + nextPlus;
            if (newVal >= 10) {
                nextPlus = newVal / 10;
                newVal %= 10;
            } else {
                nextPlus = 0;
            }

            temp.next = new ListNode(newVal);
            temp = temp.next;
        }

        return res.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

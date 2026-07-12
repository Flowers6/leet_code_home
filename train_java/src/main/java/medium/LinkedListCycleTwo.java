package medium;

import common.ListNode;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/12
 * @time : 14:07
 */
public class LinkedListCycleTwo {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if (head == null || head.next == null) {
            return null;
        }

        // 快指针每次行走两步数 慢指针走一步
        boolean cycleExist = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 快慢指针重合时 即存在环形链表 长为 k 当前fast步长为 2k
            if (fast == slow) {
                cycleExist = true;
                break;
            }
        }

        if (!cycleExist) {
            return null;
        }

        // 此时将慢指针 指向头节点 快慢指针以相同步频前进
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // 重合时即为入环的第一个节点
        return slow;
    }

}

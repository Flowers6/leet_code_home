package medium;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/9
 * @time : 20:21
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head;
        ListNode preNode = new ListNode(-114514);
        ListNode res = new ListNode(-1);
        ListNode temp = res;

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        while (currentNode != null) {

            boolean left = preNode.val != currentNode.val;
            boolean right = currentNode.next == null || currentNode.val != currentNode.next.val;

            // 如果不相等 添加至res中
            if (left && right) {
                temp.next = new ListNode(currentNode.val);
                temp = temp.next;
            }

            preNode = currentNode;
            currentNode = currentNode.next;

        }
        return res.next;
    }

    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }
}

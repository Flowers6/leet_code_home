package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/7
 * @time : 16:28
 */
public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            Node copy = new Node(curr.val);
            copy.next = next;
            curr.next = copy;
            curr = next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node res = head.next;
        curr = head;
        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            curr = curr.next;
        }

        return res;
    }

    public Node func2(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            nodeMap.put(curr, copy);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node copy = nodeMap.get(curr);
            copy.next = nodeMap.get(curr.next);
            copy.random = nodeMap.get(curr.random);
            curr = curr.next;
        }

        return nodeMap.get(head);
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}

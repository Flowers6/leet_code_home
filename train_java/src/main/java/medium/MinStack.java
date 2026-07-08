package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/8
 * @time : 21:52
 */
public class MinStack {

    Deque<MinStackNode> stack = new ArrayDeque<>();

    public void push(int value) {
        MinStackNode minStackNode = new MinStackNode();
        minStackNode.val = value;
        if (stack.isEmpty()) {
            minStackNode.min = value;
            stack.addLast(minStackNode);
            return;
        }
        minStackNode.min = Math.min(value, stack.getLast().min);
        stack.addLast(minStackNode);
    }

    public void pop() {
        stack.removeLast();
    }

    public int top() {
        return stack.isEmpty() ? 0 : stack.peekLast().val;
    }

    public int getMin() {
        return stack.getLast().min;
    }

    public static class MinStackNode {
        int val;
        int min;
    }

}

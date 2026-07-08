package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/8
 * @time : 20:38
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String str : tokens) {
            Integer newNum1 = null;
            Integer newNum2 = null;
            if ("+".equals(str)) {
                newNum1 = stack.pollLast();
                newNum2 = stack.pollLast();
                int res = (newNum2 + newNum1);
                stack.addLast(res);
            } else if ("-".equals(str)) {
                newNum1 = stack.pollLast();
                newNum2 = stack.pollLast();
                int res = (newNum2 - newNum1);
                stack.addLast(res);
            } else if ("*".equals(str)) {
                newNum1 = stack.pollLast();
                newNum2 = stack.pollLast();
                int res = (newNum2 * newNum1);
                stack.addLast(res);
            } else if ("/".equals(str)) {
                newNum1 = stack.pollLast();
                newNum2 = stack.pollLast();
                int res = (newNum2 / newNum1);
                stack.addLast(res);
            } else {
                stack.addLast(Integer.parseInt(str));
            }
        }

        return stack.peek();
    }

}

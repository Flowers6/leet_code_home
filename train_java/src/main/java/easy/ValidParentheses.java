package easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/8
 * @time : 20:14
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        String[] split = s.split("");
        Deque<String> stack = new ArrayDeque<>();
        for (String str : split) {
            if (str.equals("(") || str.equals("[") || str.equals("{")) {
                stack.addLast(str);
            } else if (!stack.isEmpty()) {
                if (str.equals(")") && "(".equals(stack.getLast())) {
                    stack.removeLast();
                } else if (str.equals("]") && "[".equals(stack.getLast())) {
                    stack.removeLast();
                } else if (str.equals("}") && "{".equals(stack.getLast())) {
                    stack.removeLast();
                } else {
                    stack.addLast(str);
                }
            } else {
                stack.addLast(str);
            }
        }

        return stack.isEmpty();
    }

}

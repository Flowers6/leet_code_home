package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/8
 * @time : 19:28
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] split = path.split("/");
        int n = split.length;
        for (int i = 0; i < n; i++) {
            String s = split[i];
            if (s.isEmpty()) {
                continue;
            }

            if (s.equals(".")) {
                continue;
            }

            if (s.equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.removeLast();
                continue;
            }

            stack.addLast("/" + s);
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pollFirst());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String path = "/home/user/Documents/../Pictures";
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath(path));
    }

}

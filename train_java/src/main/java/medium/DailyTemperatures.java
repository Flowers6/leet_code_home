package medium;

import java.util.*;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/8
 * @time : 16:29
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        // key: temperature index: greater temperature
        Map<Integer, Temperature> greaterTemperatureMap = new HashMap<>();
        Stack<Temperature> stack = new Stack<>();

        // iterate all temperatures to collect greaterTemperatureMap
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().val <= temperatures[i]) {
                stack.pop();
            }
            greaterTemperatureMap.put(i, stack.isEmpty() ? null : stack.peek());
            Temperature temperature = new Temperature();
            temperature.val = temperatures[i];
            temperature.index = i;
            stack.push(temperature);
        }

        int[] res = new int[temperatures.length];
        for (int currentIndex = 0; currentIndex < temperatures.length; currentIndex++) {

            Temperature greaterTemp = greaterTemperatureMap.get(currentIndex);

            if (greaterTemp == null) {
                res[currentIndex] = 0;
                continue;
            }

            res[currentIndex] = greaterTemp.index - currentIndex;
        }

        return res;
    }

    public static class Temperature {
        int val;
        int index;
    }

    public int[] fun2(int[] temperatures) {
        // key: temperature index: greater temperature index
        Map<Integer, Integer> greaterTemperatureMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // iterate all temperatures to collect greaterTemperatureMap
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            greaterTemperatureMap.put(i, stack.isEmpty() ? null : stack.peek());
            stack.push(i);
        }

        int[] res = new int[temperatures.length];
        for (int currentIndex = 0; currentIndex < temperatures.length; currentIndex++) {

            Integer greaterIndex = greaterTemperatureMap.get(currentIndex);

            if (greaterIndex == null) {
                res[currentIndex] = 0;
                continue;
            }

            res[currentIndex] = greaterIndex - currentIndex;
        }

        return res;
    }

    public int[] fun3(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                Integer preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return res;
    }

}

package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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

}

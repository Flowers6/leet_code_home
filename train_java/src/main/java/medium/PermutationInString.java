package medium;


import java.util.HashMap;
import java.util.Map;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/12
 * @time : 13:33
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {

        // s1 是一个连续字符串 作为滑动窗口的长度
        int windowWide = s1.length();
        int left = 0, right = 0;
        int length = s2.length();
        boolean res = false;

        // 遍历 s1 获取需要的元素个数
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char charAt = s1.charAt(i);
            need.put(charAt, need.getOrDefault(charAt, 0) + 1);
        }

        // 遍历 s2 不断移动滑动窗口
        Map<Character, Integer> window = new HashMap<>();
        while (right < length) {

            char rightVal = s2.charAt(right);
            // 当滑动窗口 元素超出， 移除元素
            while (right - left + 1 > windowWide) {
                char leftVal = s2.charAt(left);
                window.put(leftVal, window.getOrDefault(leftVal, 0) - 1);
                if (need.containsKey(leftVal)) {
                    need.put(leftVal, need.get(leftVal) + 1);
                }
                left++;
            }

            // 将当前位置元素移入滑窗
            window.put(rightVal, window.getOrDefault(rightVal, 0) + 1);
            if (need.containsKey(rightVal)) {
                need.put(rightVal, need.get(rightVal) - 1);
            }

            // 判断 s1 的全部元素是否已在window中
            if (need.values().stream().allMatch(i -> i == 0)) {
                return true;
            }

            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "eidbaooo";
        PermutationInString obj = new PermutationInString();
        System.out.println(obj.checkInclusion("ab", s));
    }

}

package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/11
 * @time : 10:39
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int length = s.length();

        int left = 0, right = 0, resLength = 0;
        while (right < length) {
            char rightChar = s.charAt(right);
            right++;

            // 如果窗口中无重复元素则一直添加
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            while (window.get(rightChar) > 1) {
                char leftChar = s.charAt(left);
                // 窗口中出现重复元素 重新计长
                left++;
                window.put(leftChar, window.get(leftChar) - 1);
            }

            resLength = Math.max(resLength, right - left);
        }

        return resLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstring(s));
    }

}

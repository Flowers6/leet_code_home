package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/11
 * @time : 9:52
 */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int length = p.length();
        List<Integer> res = new ArrayList<>();

        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            right++;

            if (need.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                if (window.get(rightChar).equals(need.get(rightChar))) {
                    valid++;
                }
            }

            while (right - left >= length) {
                if (need.size() == valid) {
                    res.add(left);
                }

                char leftChar = s.charAt(left);
                left++;

                if (need.containsKey(leftChar)) {
                    if (window.get(leftChar).equals(need.get(leftChar))) {
                        valid--;
                    }
                    window.put(leftChar, window.get(leftChar) - 1);
                }
            }
        }

        return res;
    }

}

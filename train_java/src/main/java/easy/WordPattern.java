package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/7
 * @time : 15:37
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split("\\s");
        Map<String, String> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        Set<String> existTarget = new HashSet<>();
        int patternIdx = 0;
        for (String part : split) {
            if (map.containsKey(part)) {
                stringBuilder.append(map.get(part));
            } else if (patternIdx <= pattern.length() - 1) {
                String target = String.valueOf(pattern.toCharArray()[patternIdx]);
                while (existTarget.contains(target)) {
                    if (patternIdx > pattern.length() - 1) {
                        return false;
                    }
                    target = String.valueOf(pattern.toCharArray()[patternIdx++]);
                }
                map.put(part, target);
                stringBuilder.append(target);
                existTarget.add(target);
            } else {
                return false;
            }
        }
        return stringBuilder.toString().equals(pattern);
    }

    public static void main(String[] args) {
        String pattern = "deadbeef";
        String s = "d e a d b e e f";
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern(pattern, s));
    }

}

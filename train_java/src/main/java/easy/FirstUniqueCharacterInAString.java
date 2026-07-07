package easy;

import java.util.*;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/7
 * @time : 18:59
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        String[] split = s.split("");
        Map<String, Integer> map = new HashMap<>();
        Set<Integer> repeatElements = new HashSet<>();
        List<Integer> allIdx = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            allIdx.add(i);
            if (!map.containsKey(split[i])) {
                map.put(split[i], i);
            } else {
                repeatElements.add(i);
                repeatElements.add(map.get(split[i]));
            }
        }

        if (allIdx.size() == repeatElements.size()) {
            return -1;
        }

        allIdx.removeAll(repeatElements);
        return allIdx.get(0);
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        FirstUniqueCharacterInAString firstUniqueCharacterInAString = new FirstUniqueCharacterInAString();
        System.out.println(firstUniqueCharacterInAString.firstUniqChar(s));
    }

    public int fun2(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            Character key = charArray[i];
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }

        int res = -1;
        for (int i = 0; i < s.length(); i++) {
           if (countMap.get(charArray[i]) == 1) {
               return i;
           }
        }

        return res;
    }

}

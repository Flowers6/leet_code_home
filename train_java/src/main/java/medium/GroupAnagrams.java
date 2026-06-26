package medium;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/6/26
 * @time : 15:25
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] str1 = new String[] {"eat","tea","tan","ate","nat","bat"};
        String[] str2 = new String[] {""};
        String[] str3 = new String[] {"a"};
        System.out.println(func1(str1));
        System.out.println(func1(str2));
        System.out.println(func1(str3));
    }

    private static List<List<String>> func1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        // 遍历 strs
        for (String str : strs) {
            // 将str 转为 char[]
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>(List.of(str)));
            } else {
                List<String> sourceList = map.get(sortedStr);
                sourceList.add(str);
                map.put(sortedStr, sourceList);
            }
        }

        // 遍历 map 组装返回
        return new ArrayList<>(map.values());
    }

}

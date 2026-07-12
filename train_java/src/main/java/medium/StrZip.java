package medium;

import java.util.*;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/12
 * @time : 9:45
 */
public class StrZip {

    public String strZip(String str) {
        // 统计每个字符出现的次数
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char element = str.charAt(i);
            countMap.put(element, countMap.getOrDefault(element, 0) + 1);
        }

        // 获取每种字符第一次出现索引
        List<Integer> elementIndex = new ArrayList<>();
        StringBuilder appender = new StringBuilder();
        for (Character element : countMap.keySet()) {
            elementIndex.add(str.indexOf(element));
            appender.append(element);
        }

        // 当每个字符出现次数相同
        Integer count = countMap.values().iterator().next();
        if (countMap.values().stream().allMatch(count::equals)) {
            if (countMap.size() == 1) {
                // 当字符种类为1
                // 直接返回该字符出现次数
                return appender.toString() + count;
            } else if (countMap.size() > 1) {
                // 当字符种类大于1
                // 如果索引连续 则返回该字符出现次数
                boolean pass = true;
                for (int i = 1; i < elementIndex.size(); i++) {
                    if (elementIndex.get(i) != elementIndex.get((i - 1)) + 1) {
                        pass = false;
                        break;
                    }
                }
                if (pass) {
                    return appender.toString() + count;
                }
            }
        }

        // 默认返回原字符串 表示无法由某个子串重复多次构成
        return str;
    }

}

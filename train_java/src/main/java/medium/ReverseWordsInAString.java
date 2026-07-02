package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/2
 * @time : 17:30
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {

        // 去除多余空格正则
        String distinctSpace = "\s+";

        // 去除首尾空格正则
        String trimSpace = "^\s+|\s+$";
        s = s.replaceAll(distinctSpace, " ");
        s = s.replaceAll(trimSpace, "");

        // 按空格分割字符串
        List<String> strList = Arrays.asList(s.split("\s"));

        // 反转
        Collections.reverse(strList);

        return String.join("\s", strList);
    }

}

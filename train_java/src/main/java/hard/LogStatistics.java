package hard;

import java.util.*;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description : <p>给定日志字符串数组 logs 和关键词数组 keywords，统计每个关键词在所有日志中出现的总次数，并找出经常一起出现的关键词组合（至少在2 条日志中同时出现）。</p>
 * @date : 2026/6/26
 * @time : 13:31
 */
public class LogStatistics {

    /**
     * 暴力解法
     * @param logs      日志
     * @param keywords  关键词
     */
    public int[] fun1(String[] logs, String[] keywords) {
        int[] res = new int[keywords.length + (keywords.length * (keywords.length - 1) / 2)];
        for (String log : logs) {
            // 去除特殊符号
            String specialSymbolsRegex = "[,.!?;:]";
            log = log.replaceAll(specialSymbolsRegex, "");
            // 分词
            String[] logWords = log.split(" ");
            // 统计关联词
            Set<Integer> kwIdxes = new HashSet<>();
            for (int keywordIdx = 0; keywordIdx < keywords.length; keywordIdx++) {
                for (String logWord : logWords) {
                    // 忽略大小写比较
                    if (logWord.equalsIgnoreCase(keywords[keywordIdx])) {
                        res[keywordIdx]++;
                        kwIdxes.add(keywordIdx);
                    }
                }
            }

            // 构建关联词
            List<Integer> kwIdxesList = new ArrayList<>(kwIdxes);
            Map<String, Integer> kwCombination = new HashMap<>();
            for (int i = 0; i < kwIdxesList.size(); i++) {
                for (int j = i + 1; j < kwIdxesList.size(); j++) {
                    // 就是一组关联组合
                    kwCombination.merge(kwIdxesList.get(i) + "#" + kwIdxesList.get(j), 1, Integer::sum);
                }
            }

            final int[] addIdx = {keywords.length};
            kwCombination.forEach((key, value) -> {
                if (value >= 2) {
                    String[] split = key.split("#");
                    res[addIdx[0] + 1] = Integer.parseInt(split[0]);
                    res[addIdx[0] + 2] = Integer.parseInt(split[1]);
                    addIdx[0] += 2;
                }
            });
        }

        // TODO 有点难 未完成 打上败者标记
        return res;
    }

    public static void main(String[] args) {
        String[] log1 = new String[]{"Error in system", "warning: error detected", "No errors found"};
        String[] keyword1 = new String[]{"error", "warning"};

        String[] log2 = new String[]{"Error: system failure", "Warning: error in network", "System error detected again", "Network warning error found"};
        String[] keyword2 = new String[]{"error", "system", "warning", "network"};

        String[] log3 = new String[]{"Error in module A", "Module error B error", "Error module C error", "Module error D"};
        String[] keyword3 = new String[]{"error", "module"};

        String[] log4 = new String[]{"Test log one","Test log two","Test log three"};
        String[] keyword4 = new String[]{"test", "log", "one", "two", "three"};

        LogStatistics logStatistics = new LogStatistics();
        System.out.println(Arrays.toString(logStatistics.fun1(log1, keyword1)));
        System.out.println(Arrays.toString(logStatistics.fun1(log2, keyword2)));
        System.out.println(Arrays.toString(logStatistics.fun1(log3, keyword3)));
        System.out.println(Arrays.toString(logStatistics.fun1(log4, keyword4)));
    }
}

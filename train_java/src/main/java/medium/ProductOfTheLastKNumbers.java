package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/6/29
 * @time : 21:09
 */
public class ProductOfTheLastKNumbers {

    static class ProductOfNumbers {

        // 前缀积
        List<Integer> prefixSum = new ArrayList<>();

        public ProductOfNumbers() {
            prefixSum.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                prefixSum.clear();
                prefixSum.add(1);
            } else {
                prefixSum.add(prefixSum.get(endIdx()) * num);
            }
        }

        // 获取从k开始 到末尾的乘积
        public int getProduct(int k) {
            if (endIdx() <= k - 1) {
                return 0;
            }
            return prefixSum.get(endIdx()) / prefixSum.get(endIdx() - k);
        }

        private int endIdx() {
            return prefixSum.size() - 1;
        }
    }

}

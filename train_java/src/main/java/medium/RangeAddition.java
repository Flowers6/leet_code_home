package medium;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/1
 * @time : 16:08
 */
public class RangeAddition {

    public static class DiffArray {
        private int[] diff;

        // 构造器 初始化差分数组
        public DiffArray(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        // 减去指定区间的值
        public void minus(int val, int start, int end) {
            diff[start] -= val;
            if (end + 1 < diff.length) {
                diff[end + 1] += val;
            }
        }

        // 加上指定区间的值
        public void plus(int val, int start, int end) {
            diff[start] += val;
            if (end + 1 < diff.length) {
                diff[end + 1] -= val;
            }
        }

        // 返回加减之后的原数组
        public int[] res() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int index = 1; index < diff.length; index++) {
                res[index] = res[index - 1] + diff[index];
            }
            return res;
        }

    }

}

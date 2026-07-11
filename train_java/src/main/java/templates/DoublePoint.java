package templates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description : 双指针模板
 * @date : 2026/7/11
 * @time : 20:03
 */
public class DoublePoint {

    /**
     * 快慢指针
     * @param nums
     * @return
     */
    public int fastSlow(int[] nums) {
        int fast = 0, slow = 0;
        int length = nums.length;
        int res = 0;
        while (fast < length) {
            if (condition()) {
                slow++;
            }
            fast++;
        }

        return res;
    }

    public boolean condition() {
        return false;
    }

    /**
     * 滑动窗口
     * @param nums
     */
    public void window(int[] nums) {
        int left = 0, right = 0;
        List<Integer> window = new ArrayList<>();
        int length = nums.length;
        while (right < length) {
            window.add(right);
            right++;

            while (condition()) {
                window.remove(left);
                left++;
            }
        }
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 两数之和
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int left = 0, right = length - 1;
        while (left <= right) {
            int leftVal = numbers[left];
            int rightVal = numbers[right];
            int sum = leftVal + rightVal;
            if (target == sum) {
                return new int[] {left, right};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] {-1, -1};
    }

    /**
     * n 数之和
     * @param nums
     * @param n
     * @param start
     * @param target
     * @return
     */
    List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;

        if (n < 2 || length < n) return res;
        if (n == 2) {
            int left = start, right = length - 1;
            while (left < right) {
                int leftVal = nums[left];
                int rightVal = nums[right];
                int sum = leftVal + rightVal;
                if (target == sum) {
                    res.add(new ArrayList<>(Arrays.asList(leftVal, rightVal)));
                    right--;
                    left++;
                } else if (sum > target) {
                    while (left < right && nums[right] == rightVal) right--;
                } else {
                    while (left < right && nums[left] == leftVal) left++;
                }
            }
        } else {
            for (int i = start; i < length; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> arr : sub) {
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i < length - 1 && nums[i] == nums[i + 1]) i++;
            }
        }

        return res;
    }
}

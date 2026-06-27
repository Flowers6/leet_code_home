package medium;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/6/27
 * @time : 11:51
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
//        int[] nums1 = {1,8,6,2,5,4,8,3,7};
        int[] nums2 = {1,2,3,1000,9};
//        System.out.println(func1(nums1));
        System.out.println(func1(nums2));
    }

    private static int func1(int[] height) {
        // 算出四个坐标点间的最大面积
        // 数组 索引代表 x 轴, 值代表 y 轴
        // 面积为 min(y1, y2) * math.abs(x1 - x2)

        // 双指针 方法
        // 慢指针 为 x1 y1 x2 y2
        // 快指针 为 x3 y3
        // 当最大面积发生变化时 进行指针移位
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

}

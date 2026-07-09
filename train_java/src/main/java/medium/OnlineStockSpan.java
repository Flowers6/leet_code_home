package medium;

import java.util.*;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/9
 * @time : 13:26
 */
public class OnlineStockSpan {

    static class StockSpanner {

        Deque<Integer> deque = new ArrayDeque<>();

        Deque<int[]> arrayDeque = new ArrayDeque<>();

        int index = -1;

        public StockSpanner() {
        }

        public int fun1(int price) {
            index++;
            while (!arrayDeque.isEmpty() && arrayDeque.peekLast()[1] <= price) {
                arrayDeque.pollLast();
            }

            int res = index - arrayDeque.peekLast()[0];
            arrayDeque.addLast(new int[] {index, price});

            return res;
        }

        public int next(int price) {
            int res = 1;
            List<Integer> pollList = new ArrayList<>();
            while (!deque.isEmpty() && deque.peekLast() <= price) {
                Integer poll = deque.pollLast();
                pollList.add(poll);
            }

            // 将出栈的元素 重新按顺序入栈
            for (Integer poll : pollList) {
                deque.addLast(poll);
                res++;
            }
            deque.addLast(price);

            return res;
        }
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.fun1(100));
        System.out.println(stockSpanner.fun1(80));
        System.out.println(stockSpanner.fun1(60));
        System.out.println(stockSpanner.fun1(70));
        System.out.println(stockSpanner.fun1(60));
        System.out.println(stockSpanner.fun1(75));
        System.out.println(stockSpanner.fun1(85));
    }

}

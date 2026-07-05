package medium;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/5
 * @time : 11:22
 */
public class DesignCircularQueue {

    static class MyCircularQueue {

        int[] memory;
        int size;
        int endIdx;
        int startIdx;
        int elementCount;

        public MyCircularQueue(int k) {
            memory = new int[k];
            size = k;
            endIdx = 0;
            startIdx = 0;
            elementCount = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }

            endIdx = (endIdx + 1) % size;
            if (isEmpty()) {
                startIdx = endIdx;
            }
            memory[endIdx] = value;
            elementCount++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }

            memory[startIdx] = 0;
            startIdx = (startIdx + 1) % size;
            elementCount--;
            if (isEmpty()) {
                memory[startIdx] = 0;
            }
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return memory[startIdx];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return memory[endIdx];
        }

        public boolean isEmpty() {
            return elementCount == 0;
        }

        public boolean isFull() {
            return size == elementCount;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        System.out.println(myCircularQueue.Rear());
    }

}

package medium;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/5
 * @time : 10:42
 */
public class DesignCircularDeque {

    static class MyCircularDeque {

        int[] memory;
        int size;
        int frontIdx;
        int endIdx;
        int elementCount;

        public MyCircularDeque(int k) {
            memory = new int[k];
            size = k;
            frontIdx = 0;
            endIdx = k - 1;
            elementCount = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }

            frontIdx = (frontIdx - 1 + size) % size;
            memory[frontIdx] = value;
            elementCount++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }

            endIdx = (endIdx + 1) % size;
            memory[endIdx] = value;
            elementCount++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }

            frontIdx = (frontIdx + 1) % size;
            elementCount--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }

            endIdx = (endIdx - 1 + size) % size;
            elementCount--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return memory[frontIdx];
        }

        public int getRear() {
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
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertLast(1);
        myCircularDeque.insertLast(2);
        myCircularDeque.insertFront(3);
        myCircularDeque.insertFront(4);
        System.out.println(myCircularDeque.getRear());
    }

}

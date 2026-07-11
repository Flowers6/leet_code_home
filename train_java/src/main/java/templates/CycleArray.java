package templates;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/11
 * @time : 21:02
 */
public class CycleArray<T> {

    T[] arr;
    int start;
    int end;
    int count;
    int size;

    public CycleArray (int size) {
        arr = (T[]) new Object [size];
        start = 0;
        end = 0;
        count = 0;
        this.size = size;
    }

    public void addFirst(T val) {
        if (isFull()) {
            resize(size * 2);
        }
        arr[start] = val;
        start = (start - 1 + size) % size;
        count++;
    }

    public void addLast(T val) {
        if (isFull()) {
            resize(size * 2);
        }
        arr[end] = val;
        end = (end + 1) % size;
        count++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }
        arr[start] = null;
        start = (start + 1) % size;
        count--;
    }

    public void removeLast() {
        if (isEmpty()) {
            return;
        }
        arr[end] = null;
        end = (end - 1 + size) % size;
        count--;
    }

    private void resize(int newSize) {
        // 创建新的数组
        T[] newArr = (T[]) new Object[newSize];
        // 将旧数组的元素复制到新数组中
        for (int i = 0; i < count; i++) {
            newArr[i] = arr[(start + i) % size];
        }
        arr = newArr;
        // 重置 start 和 end 指针
        start = 0;
        end = count;
        size = newSize;
    }

    public boolean isFull() {
        return count == size;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

}

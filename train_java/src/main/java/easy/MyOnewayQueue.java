package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/8
 * @time : 15:02
 */
public class MyOnewayQueue<T> {

    List<T> elements = new ArrayList<>();

    private final static int HEAD_INDEX = 0;

    public int lastIndex() {
        return elements.size() - 1;
    }

    public boolean push(T t) {
        return elements.add(t);
    }

    public T pop(T t) {
        return elements.get(HEAD_INDEX);
    }

    public T peek() {
        return elements.get(lastIndex());
    }
}

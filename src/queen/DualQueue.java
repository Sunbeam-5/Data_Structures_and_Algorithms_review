package queen;

import java.util.LinkedList;

public class DualQueue<T> {
    private LinkedList<T> data;

    public DualQueue() {
        data = new LinkedList<>();
    }

    // 添加元素到队列尾部
    public void offerLast(T item) {
        data.addLast(item);
    }

    // 从队列头部移除元素
    public T pollFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data.removeFirst();
    }

    // 添加元素到栈顶
    public void push(T item) {
        data.addFirst(item);
    }

    // 从栈顶移除元素
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data.removeFirst();
    }

    // 检查队列是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 获取队列的大小
    public int size() {
        return data.size();
    }
}

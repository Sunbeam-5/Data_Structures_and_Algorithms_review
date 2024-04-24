package queen;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class DynamicArrayQueue<T> {
    private ArrayList<T> array;
    private int front; // 队头指针
    private int rear; // 队尾指针

    public DynamicArrayQueue() {
        this.array = new ArrayList<>();
        this.front = 0;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return rear < front;
    }

    public void enqueue(T item) {
        array.add(item);
        rear++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = array.get(front);
        front++;
        // 当队列中元素已经过多被移除，进行缩小队列
        if (front > array.size() / 2) {
            for (int i = 0; i < array.size() - front; i++) {
                array.set(i, array.get(front + i));
            }
            rear -= front;
            front = 0;
        }
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array.get(front);
    }

    public int size() {
        return rear - front + 1;
    }

    public static void main(String[] args) {
        DynamicArrayQueue<Integer> queue = new DynamicArrayQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("队头元素: " + queue.peek()); // 输出：1
        System.out.println("队列大小: " + queue.size()); // 输出：3

        System.out.println("出队元素: " + queue.dequeue()); // 输出：1
        System.out.println("队列大小: " + queue.size()); // 输出：2

        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("出队元素: " + queue.dequeue()); // 输出：2
        System.out.println("队列大小: " + queue.size()); // 输出：3

        System.out.println("出队元素: " + queue.dequeue()); // 输出：3
        System.out.println("队列大小: " + queue.size()); // 输出：2
    }
}

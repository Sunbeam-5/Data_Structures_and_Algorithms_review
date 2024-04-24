package queen;

import java.util.EmptyStackException;

public class FixedArrayQueue<T> {
    private T[] array;
    private int front; // 队头指针
    private int rear; // 队尾指针
    private int size; // 队列大小
    private int capacity; // 队列容量

    public FixedArrayQueue(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity; // 环形移动 rear 指针
        array[rear] = item;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = array[front];
        front = (front + 1) % capacity; // 环形移动 front 指针
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[front];
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        FixedArrayQueue<Integer> queue = new FixedArrayQueue<>(5);
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

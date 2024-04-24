package queen;

import java.util.EmptyStackException;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedQueue<T> {
    private Node<T> front; // 队头指针
    private Node<T> rear; // 队尾指针

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return front.data;
    }

    public int size() {
        int count = 0;
        Node<T> current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
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

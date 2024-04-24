package stack;

import java.util.EmptyStackException;

class Node<T> {
    T data;
    Node<T> prev;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedStack<T> {
    private Node<T> top; // 栈顶节点

    public DoublyLinkedStack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        if (top != null) {
            top.next = newNode;
            newNode.prev = top;
        }
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.prev;
        if (top != null) {
            top.next = null;
        }
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public int size() {
        int count = 0;
        Node<T> current = top;
        while (current != null) {
            count++;
            current = current.prev;
        }
        return count;
    }

    public static void main(String[] args) {
        DoublyLinkedStack<Integer> stack = new DoublyLinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("栈顶元素: " + stack.peek()); // 输出：3
        System.out.println("栈大小: " + stack.size()); // 输出：3

        System.out.println("弹出栈顶元素: " + stack.pop()); // 输出：3
        System.out.println("栈大小: " + stack.size()); // 输出：2

        System.out.println("弹出栈顶元素: " + stack.pop()); // 输出：2
        System.out.println("栈大小: " + stack.size()); // 输出：1

        System.out.println("弹出栈顶元素: " + stack.pop()); // 输出：1
        System.out.println("栈大小: " + stack.size()); // 输出：0
    }
}

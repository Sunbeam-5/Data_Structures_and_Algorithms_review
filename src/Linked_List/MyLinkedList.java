package Linked_List;

import java.util.NoSuchElementException;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class MyLinkedList<T> {
    private Node<T> head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }

    public T getLast() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        T removedData = head.data;
        head = head.next;
        size--;
        return removedData;
    }

    public T removeLast() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        if (head.next == null) {
            T removedData = head.data;
            head = null;
            size--;
            return removedData;
        }
        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        T removedData = current.next.data;
        current.next = null;
        size--;
        return removedData;
    }

    public boolean contains(T element) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);

        System.out.println("Size: " + list.size()); // 输出：3
        System.out.println("First element: " + list.getFirst()); // 输出：1
        System.out.println("Last element: " + list.getLast()); // 输出：3

        list.removeFirst();
        System.out.println("Size after removing first element: " + list.size()); // 输出：2

        list.removeLast();
        System.out.println("Size after removing last element: " + list.size()); // 输出：1

        System.out.println("Contains 2: " + list.contains(2)); // 输出：false
        System.out.println("Contains 1: " + list.contains(1)); // 输出：true

        list.clear();
        System.out.println("Size after clearing the list: " + list.size()); // 输出：0
    }
}

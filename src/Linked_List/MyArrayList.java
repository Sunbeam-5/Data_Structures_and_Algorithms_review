package Linked_List;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public MyArrayList() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        this.array = new Object[initialCapacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T element) {
        ensureCapacity(size + 1);
        array[size++] = element;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        ensureCapacity(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) array[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        T removedElement = (T) array[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[--size] = null; // clear to let GC do its work
        return removedElement;
    }

    public boolean remove(Object obj) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(obj)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = array.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("Size: " + list.size()); // 输出：3
        System.out.println("Element at index 1: " + list.get(1)); // 输出：2

        list.remove(1);
        System.out.println("Size after removing element at index 1: " + list.size()); // 输出：2

        System.out.println("Element at index 1 after removal: " + list.get(1)); // 输出：3

        System.out.println("Removing element 1: " + list.remove((Integer) 1)); // 输出：true

        System.out.println("Size after removing element 1: " + list.size()); // 输出：1

        list.clear();
        System.out.println("Size after clearing the list: " + list.size()); // 输出：0
    }
}

package stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class DynamicArrayStack<T> {
    private ArrayList<T> array;

    public DynamicArrayStack() {
        this.array = new ArrayList<>();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public void push(T item) {
        array.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array.remove(array.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array.get(array.size() - 1);
    }

    public int size() {
        return array.size();
    }

    public static void main(String[] args) {
        DynamicArrayStack<Integer> stack = new DynamicArrayStack<>();
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

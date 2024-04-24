package stack;

import java.util.EmptyStackException;

public class FixedArrayStack<T> {
    private Object[] array;
    private int top; // 栈顶指针

    public FixedArrayStack() {
        this.array = new Object[10]; // 假设数组大小为10
        this.top = -1; // 栈顶指针初始化为-1
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == array.length - 1;
    }

    public void push(T item) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        array[++top] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = (T) array[top];
        array[top--] = null; // 清除已弹出的元素
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) array[top];
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        FixedArrayStack<Integer> stack = new FixedArrayStack<>();
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

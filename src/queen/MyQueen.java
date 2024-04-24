package queen;

public class MyQueen {

    public static class Node <T> {
        public T data;
        public Node<T> prev;
        public Node<T> next;
        public Node(T data) {
            this.data = data;
        }
    }

    public static class doublyEndsQueue <T> {
        public Node<T> head;
        public Node<T> tail;
    }
}

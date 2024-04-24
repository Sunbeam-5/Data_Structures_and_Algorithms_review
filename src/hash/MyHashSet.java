package hash;

import java.util.LinkedList;

public class MyHashSet<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private LinkedList<T>[] buckets;
    private int size;

    public MyHashSet() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashSet(int initialCapacity) {
        this.buckets = new LinkedList[initialCapacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(T key) {
        return key.hashCode() % buckets.length;
    }

    public boolean contains(T key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return false;
        }
        return buckets[index].contains(key);
    }

    public void add(T key) {
        if (contains(key)) {
            return;
        }
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        buckets[index].add(key);
        size++;
        if ((double) size / buckets.length >= LOAD_FACTOR) {
            rehash();
        }
    }

    public void remove(T key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return;
        }
        buckets[index].remove(key);
        size--;
    }

    private void rehash() {
        LinkedList<T>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        size = 0;
        for (LinkedList<T> bucket : oldBuckets) {
            if (bucket != null) {
                for (T key : bucket) {
                    add(key);
                }
            }
        }
    }

    public static void main(String[] args) {
        MyHashSet<Integer> set = new MyHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println("Contains 2: " + set.contains(2)); // 输出：true
        System.out.println("Contains 4: " + set.contains(4)); // 输出：false

        set.remove(2);
        System.out.println("Contains 2 after removal: " + set.contains(2)); // 输出：false

        System.out.println("Size: " + set.size()); // 输出：2
    }
}

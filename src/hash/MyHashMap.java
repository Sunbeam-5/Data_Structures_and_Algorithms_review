package hash;

import java.util.Arrays;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Entry<K, V>[] table;
    private int size;

    public MyHashMap() {
        this.table = new Entry[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        return table[index] != null && table[index].key.equals(key);
    }

    public V get(K key) {
        int index = getIndex(key);
        return table[index] != null ? table[index].value : null;
    }

    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new Entry<>(key, value);
            size++;
        } else {
            if (table[index].key.equals(key)) {
                table[index].value = value;
            } else {
                int newIndex = getNextIndex(index);
                while (table[newIndex] != null && !table[newIndex].key.equals(key)) {
                    newIndex = getNextIndex(newIndex);
                }
                if (table[newIndex] == null) {
                    table[newIndex] = new Entry<>(key, value);
                    size++;
                } else {
                    table[newIndex].value = value;
                }
            }
        }
        if ((double) size / table.length >= LOAD_FACTOR) {
            rehash();
        }
    }

    public void remove(K key) {
        if (key == null) {
            return;
        }
        int index = getIndex(key);
        if (table[index] != null && table[index].key.equals(key)) {
            table[index] = null;
            size--;
        } else {
            int nextIndex = getNextIndex(index);
            while (table[nextIndex] != null && !table[nextIndex].key.equals(key)) {
                nextIndex = getNextIndex(nextIndex);
            }
            if (table[nextIndex] != null && table[nextIndex].key.equals(key)) {
                table[nextIndex] = null;
                size--;
            }
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    private int getNextIndex(int index) {
        return (index + 1) % table.length;
    }

    private void rehash() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[table.length * 2];
        size = 0;
        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
    }

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Size: " + map.size()); // 输出：3
        System.out.println("Value for key 'two': " + map.get("two")); // 输出：2

        map.remove("two");
        System.out.println("Size after removing key 'two': " + map.size()); // 输出：2
        System.out.println("Value for key 'two' after removal: " + map.get("two")); // 输出：null
    }
}

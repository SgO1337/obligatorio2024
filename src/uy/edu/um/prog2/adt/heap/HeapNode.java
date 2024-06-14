package uy.edu.um.prog2.adt.heap;

public class HeapNode<K, T extends Comparable<T>> {
    K key;
    T value;

    HeapNode(K key, T value) {
        this.key = key;
        this.value = value;
    }

    public int compareTo(HeapNode<K, T> other) {
        return this.value.compareTo(other.value);
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HeapNode{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
package uy.edu.um.prog2.adt.heap;

public interface MyHeap<K,T extends Comparable<T>> {
	T delete();

	HeapNode<K,T> get();
	
	void insert(T element);
	
	int size();
}

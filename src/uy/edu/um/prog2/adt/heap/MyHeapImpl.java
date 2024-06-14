package uy.edu.um.prog2.adt.heap;

public class MyHeapImpl<K, T extends Comparable<T>> implements MyHeap<K, T> {
	private static final int CAPACITY = 2;
	private int size;
	private HeapNode<K, T>[] heap;
	private boolean isHeapMin;

	public MyHeapImpl(boolean isHeapMin) {
		this.size = 0;
		this.heap = new HeapNode[CAPACITY];
		this.isHeapMin = isHeapMin;
	}

	public MyHeapImpl(int capacity) {
		this(capacity, true);
	}

	public MyHeapImpl(int capacity, boolean isHeapMin) {
		this.size = 0;
		this.heap = new HeapNode[capacity + 1];
		this.isHeapMin = isHeapMin;
	}

	public MyHeapImpl(T[] array) {
		this(array, true);
	}

	public MyHeapImpl(T[] array, boolean isHeapMin) {
		this.isHeapMin = isHeapMin;
		this.size = array.length;
		this.heap = new HeapNode[array.length + 1];

		for (int i = 0; i < array.length; i++) {
			this.heap[i + 1] = new HeapNode<>(null, array[i]);
		}

		buildHeap();
	}

	private void buildHeap() {
		for (int k = size / 2; k > 0; k--) {
			percolatingDown(k);
		}
	}

	private void percolatingDown(int k) {
		HeapNode<K, T> tmp = heap[k];
		int child;

		while (2 * k <= size) {
			child = 2 * k;

			if (child != size) {
				if (isHeapMin) {
					if (heap[child].compareTo(heap[child + 1]) > 0) {
						child++;
					}
				} else {
					if (heap[child].compareTo(heap[child + 1]) < 0) {
						child++;
					}
				}
			}

			if (isHeapMin) {
				if (tmp.compareTo(heap[child]) > 0) {
					heap[k] = heap[child];
				} else {
					break;
				}
			} else {
				if (tmp.compareTo(heap[child]) < 0) {
					heap[k] = heap[child];
				} else {
					break;
				}
			}

			k = child;
		}

		heap[k] = tmp;
	}

	public T delete() {
		if (size == 0) {
			throw new RuntimeException();
		}
		HeapNode<K, T> min = heap[1];
		heap[1] = heap[size--];
		percolatingDown(1);
		return min.value;
	}

	public HeapNode<K, T> get() {
		if (size == 0) {
			throw new RuntimeException();
		}
		return heap[1];
	}

	@Override
	public void insert(T element) {
		insert(null, element);
	}

	public void insert(K key, T x) {
		if (size == heap.length - 1) {
			doubleSize();
		}

		int pos = ++size;

		if (isHeapMin) {
			while (pos > 1 && x.compareTo(heap[pos / 2].value) < 0) {
				heap[pos] = heap[pos / 2];
				pos = pos / 2;
			}
		} else {
			while (pos > 1 && x.compareTo(heap[pos / 2].value) > 0) {
				heap[pos] = heap[pos / 2];
				pos = pos / 2;
			}
		}

		heap[pos] = new HeapNode<>(key, x);
	}

	private void doubleSize() {
		HeapNode<K, T>[] old = heap;
		heap = new HeapNode[heap.length * 2];
		System.arraycopy(old, 1, heap, 1, size);
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		for (int k = 1; k <= size; k++) {
			out.append(heap[k].value).append(" ");
		}
		return out.toString();
	}

	@Override
	public int size() {
		return size;
	}
}
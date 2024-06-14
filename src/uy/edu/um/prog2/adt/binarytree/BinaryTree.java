package uy.edu.um.prog2.adt.binarytree;

import java.util.List;

//@author pegardan

public interface BinaryTree<T extends Comparable<T>> {

	void add(T oElement) throws NodeAlreadyExists;

	void remove(T oElement);

	boolean contains(T oElement);

	T find(T oElement);
	
	List<T> preOrder();

	List<T> posOrder();

	List<T> inOrder();

}

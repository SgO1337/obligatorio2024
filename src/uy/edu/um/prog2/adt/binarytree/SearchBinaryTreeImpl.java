package uy.edu.um.prog2.adt.binarytree;

import java.util.ArrayList;
import java.util.List;

//@author pegardan

public class SearchBinaryTreeImpl<T extends Comparable<T>> implements
		BinaryTree<T> {

	private TreeNode<T> root;

	public void add(T oElement) throws NodeAlreadyExists {
		TreeNode<T> oElementToAdd = new TreeNode<T>(oElement);

		if (root == null) {

			root = oElementToAdd;

		} else {
			if(!inOrder().contains(oElement)) {
				root.add(oElement);
			} else {
				throw new NodeAlreadyExists();
			}
		}
	}

	public boolean contains(T oElement) {

		return contains(oElement, root);
	}

	private boolean contains(T oElementToSearch, TreeNode<T> oTree) {
		boolean bContains = false;
		
		if (oTree != null) {

			int nValue = oElementToSearch.compareTo(oTree.getValue());
					
			if (nValue == 0) {
				
				bContains = true;
			
			} else if (nValue > 0) {
				
				bContains = contains(oElementToSearch, oTree.getRight());
		
			} else {
				
				bContains = contains(oElementToSearch, oTree.getLeft());
			
			}

		}

		return bContains;
	}

	public T getMin(TreeNode<T> node) {
		if(root == null) {
			return null;
		}
		if(node == null) {
			node = root;
		}
		while(node.getLeft() != null) {
			node = node.getLeft();
		}
		return node.getValue();
	}

	public T getMax(TreeNode<T> node) {
		if(root == null) {
			return null;
		}
		if(node == null) {
			node = root;
		}
		while(node.getRight() != null) {
			node = node.getRight();
		}
		return node.getValue();
	}

	public TreeNode<T> remove(T oElement, TreeNode<T> node) {
		if(node == null) {
			return null;
		}
		if(oElement.compareTo(node.getValue()) < 0) {
			node.setLeft(remove(oElement, node.getLeft()));
		} else if (oElement.compareTo(node.getValue()) > 0) {
			node.setRigth(remove(oElement, node.getRight()));
		} else{
			//Caso el nodo tiene un hijo (o no tiene hijos)
			if(node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			}
			//Caso el nodo tiene dos hijos
			node.setValue(getMax(node.getLeft()));
			node.setLeft((remove(node.getValue(), node.getLeft())));
		}
		return node;
	}

	@Override
	public void remove(T oElement) {
		root = remove(oElement, root);
	}
	
	public T find(T oElement) {

		return find(oElement, root);
	}
	
	private T find(T oElementToSearch, TreeNode<T> oTree) {
		T oSearchedElement = null;
		
		if (oTree != null) {

			int nValue = oElementToSearch.compareTo(oTree.getValue());
					
			if (nValue == 0) {
				
				oSearchedElement = oTree.getValue();
			
			} else if (nValue > 0) {
				
				oSearchedElement = find(oElementToSearch, oTree.getRight());
		
			} else {
				
				oSearchedElement = find(oElementToSearch, oTree.getLeft());
			
			}

		}

		return oSearchedElement;
	}		

	public List<T> preOrder() {
		List<T> colValues = new ArrayList<T>();

		if (root != null) {

			colValues.addAll(root.preOrderTraverse());

		}

		return colValues;
	}

	public List<T> posOrder() {
		List<T> colValues = new ArrayList<T>();

		if (root != null) {

			colValues.addAll(root.postOrderTraverse());

		}

		return colValues;
	}

	public List<T> inOrder() {
		List<T> colValues = new ArrayList<T>();

		if (root != null) {

			colValues.addAll(root.inOrderTraverse());

		}

		return colValues;
	}

}

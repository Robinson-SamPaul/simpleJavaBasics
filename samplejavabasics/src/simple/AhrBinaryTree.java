package simple;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

public class AhrBinaryTree {

	public static void main(String[] args) {
		breadthFirstTrial();
		breadthFirstWithLevelTrial();

		inOrderWithStackTrial();
		inOrderWithRecursionTrial();

		preOrderWithStackTrial();
		preOrderWithRecursionTrial();

		postOrderWithStackTrial();
		postOrderWithRecursionTrial();
	}

	public static <T> void postOrderWithRecursion(BinaryTreeNode<T> root) {
		if (root == null) {
			return;
		}
		postOrderWithRecursion(root.getLeftChild());
		postOrderWithRecursion(root.getRightChild());
		System.out.print(root.getData() + "->");
	}

	public static void postOrderWithRecursionTrial() {
		BinaryTreeNode<String> a = new BinaryTreeNode<>("Alice");
		BinaryTreeNode<String> b = new BinaryTreeNode<>("Bob");
		BinaryTreeNode<String> c = new BinaryTreeNode<>("Charles");
		BinaryTreeNode<String> d = new BinaryTreeNode<>("Dora");
		BinaryTreeNode<String> e = new BinaryTreeNode<>("Elsa");
		BinaryTreeNode<String> f = new BinaryTreeNode<>("Fiona");
		BinaryTreeNode<String> g = new BinaryTreeNode<>("Greg");
		BinaryTreeNode<String> h = new BinaryTreeNode<>("Harry");
		BinaryTreeNode<String> i = new BinaryTreeNode<>("Irene");

		a.setLeftChild(b);
		a.setRightChild(c);

		System.out.println("\n");
		postOrderWithRecursion(a);

		b.setLeftChild(d);
		b.setRightChild(e);

		c.setLeftChild(f);
		c.setRightChild(g);

		System.out.println("\n");
		postOrderWithRecursion(a);

		d.setLeftChild(h);
		d.setRightChild(i);

		System.out.println("\n");
		postOrderWithRecursion(a);
	}

	public static <T> void postOrderWithStack(BinaryTreeNode<T> root) {

		if (root == null) {
			return;
		}

		Set<BinaryTreeNode<T>> visitedNodes = new HashSet<>();

		Stack<BinaryTreeNode<T>> stack = new Stack<>();

		stack.push(root);

		while (!stack.isEmpty()) {

			BinaryTreeNode<T> top = stack.pop();

			if (top.getLeftChild() == null && top.getRightChild() == null) {

				System.out.print(top + "->");

			} else if (visitedNodes.contains(top)) {

				System.out.print(top + "->");

			} else {

				visitedNodes.add(top);

				stack.push(top);

				if (top.getRightChild() != null) {
					stack.push(top.getRightChild());
				}

				if (top.getLeftChild() != null) {
					stack.push(top.getLeftChild());
				}
			}

		}
	}

	public static void postOrderWithStackTrial() {

		BinaryTreeNode<String> a = new BinaryTreeNode<>("Alice");
		BinaryTreeNode<String> b = new BinaryTreeNode<>("Bob");
		BinaryTreeNode<String> c = new BinaryTreeNode<>("Charles");
		BinaryTreeNode<String> d = new BinaryTreeNode<>("Dora");
		BinaryTreeNode<String> e = new BinaryTreeNode<>("Elsa");
		BinaryTreeNode<String> f = new BinaryTreeNode<>("Fiona");
		BinaryTreeNode<String> g = new BinaryTreeNode<>("Greg");
		BinaryTreeNode<String> h = new BinaryTreeNode<>("Harry");
		BinaryTreeNode<String> i = new BinaryTreeNode<>("Irene");

		a.setLeftChild(b);
		a.setRightChild(c);

		System.out.println("\n");
		postOrderWithStack(a);

		b.setLeftChild(d);
		b.setRightChild(e);

		c.setLeftChild(f);
		c.setRightChild(g);

		System.out.println("\n");
		postOrderWithStack(a);

		d.setLeftChild(h);
		d.setRightChild(i);

		System.out.println("\n");
		postOrderWithStack(a);
	}

	public static <T> void preOrderWithRecursion(BinaryTreeNode<T> root) {

		if (root == null) {
			return;
		}

		System.out.print(root.getData() + "->");

		preOrderWithRecursion(root.getLeftChild());
		preOrderWithRecursion(root.getRightChild());

	}

	public static void preOrderWithRecursionTrial() {

		BinaryTreeNode<String> a = new BinaryTreeNode<>("Alice");
		BinaryTreeNode<String> b = new BinaryTreeNode<>("Bob");
		BinaryTreeNode<String> c = new BinaryTreeNode<>("Charles");
		BinaryTreeNode<String> d = new BinaryTreeNode<>("Dora");
		BinaryTreeNode<String> e = new BinaryTreeNode<>("Elsa");
		BinaryTreeNode<String> f = new BinaryTreeNode<>("Fiona");
		BinaryTreeNode<String> g = new BinaryTreeNode<>("Greg");
		BinaryTreeNode<String> h = new BinaryTreeNode<>("Harry");
		BinaryTreeNode<String> i = new BinaryTreeNode<>("Irene");

		a.setLeftChild(b);
		a.setRightChild(c);

		System.out.println("\n");
		preOrderWithRecursion(a);

		b.setLeftChild(d);
		b.setRightChild(e);

		c.setLeftChild(f);
		c.setRightChild(g);

		System.out.println("\n");
		preOrderWithRecursion(a);

		d.setLeftChild(h);
		d.setRightChild(i);

		System.out.println("\n");
		preOrderWithRecursion(a);

	}

	public static void preOrderWithStackTrial() {

		BinaryTreeNode<String> a = new BinaryTreeNode<>("Alice");
		BinaryTreeNode<String> b = new BinaryTreeNode<>("Bob");
		BinaryTreeNode<String> c = new BinaryTreeNode<>("Charles");
		BinaryTreeNode<String> d = new BinaryTreeNode<>("Dora");
		BinaryTreeNode<String> e = new BinaryTreeNode<>("Elsa");
		BinaryTreeNode<String> f = new BinaryTreeNode<>("Fiona");
		BinaryTreeNode<String> g = new BinaryTreeNode<>("Greg");
		BinaryTreeNode<String> h = new BinaryTreeNode<>("Harry");

		a.setLeftChild(b);
		a.setRightChild(c);

		System.out.println("\n");
		preOrderWithStack(a);

		b.setLeftChild(d);

		System.out.println("\n");
		preOrderWithStack(a);

		c.setRightChild(e);

		System.out.println("\n");
		preOrderWithStack(a);

		d.setLeftChild(f);
		d.setRightChild(h);

		System.out.println("\n");
		preOrderWithStack(a);

		e.setRightChild(g);

		System.out.println("\n");
		preOrderWithStack(a);

	}

	public static <T> void preOrderWithStack(BinaryTreeNode<T> root) {

		if (root == null) {
			return;
		}

		Set<BinaryTreeNode<T>> visitedBinaryTreeNodes = new HashSet<>();

		Stack<BinaryTreeNode<T>> stack = new Stack<>();

		stack.push(root);

		while (!stack.isEmpty()) {

			BinaryTreeNode<T> top = stack.pop();

			if (top.getLeftChild() == null && top.getRightChild() == null) {

				System.out.print(top + "->");

			} else if (visitedBinaryTreeNodes.contains(top)) {

				System.out.print(top + "->");

			} else {

				visitedBinaryTreeNodes.add(top);

				if (top.getRightChild() != null) {
					stack.push(top.getRightChild());
				}

				if (top.getLeftChild() != null) {
					stack.push(top.getLeftChild());
				}

				stack.push(top);
			}
		}
	}

	private static void inOrderWithRecursionTrial() {
		BinaryTreeNode<String> a = new BinaryTreeNode<>("Alice");
		BinaryTreeNode<String> b = new BinaryTreeNode<>("Bob");
		BinaryTreeNode<String> c = new BinaryTreeNode<>("Charles");
		BinaryTreeNode<String> d = new BinaryTreeNode<>("Dora");
		BinaryTreeNode<String> e = new BinaryTreeNode<>("Elsa");
		BinaryTreeNode<String> f = new BinaryTreeNode<>("Fiona");
		BinaryTreeNode<String> g = new BinaryTreeNode<>("Greg");
		BinaryTreeNode<String> h = new BinaryTreeNode<>("Harry");
		BinaryTreeNode<String> i = new BinaryTreeNode<>("Irene");

		a.setLeftChild(b);
		a.setRightChild(c);

		System.out.println("\n");
		inOrderWithRecursion(a);

		b.setLeftChild(d);
		b.setRightChild(e);

		c.setLeftChild(f);
		c.setRightChild(g);

		System.out.println("\n");
		inOrderWithRecursion(a);

		d.setLeftChild(h);
		d.setRightChild(i);

		System.out.println("\n");
		inOrderWithRecursion(a);
	}

	public static <T> void inOrderWithRecursion(BinaryTreeNode<T> root) {

		if (root == null) {
			return;
		}

		inOrderWithStack(root.getLeftChild());

		System.out.print(root.getData() + "->");

		inOrderWithStack(root.getRightChild());
	}

	private static void inOrderWithStackTrial() {

		/*
		       A
		      / \
		     B   C
		    / \ / \
		   D   EF  G
		  / \   
		 H   I   
		 */
		BinaryTreeNode<String> a = new BinaryTreeNode<>("Alice");
		BinaryTreeNode<String> b = new BinaryTreeNode<>("Bob");
		BinaryTreeNode<String> c = new BinaryTreeNode<>("Charles");
		BinaryTreeNode<String> d = new BinaryTreeNode<>("Dora");
		BinaryTreeNode<String> e = new BinaryTreeNode<>("Elsa");
		BinaryTreeNode<String> f = new BinaryTreeNode<>("Fiona");
		BinaryTreeNode<String> g = new BinaryTreeNode<>("Greg");
		BinaryTreeNode<String> h = new BinaryTreeNode<>("Harry");
		BinaryTreeNode<String> i = new BinaryTreeNode<>("Irene");

		a.setLeftChild(b);
		a.setRightChild(c);

		System.out.println("\n");
		inOrderWithStack(a);

		b.setLeftChild(d);
		b.setRightChild(e);

		c.setLeftChild(f);
		c.setRightChild(g);

		System.out.println("\n");
		inOrderWithStack(a);

		d.setLeftChild(h);
		d.setRightChild(i);

		System.out.println("\n");
		inOrderWithStack(a);
	}

	public static <T> void inOrderWithStack(BinaryTreeNode<T> root) {

		if (root == null) {
			return;
		}

		Set<BinaryTreeNode<T>> visitedBinaryTreeNodes = new HashSet<>();

		Stack<BinaryTreeNode<T>> stack = new Stack<>();

		stack.push(root);

		while (!stack.isEmpty()) {

			BinaryTreeNode<T> top = stack.pop();

			if (top.getLeftChild() == null && top.getRightChild() == null) {

				System.out.print(top + "->");

			} else if (visitedBinaryTreeNodes.contains(top)) {

				System.out.print(top + "->");

			} else {

				visitedBinaryTreeNodes.add(top);

				if (top.getRightChild() != null) {
					stack.push(top.getRightChild());
				}

				stack.push(top);

				if (top.getLeftChild() != null) {
					stack.push(top.getLeftChild());
				}
			}

		}
	}

	private static void breadthFirstWithLevelTrial() {
		// TODO Auto-generated method stub
		BinaryTreeNode<String> a = new BinaryTreeNode<>("Alice");
		BinaryTreeNode<String> b = new BinaryTreeNode<>("Bob");
		BinaryTreeNode<String> c = new BinaryTreeNode<>("Charles");
		BinaryTreeNode<String> d = new BinaryTreeNode<>("Dora");
		BinaryTreeNode<String> e = new BinaryTreeNode<>("Elsa");
		BinaryTreeNode<String> f = new BinaryTreeNode<>("Fiona");
		BinaryTreeNode<String> g = new BinaryTreeNode<>("Greg");
		BinaryTreeNode<String> h = new BinaryTreeNode<>("Harry");

		a.setLeftChild(b);
		a.setRightChild(c);

		System.out.println("\n");
		breadthFirstWithLevel(a);

		b.setLeftChild(d);

		System.out.println("\n");
		breadthFirstWithLevel(a);

		c.setRightChild(e);

		System.out.println("\n");
		breadthFirstWithLevel(a);

		d.setLeftChild(f);
		d.setRightChild(h);

		System.out.println("\n");
		breadthFirstWithLevel(a);

		e.setRightChild(g);

		System.out.println("\n");
		breadthFirstWithLevel(a);
	}

	private static void breadthFirstTrial() {
		BinaryTreeNode<Character> a = new BinaryTreeNode<>('A');
		BinaryTreeNode<Character> b = new BinaryTreeNode<>('B');
		BinaryTreeNode<Character> c = new BinaryTreeNode<>('C');
		BinaryTreeNode<Character> d = new BinaryTreeNode<>('D');
		BinaryTreeNode<Character> e = new BinaryTreeNode<>('E');
		BinaryTreeNode<Character> f = new BinaryTreeNode<>('F');
		BinaryTreeNode<Character> g = new BinaryTreeNode<>('G');
		BinaryTreeNode<Character> h = new BinaryTreeNode<>('H');

		a.setLeftChild(b);
		a.setRightChild(c);

		System.out.println("\n");
		breadthFirst(a);

		c.setLeftChild(d);
		c.setRightChild(e);

		System.out.println("\n");
		breadthFirst(a);

		d.setLeftChild(f);
		d.setRightChild(g);

		System.out.println("\n");
		breadthFirst(a);

		e.setRightChild(h);

		/*
		       A
		      / \
		     B   C
		        / \
		       D   E
		      / \   \
		     F   H   G
		 */
		System.out.println("\n");
		breadthFirst(a);
	}

	public static <T> void breadthFirst(BinaryTreeNode<T> root) {

		if (root == null) {
			return;
		}

		Queue<BinaryTreeNode<T>> queue = new LinkedList<>();

		queue.add(root);

		while (!queue.isEmpty()) {

			BinaryTreeNode<T> node = queue.remove();
			System.out.print(node); // P

			if (node.getLeftChild() != null) {
				queue.add(node.getLeftChild()); // L
			}

			if (node.getRightChild() != null) {
				queue.add(node.getRightChild()); // R
			}

		}
	}

	public static <T> void breadthFirstWithLevel(BinaryTreeNode<T> root) {

		if (root == null) {
			return;
		}

		Queue<BinaryTreePair<BinaryTreeNode<T>, Integer>> queue = new LinkedList<>();

		int level = 0;
		queue.add(new BinaryTreePair<>(root, level));

		while (!queue.isEmpty()) {

			BinaryTreePair<BinaryTreeNode<T>, Integer> pair = queue.remove();
			System.out.print(pair + "->");

			level = pair.getValue() + 1;

			BinaryTreeNode<T> leftChild = pair.getKey().getLeftChild();
			if (leftChild != null) {
				queue.add(new BinaryTreePair<>(leftChild, level));
			}

			BinaryTreeNode<T> rightChild = pair.getKey().getRightChild();
			if (rightChild != null) {
				queue.add(new BinaryTreePair<>(rightChild, level));
			}

		}
	}

}

class BinaryTreeNode<T> {

	private T data;

	private BinaryTreeNode<T> leftChild;
	private BinaryTreeNode<T> rightChild;

	public BinaryTreeNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public BinaryTreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return data.toString() + "->";
	}
}

class BinaryTreePair<K, V> {

	private K key;
	private V value;

	public BinaryTreePair(K key, V value) {

		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "{" + key + " ," + value + "}";
	}

}

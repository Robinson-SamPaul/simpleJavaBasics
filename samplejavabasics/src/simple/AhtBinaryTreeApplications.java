package simple;

import static simple.AhrBinaryTree.breadthFirst;
import static simple.AhrBinaryTree.inOrderWithRecursion;

public class AhtBinaryTreeApplications {

	public static void main(String[] args) {
		insertTrial();
	}

	public static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data) {
		if (root == null) {
			return new BinaryTreeNode<Integer>(data);
		}
		if (data <= root.getData()) {
			root.setLeftChild(insert(root.getLeftChild(), data));
		} else {
			root.setRightChild(insert(root.getRightChild(), data));
		}
		return root;
	}

	public static BinaryTreeNode<Integer> lookup(BinaryTreeNode<Integer> root, int data) {
		if (root == null) {
			return null;
		}
		if (root.getData() == data) {
			return root;
		}
		if (data <= root.getData()) {
			System.out.println(data + " <= " + root.getData() + " looking in the left subtree");
			return lookup(root.getLeftChild(), data);
		} else {
			System.out.println(data + " > " + root.getData() + " looking in the right subtree");
			return lookup(root.getRightChild(), data);
		}
	}

	public static Integer minimumValue(BinaryTreeNode<Integer> root) {
		int minValue = Integer.MAX_VALUE;
		while (root != null) {
			minValue = root.getData();
			System.out.println("Currently at BinaryTreeNode: " + minValue + " going into the left subtree");
			root = root.getLeftChild();
		}
		return minValue;
	}

	public static Integer maximumValue(BinaryTreeNode<Integer> root) {
		int maxValue = Integer.MIN_VALUE;
		while (root != null) {
			maxValue = root.getData();
			System.out.println("Currently at BinaryTreeNode: " + maxValue + " going into the right subtree");
			root = root.getRightChild();
		}
		return maxValue;
	}

	public static void printRange(BinaryTreeNode<Integer> root, int low, int high) {
		if (root == null) {
			return;
		}
		if (low <= root.getData()) {
			printRange(root.getLeftChild(), low, high);
		}
		if (low <= root.getData() && root.getData() <= high) {
			System.out.println(root.getData());
		}
		if (high > root.getData()) {
			printRange(root.getRightChild(), low, high);
		}
	}

	public static boolean isBinarySearchTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return true;
		}
		if (root.getLeftChild() != null) {
			if (root.getLeftChild().getData() > root.getData()) {
				return false;
			}
		}
		if (root.getRightChild() != null) {
			if (root.getRightChild().getData() <= root.getData()) {
				return false;
			}
		}
		return isBinarySearchTree(root.getLeftChild()) && isBinarySearchTree(root.getRightChild());
	}

	private static void insertTrial() {
		BinaryTreeNode<Integer> eight = new BinaryTreeNode<>(8);

		insert(eight, 3);
		insert(eight, 10);

		System.out.println("\n");
		breadthFirst(eight);

		insert(eight, 1);
		insert(eight, 14);

		System.out.println("\n");
		breadthFirst(eight);

		insert(eight, 6);
		insert(eight, 4);
		insert(eight, 7);
		insert(eight, 13);

		System.out.println("\n");
		breadthFirst(eight);

		System.out.println("\n\nIn-order");
		inOrderWithRecursion(eight);

		insert(eight, 2);
		System.out.println("\n");
		breadthFirst(eight);

		insert(eight, 12);
		System.out.println("\n");
		breadthFirst(eight);

		System.out.println("\n\nStill in-order");
		inOrderWithRecursion(eight);
	}

}

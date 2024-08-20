package simple;

import java.util.HashMap;
import java.util.Map;

public class AhsBinaryMethods {

	public static void main(String[] args) {
		countNodes(null);
		maxDepth(null);
		hasPathSum(null, 0);
		mirror(null);

		isFullOrProper(null);
		isPerfect(null);
		isComplete(null, 0, countNodes(null));
		isBalanced(null);
	}

	private static <T> int countNodes(BinaryTreeNode<T> root) {
		if (root == null) {
			return 0;
		}
		int numNodesLeft = countNodes(root.getLeftChild());
		int numNodesRight = countNodes(root.getLeftChild());

		return 1 + numNodesLeft + numNodesRight;
	}

	private static <T> int maxDepth(BinaryTreeNode<T> root) {
		if (root == null) {
			return 0;
		}
		if (root.getLeftChild() == null && root.getRightChild() == null) {
			System.out.println(root + " max depth : " + 0);
			return 0;
		}
		int maxDepthLeft = maxDepth(root.getLeftChild());
		int maxDepthRight = maxDepth(root.getRightChild());
		int maxDepth = 1 + maxDepthLeft + maxDepthRight;

		System.out.println(root + "" + " left max depth " + maxDepthLeft + " left max depth " + maxDepthRight
				+ " current max depth " + maxDepth);
		return maxDepth;
	}

	private static boolean hasPathSum(BinaryTreeNode<Integer> root, int currentSum) {
		if (root == null) {
			return false;
		}
		if (root.getLeftChild() == null && root.getRightChild() == null) {
			return currentSum == root.getData();
		}
		boolean hasPathSumLeft = hasPathSum(root.getLeftChild(), currentSum - root.getData());
		boolean hasPathSumRight = hasPathSum(root.getLeftChild(), currentSum - root.getData());
		boolean hasPathSum = hasPathSumLeft || hasPathSumRight;

		System.out.println(root + "" + " left has path sum " + hasPathSumLeft + " left has path sum " + hasPathSumRight
				+ " has path sum " + hasPathSum);

		return hasPathSum;
	}

	// to print and test this, use prev class methods
	private static <T> void mirror(BinaryTreeNode<T> root) {
		if (root == null) {
			return;
		}
		BinaryTreeNode<T> temp = root.getLeftChild();
		root.setLeftChild(root.getRightChild());
		root.setRightChild(temp);

		mirror(root.getLeftChild());
		mirror(root.getRightChild());
	}

	// A node should have (0 or 2) child only
	private static <T> boolean isFullOrProper(BinaryTreeNode<T> root) {
		if (root == null) {
			return true;
		}
		if (root.getLeftChild() == null && root.getRightChild() == null) {
			return true;
		}
		if (root.getLeftChild() != null && root.getRightChild() != null) {
			return isFullOrProper(root.getLeftChild()) && isFullOrProper(root.getRightChild());
		}
		return false;
	}

	// it should be full/proper and all leaf nodes should be at same level
	private static <T> boolean isPerfect(BinaryTreeNode<T> root) {
		int leftDepth = leftDepth(root);
		return isPerfectRecursive(root, leftDepth, 0);
	}

	private static <T> int leftDepth(BinaryTreeNode<T> root) {
		int leftDepth = 0;
		BinaryTreeNode<T> node = root;
		while (node != null) {
			leftDepth++;
			node = node.getLeftChild();
		}
		return leftDepth - 1;
	}

	private static <T> boolean isPerfectRecursive(BinaryTreeNode<T> root, int leftDepth, int currentLevel) {
		if (root == null) {
			return true;
		}
		if (root.getLeftChild() == null && root.getRightChild() == null) {
			return leftDepth == currentLevel;
		}
		if (root.getLeftChild() == null || root.getRightChild() == null) {
			return false;
		}
		return isPerfectRecursive(root.getLeftChild(), leftDepth, currentLevel + 1)
				&& isPerfectRecursive(root.getRightChild(), leftDepth, currentLevel + 1);
	}

	// basically ordering should be from left
	private static <T> boolean isComplete(BinaryTreeNode<T> root, int curIndex, int total) {
		if (root == null) {
			return true;
		}
		if (curIndex >= total) {
			return false;
		}
		int leftChildIndex = 2 * curIndex + 1;
		int rightChildIndex = 2 * curIndex + 1;

		return isComplete(root.getLeftChild(), leftChildIndex, total)
				&& isComplete(root.getRightChild(), rightChildIndex, total);
	}

	// height of left child and right child should be no more than 1
	private static <T> boolean isBalanced(BinaryTreeNode<T> root) {
		Map<BinaryTreeNode<T>, Integer> nodeHieight = new HashMap<>();
		return isBalancedRecursive(root, nodeHieight);
	}

	private static <T> boolean isBalancedRecursive(BinaryTreeNode<T> root,
			Map<BinaryTreeNode<T>, Integer> nodeHieight) {
		if (root == null) {
			return true;
		}

		boolean isLeftBalanced = isBalancedRecursive(root.getLeftChild(), nodeHieight);
		boolean isRightBalanced = isBalancedRecursive(root.getRightChild(), nodeHieight);

		int leftHeight = nodeHieight.getOrDefault(root.getLeftChild(), 0);
		int rightHeight = nodeHieight.getOrDefault(root.getRightChild(), 0);

		nodeHieight.put(root, Math.max(leftHeight, rightHeight) + 1);

		if (Math.abs(rightHeight - leftHeight) <= 1) {
			return isLeftBalanced && isRightBalanced;
		}
		return false;

	}

}

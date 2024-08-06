package simple;

public class AhpBinaryTree {
	
	public static void main(String[] args) {
		System.out.println("A tree can have multiple nodes");
		System.out.println("A binary tree can have 0-2 nodes");
		System.out.println(""
				+ "Parent is called Root node"
				+ "Last child is called leaf node"
				+ "Intermediate nodes are called internal nodes"
				+ "Connectors are called Edge"
				+ "Nodes with same Parent nodes are called Sibling nodes"
				+ "Height of the node is count of edges until it reaches leaf node"
				+ "Height of the parent node is N"
				+ "And N means, let's say Multiple leaf nodes are there, then longest path is N, not the shortest"
				+ "which means long distance leaf node has to be calculated, not nearby leaf node"
				+ "Height of the leaf node is 0"
				+ "Depth of the node is count of edges until it reaches root node"
				+ "Depth of the root node is 0"
				+ "Depth of the leaf node is N");
		
		System.out.println("Linear data structures are data structures "
				+ "where elements are arranged sequentially, one after the other. "
				+ "Each element has a unique predecessor (1st) and a unique successor (last).");
		System.out.println(""
				+ "Sequential Access: Elements are accessed in a specific order.\r\n"
				+ "Single Level: They are a single-level data structure."
				+ "Example: Array, Stack, Queue, LinkedList");
		
		System.out.println("Non-linear data structures are data structures where elements are not arranged sequentially. "
				+ "They are organized in a hierarchical manner and each element can be connected to multiple elements, reflecting complex relationships."
				+ "Non-Sequential Access: Elements can be accessed in various orders.\r\n"
				+ "Multiple Levels: They often have multiple levels or a hierarchical structure."
				+ "Example: Tree, Graph");
		
		System.out.println("Breadth-First Traversal"
				+ "Breadth-First Traversal visits all the nodes of a tree level by level, from left to right."
				+ "Start from the root"
				+ "Visit all nodes at the current level before moving to the next level"
				+ "Use a queue to keep track of nodes to be visited");
		
		System.out.println("Depth-First Traversal ");
			//Shortcut to remember - PLR(ParentLeftRight)
			System.out.println("Depth-First Pre-order Traversal"
					+ "Visit the root, then recursively visit the left subtree, and finally the right subtree."
					+ "Order: Root -> Left -> Right");
			
			//Shortcut to remember - LPR
			System.out.println("Depth-First In-order Traversal"
					+ "Recursively visit the left subtree, then visit the root, and finally the right subtree."
					+ "Order: Left -> Root -> Right");
			
			//Shortcut to remember - LRP
			System.out.println("Depth-First Post-order Traversal"
					+ "Recursively visit the left subtree, then the right subtree, and finally the root."
					+ "Left -> Right -> Root");
		
			//Consider below Tree
			/*
	               1
			      / \
			     2   3
			    / \   \
			   4   5   6
			 				*//*
			
			Breadth-First Traversal (Level-Order): 1, 2, 3, 4, 5, 6
			Pre-order Traversal: 1, 2, 4, 5, 3, 6
			In-order Traversal: 4, 2, 5, 1, 3, 6
			Post-order Traversal: 4, 5, 2, 6, 3, 1
			
			*/
			/*
			Breadth-First Traversal (BFT): Level by level (uses a queue)
			Depth-First Pre-order Traversal: Root -> Left -> Right
			Depth-First In-order Traversal: Left -> Root -> Right
			Depth-First Post-order Traversal: Left -> Right -> Root
			*/

	}
}
